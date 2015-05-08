package com.peyton.wordgame.game;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.peyton.wordgame.util.Utilities;

public class GameWindow extends JFrame implements ActionListener{
	private JPanel wordPanel, inputPanel, lifePanel;
	private JLabel answerWord;
	private JLabel[] lives;
	private JTextField guessField;
	private JButton submitButton;
	private String playerName;
	
	public GameWindow(String playerName){
		initFrame();
		this.playerName = playerName;
	}
	
	private void initFrame(){
		setMinimumSize(new Dimension(300,400));
		setLayout(new GridLayout(3,1));
		wordPanel = new JPanel();
		answerWord = new JLabel();
		answerWord.setFont(Utilities.TITLE_FONT);
		wordPanel.add(answerWord);
		add(wordPanel);
		
		inputPanel = new JPanel();
		guessField = new JTextField();
		submitButton = new JButton ("Submit");
		submitButton.addActionListener(this);
		inputPanel.setLayout(new GridLayout(2,1));
		inputPanel.add(guessField);
		inputPanel.add(submitButton);
		add(inputPanel);
		
		lifePanel = new JPanel();
		lives = new JLabel[4];
		for(JLabel l: lives){
			l = new JLabel("Life");
			lifePanel.add(l);
		}
		add(lifePanel);
		
		pack();
		setVisible(true);
		setLocationRelativeTo(null);
	}
	

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource().equals(submitButton)){
			System.out.println("Button");
		}
		
	}
}
