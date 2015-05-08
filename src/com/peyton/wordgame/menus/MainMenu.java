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
import com.peyton.wordgame.util.Dictionary;
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
			//Utilities.throwErrorBox("<p><span style=font-size:12px;><span style=font-family:lucida sans unicode,lucida grande,sans-serif;><strong>Instructions:</strong></span></span></p><ol><li><span style=font-size:12px;><span style=font-family:lucida sans unicode,lucida grande,sans-serif;>Choose a Mode: Single Player or Multiplayer</span></span></li><li><span style=font-size:12px;><span style=font-family:lucida sans unicode,lucida grande,sans-serif;>If you are playing <u>Multi-player</u>:</span></span><ol><li><span style=font-size:12px;><span style=font-family:lucida sans unicode,lucida grande,sans-serif;>Type in your name and your partners name</span></span></li><li><span style=font-size:12px;><span style=font-family:lucida sans unicode,lucida grande,sans-serif;>Player 1 Plays</span></span></li><li><span style=font-size:12px;><span style=font-family:lucida sans unicode,lucida grande,sans-serif;>Player 2 Plays</span></span></li><li><span style=font-size:12px;><span style=font-family:lucida sans unicode,lucida grande,sans-serif;>Continue Playing until you wish to exit by pressing the Main Menu button on the end game screen.</span></span></li></ol></li><li><span style=font-size:12px;><span style=font-family:lucida sans unicode,lucida grande,sans-serif;>If you are playing <u>Single player</u>:</span></span><ol><li><span style=font-size:12px;><span style=font-family:lucida sans unicode,lucida grande,sans-serif;>Go right into playing against the computer</span></span></li></ol></li></ol><p><span style=font-size:12px;><span style=font-family:lucida sans unicode,lucida grande,sans-serif;><strong>Gameplay</strong></span></span></p><ol><li><span style=font-size:12px;><span style=font-family:lucida sans unicode,lucida grande,sans-serif;>Your Goal is to form the hidden word by typing it into the text box.</span></span></li><li><span style=font-size:12px;><span style=font-family:lucida sans unicode,lucida grande,sans-serif;>After typing your guess in, the blanks will turn into various symbols:</span></span><ol><li><span style=font-size:12px;><span style=font-family:lucida sans unicode,lucida grande,sans-serif;>A Letter means that letter is in the correct spot and is the right letter</span></span></li><li><span style=font-size:12px;><span style=font-family:lucida sans unicode,lucida grande,sans-serif;>A &quot;^&quot; means that the letter is in the word, but in the incorrect position.</span></span></li><li><span style=font-size:12px;><span style=font-family:lucida sans unicode,lucida grande,sans-serif;>A &quot;*&quot; means that the letter is not in the word</span></span></li></ol></li><li><span style=font-size:12px;><span style=font-family:lucida sans unicode,lucida grande,sans-serif;>You will be given 4 chances to guess before you lose.</span></span></li><li><span style=font-size:12px;><span style=font-family:lucida sans unicode,lucida grande,sans-serif;>If you are playing in multiplayer, your scores will be shown after every round!</span></span></li></ol>", "How To Play");
titleLabel.setText(<p><span style=font-size:12px;><span style=font-family:lucida sans unicode,lucida grande,sans-serif;><strong>Instructions:</strong></span></span></p><ol><li><span style=font-size:12px;><span style=font-family:lucida sans unicode,lucida grande,sans-serif;>Choose a Mode: Single Player or Multiplayer</span></span></li><li><span style=font-size:12px;><span style=font-family:lucida sans unicode,lucida grande,sans-serif;>If you are playing <u>Multi-player</u>:</span></span><ol><li><span style=font-size:12px;><span style=font-family:lucida sans unicode,lucida grande,sans-serif;>Type in your name and your partners name</span></span></li><li><span style=font-size:12px;><span style=font-family:lucida sans unicode,lucida grande,sans-serif;>Player 1 Plays</span></span></li><li><span style=font-size:12px;><span style=font-family:lucida sans unicode,lucida grande,sans-serif;>Player 2 Plays</span></span></li><li><span style=font-size:12px;><span style=font-family:lucida sans unicode,lucida grande,sans-serif;>Continue Playing until you wish to exit by pressing the Main Menu button on the end game screen.</span></span></li></ol></li><li><span style=font-size:12px;><span style=font-family:lucida sans unicode,lucida grande,sans-serif;>If you are playing <u>Single player</u>:</span></span><ol><li><span style=font-size:12px;><span style=font-family:lucida sans unicode,lucida grande,sans-serif;>Go right into playing against the computer</span></span></li></ol></li></ol><p><span style=font-size:12px;><span style=font-family:lucida sans unicode,lucida grande,sans-serif;><strong>Gameplay</strong></span></span></p><ol><li><span style=font-size:12px;><span style=font-family:lucida sans unicode,lucida grande,sans-serif;>Your Goal is to form the hidden word by typing it into the text box.</span></span></li><li><span style=font-size:12px;><span style=font-family:lucida sans unicode,lucida grande,sans-serif;>After typing your guess in, the blanks will turn into various symbols:</span></span><ol><li><span style=font-size:12px;><span style=font-family:lucida sans unicode,lucida grande,sans-serif;>A Letter means that letter is in the correct spot and is the right letter</span></span></li><li><span style=font-size:12px;><span style=font-family:lucida sans unicode,lucida grande,sans-serif;>A &quot;^&quot; means that the letter is in the word, but in the incorrect position.</span></span></li><li><span style=font-size:12px;><span style=font-family:lucida sans unicode,lucida grande,sans-serif;>A &quot;*&quot; means that the letter is not in the word</span></span></li></ol></li><li><span style=font-size:12px;><span style=font-family:lucida sans unicode,lucida grande,sans-serif;>You will be given 4 chances to guess before you lose.</span></span></li><li><span style=font-size:12px;><span style=font-family:lucida sans unicode,lucida grande,sans-serif;>If you are playing in multiplayer, your scores will be shown after every round!</span></span></li></ol>
);
		}
		if (e.getSource().equals(singlePlayerButton)) {
			setVisible(false);
			new SinglePlayerGameWindow();
		}
		if (e.getSource().equals(multiPlayerButton)) {
			setVisible(false);
			new PlayerIntializationWindow();
		}

	}

}
