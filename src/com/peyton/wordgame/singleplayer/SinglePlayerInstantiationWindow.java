package com.peyton.wordgame.singleplayer;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.peyton.wordgame.multiplayer.ReadyWindow;
import com.peyton.wordgame.util.StaticStorage;

public class SinglePlayerInstantiationWindow extends JFrame implements
		ActionListener {
	private JPanel mainPanel;
	private JLabel textLabel;
	private JButton submitButton;
	private JTextField inputField;

	public SinglePlayerInstantiationWindow() {
		initFrame();
	}

	private void initFrame() {
		setSize(new Dimension(400,600));
		mainPanel = new JPanel();
		textLabel = new JLabel("<html>Please Enter<br>Your Name:</html>");
		inputField = new JTextField();
		submitButton = new JButton("Submit");
		submitButton.addActionListener(this);
		mainPanel.setLayout(new GridLayout(3, 1));
		mainPanel.add(textLabel);
		mainPanel.add(inputField);
		inputField.addActionListener(this);
		mainPanel.add(submitButton);
		add(mainPanel);

		pack();
		setVisible(true);
		setLocationRelativeTo(null);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(submitButton)
				|| e.getSource().equals(inputField)) {
			StaticStorage.playerNames[0] = inputField.getText();
			StaticStorage.playerScores[0] = 0;
			new ReadyWindow(0, true);
		}

	}
}
