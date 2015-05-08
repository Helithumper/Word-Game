package com.peyton.wordgame.multiplayer;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import com.peyton.wordgame.util.StaticStorage;

public class PlayerIntializationWindow extends JFrame implements ActionListener {
	private JLabel player1NameLabel, player2NameLabel;
	private JTextField player1Name, player2Name;
	private JButton submitButton;
	private JPanel inputPanel, buttonPanel;

	public PlayerIntializationWindow() {
		initWindow();
	}

	private void initWindow() {
		setLayout(new GridLayout(2, 1));
		inputPanel = new JPanel();
		player1NameLabel = new JLabel("Player 1:");
		player2NameLabel = new JLabel("Player 2:");
		player1Name = new JTextField();
		player2Name = new JTextField();
		inputPanel.setLayout(new GridLayout(2, 2));
		inputPanel.add(player1NameLabel);
		inputPanel.add(player1Name);
		inputPanel.add(player2NameLabel);
		inputPanel.add(player2Name);
		player1Name.setColumns(10);
		player2Name.setColumns(10);
		add(inputPanel);

		buttonPanel = new JPanel();
		buttonPanel.setLayout(new BorderLayout());
		submitButton = new JButton("Submit");
		submitButton.addActionListener(this);
		buttonPanel.add(submitButton, SwingConstants.CENTER);
		add(buttonPanel);

		setLocationRelativeTo(null);
		pack();
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(submitButton)) {
			setVisible(false);
			StaticStorage.playerNames[0] = player1Name.getText();
			StaticStorage.playerNames[1] = player2Name.getText();
			new ReadyWindow(0);
		}

	}
}
