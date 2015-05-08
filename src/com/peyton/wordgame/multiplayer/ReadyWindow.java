package com.peyton.wordgame.multiplayer;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.peyton.wordgame.game.GameWindow;
import com.peyton.wordgame.util.Utilities;

public class ReadyWindow extends JFrame implements ActionListener {
	private String name1, name2;
	/**
	 * 0 For Player 1 <br>
	 * 1 For Player 2
	 */
	private int currentPlayer;
	private String readyPlayer;

	private JPanel readyTitle, buttonPanel;
	private JLabel title;
	private JButton button;

	public ReadyWindow(String name1, String name2, int currentPlayer) {
		this.name1 = name1;
		this.name2 = name2;
		this.currentPlayer = currentPlayer;
		readyPlayer = (currentPlayer == 0) ? name1: name2;
		
	
		
		initWindow();
	}

	private void initWindow() {
		setMinimumSize(new Dimension(300,400));
		setLayout(new GridLayout(2, 1));
		readyTitle = new JPanel();
		title = new JLabel("<html>"+readyPlayer + "<br>Are You Ready?</html>");
		title.setFont(Utilities.TITLE_FONT);
		readyTitle.add(title);
		add(readyTitle);

		buttonPanel = new JPanel();
		button = new JButton("READY!");
		button.addActionListener(this);
		buttonPanel.add(button);
		add(buttonPanel);

		pack();
		setLocationRelativeTo(null);
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource().equals(button)){
			setVisible(false);
			new GameWindow(readyPlayer);
		}
		
	}
}
