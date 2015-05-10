package com.peyton.wordgame.menus;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import com.peyton.wordgame.gamestates.SinglePlayerGameWindow;
import com.peyton.wordgame.multiplayer.PlayerIntializationWindow;
import com.peyton.wordgame.singleplayer.SinglePlayerInstantiationWindow;
import com.peyton.wordgame.util.Utilities;

public class MainMenu extends JFrame implements ActionListener {
	private JPanel titlePanel, buttonPanel;
	private JLabel titleLabel;
	private JButton singlePlayerButton, multiPlayerButton, howToButton,
			aboutButton;

	public MainMenu() {
		initFrame();
	}

	private void initFrame() {
		setResizable(false);
		setLayout(new GridLayout(2, 1));
		setMinimumSize(new Dimension(400, 400));

		// TitlePanel
		titlePanel = new JPanel();
		titleLabel = new JLabel("Word Game");
		titleLabel.setFont(Utilities.TITLE_FONT);
		titleLabel.setVerticalTextPosition(SwingConstants.CENTER);
		titlePanel.add(titleLabel);
		add(titlePanel);

		// Buttons Panel
		buttonPanel = new JPanel();
		buttonPanel.setLayout(new GridLayout(4, 1));
		singlePlayerButton = new JButton("Single Player");
		multiPlayerButton = new JButton("Multiplayer");
		howToButton = new JButton("How To Play");
		howToButton.addActionListener(this);
		aboutButton = new JButton("About");
		aboutButton.addActionListener(this);
		buttonPanel.add(singlePlayerButton);
		singlePlayerButton.addActionListener(this);
		buttonPanel.add(multiPlayerButton);
		multiPlayerButton.addActionListener(this);
		buttonPanel.add(howToButton);
		buttonPanel.add(aboutButton);
		add(buttonPanel);

		setLocationRelativeTo(null);
		pack();
		setVisible(true);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(aboutButton)) {
			Utilities.throwErrorBox("About Box", "About Title");
		}
		if (e.getSource().equals(howToButton)) {
			Utilities.openInBrowser("https://Helithumper.github.io/howto.html");
		}
		if (e.getSource().equals(singlePlayerButton)) {
			setVisible(false);
			new SinglePlayerInstantiationWindow();
		}
		if (e.getSource().equals(multiPlayerButton)) {
			setVisible(false);
			new PlayerIntializationWindow();
		}

	}
	

}
