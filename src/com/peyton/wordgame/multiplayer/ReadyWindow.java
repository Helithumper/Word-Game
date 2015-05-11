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
import com.peyton.wordgame.util.StaticStorage;
import com.peyton.wordgame.util.Utilities;

public class ReadyWindow extends JFrame implements ActionListener {

	/**
	 * 0 For Player 1 <br>
	 * 1 For Player 2
	 */
	private int currentPlayer;
	private String readyPlayer;

	private JPanel readyTitle, buttonPanel;
	private JLabel title;
	private JButton button;
	private boolean isSingle = false;

	public ReadyWindow(int currentPlayer) {
		this.currentPlayer = currentPlayer;
		readyPlayer = (currentPlayer == 0) ? StaticStorage.playerNames[0]
				: StaticStorage.playerNames[1];

		initWindow();
	}

	public ReadyWindow(int currentPlayer, boolean isSingle) {
		this.currentPlayer = currentPlayer;
		this.isSingle = isSingle;
		readyPlayer = StaticStorage.playerNames[0];

		initWindow();
	}

	private void initWindow() {
		setResizable(false);
		setMinimumSize(new Dimension(300, 400));
		setLayout(new GridLayout(2, 1));
		readyTitle = new JPanel();
		title = new JLabel("<html>" + readyPlayer + "<br>Are You Ready?</html>");
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
		if (e.getSource().equals(button)) {
			setVisible(false);
			if (isSingle) {
				new GameWindow(2);
			} else {
				new GameWindow(currentPlayer);
			}
		}

	}
}
