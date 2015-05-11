package com.peyton.wordgame.game;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import com.peyton.wordgame.menus.MainMenu;
import com.peyton.wordgame.multiplayer.ReadyWindow;
import com.peyton.wordgame.util.StaticStorage;
import com.peyton.wordgame.util.Utilities;

public class EndGamePanel extends JFrame implements ActionListener {
	private boolean isWinner;
	private int currentPlayerID;
	private JPanel titlePanel, buttonsPanel;
	private JLabel titleLabel, scoresLabel;
	private JButton mainMenuButton, nextRoundButton;
	private String answer;

	public EndGamePanel(boolean winner, int currentPlayerID, String answer) {
		isWinner = winner;
		this.answer = answer;
		this.currentPlayerID = currentPlayerID;
		initWindow();
	}

	private void initWindow() {
		setResizable(false);
		setMinimumSize(new Dimension(600, 400));
		setLayout(new GridLayout(2, 1));
		titlePanel = new JPanel();
		buttonsPanel = new JPanel();
		scoresLabel = new JLabel("<html>" + StaticStorage.playerNames[0] + ": "
				+ StaticStorage.playerScores[0] + "<br>"
				+ StaticStorage.playerNames[1] + ": "
				+ StaticStorage.playerScores[1] + "</html>");
		scoresLabel.setFont(Utilities.TITLE_FONT);
		mainMenuButton = new JButton("Main Menu");
		nextRoundButton = new JButton("Start Next Round");
		if (isWinner) {
			titleLabel = new JLabel("Winner! The Answer was " +answer.toUpperCase());

		} else {
			titleLabel = new JLabel("LOSER! The Answer was "
					+ answer.toUpperCase());
		}
		titleLabel.setFont(Utilities.TITLE_FONT);
		titlePanel.setLayout(new GridLayout(2, 1));
		titlePanel.add(titleLabel);
		titlePanel.add(scoresLabel);
		scoresLabel.setHorizontalAlignment(SwingConstants.CENTER);
		buttonsPanel.setLayout(new GridLayout(1, 2));

		buttonsPanel.add(mainMenuButton);
		if (isWinner) {
			buttonsPanel.add(nextRoundButton);
			nextRoundButton.addActionListener(this);
		}
		mainMenuButton.addActionListener(this);

		add(titlePanel);
		add(buttonsPanel);

		pack();
		setLocationRelativeTo(null);
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(mainMenuButton)) {
			setVisible(false);
			StaticStorage.emptyScorePlayer();
			new MainMenu();
		}
		if (e.getSource().equals(nextRoundButton)) {
			setVisible(false);
			int nextPlayer = (currentPlayerID == 0) ? 1 : 0;
			new ReadyWindow(nextPlayer);
		}

	}

}
