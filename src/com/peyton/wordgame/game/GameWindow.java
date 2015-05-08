package com.peyton.wordgame.game;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.peyton.wordgame.util.StaticStorage;
import com.peyton.wordgame.util.Utilities;

public class GameWindow extends JFrame implements ActionListener {
	private JPanel wordPanel, inputPanel, lifePanel;
	private JLabel answerWord;
	private JLabel[] lives;
	private JTextField guessField;
	private JButton submitButton;
	private int currentPlayerID;
	private String answerWordString;
	private int numLivesLost = 0;

	public GameWindow(int currentPlayerID) {

		this.currentPlayerID = currentPlayerID;
		Random rand = new Random();
		answerWordString = StaticStorage.dict.getWord((rand.nextInt(1001)))
				.toLowerCase();
		initFrame();
		System.out.println(answerWordString);
	}

	private void initFrame() {
		setMinimumSize(new Dimension(300, 400));
		setLayout(new GridLayout(3, 1));
		wordPanel = new JPanel();
		answerWord = new JLabel();
		answerWord.setFont(Utilities.TITLE_FONT);
		for (int i = 0; i < answerWordString.length(); i++) {
			answerWord.setText(answerWord.getText() + "-");
		}

		wordPanel.add(answerWord);
		add(wordPanel);

		inputPanel = new JPanel();
		guessField = new JTextField();
		submitButton = new JButton("Submit");
		submitButton.addActionListener(this);
		inputPanel.setLayout(new GridLayout(2, 1));
		inputPanel.add(guessField);
		inputPanel.add(submitButton);
		add(inputPanel);

		lifePanel = new JPanel();
		lives = new JLabel[4];
		for (int i = 0; i < lives.length; i++) {
			lives[i] = new JLabel("Life");
			lifePanel.add(lives[i]);
		}
		add(lifePanel);

		pack();
		setVisible(true);
		setLocationRelativeTo(null);

		System.out.println(Arrays.toString(lives));
	}

	private void setHint() {
		String result = "";

		for (int i = 0; i < answerWordString.length(); i++) {
			if (guessField.getText().charAt(i) == answerWordString.charAt(i))
				result += guessField.getText().charAt(i);
			else if (answerWordString.indexOf(guessField.getText().charAt(i)) != -1) {
				result += "^";
			} else {
				result += "*";
			}
		}
		updateLives();

		answerWord.setText(result);
	}

	private void updateLives() {
		numLivesLost++;
		if (numLivesLost == 4) {
			setVisible(false);
			new EndGamePanel(false, currentPlayerID);
		}
		lives[lives.length - numLivesLost].setText("NOT HERE");

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(submitButton)) {
			if (guessField.getText().length() != answerWordString.length()) {
				Utilities.throwErrorBox(
						"Your Guess is not the same length as the answer",
						"Length Error");
			} else if (guessField.getText().equals(answerWordString)) {
				endGame();
			} else {
				setHint();
			}
		}

	}

	private void endGame() {
		setVisible(false);
		StaticStorage.playerScores[currentPlayerID]++;
		new EndGamePanel(true, currentPlayerID);
	}
}
