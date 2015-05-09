package com.peyton.wordgame.menus;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;

public class HowToMenu extends JFrame implements ActionListener{
	private JPanel mainPanel,buttonPanel;
	private JButton returnButton;
	private JScrollPane scrollPane;
	private JTextArea infoText;
	
	public HowToMenu(){
		initFrame();
	}
	
	private void initFrame(){
		setSize(new Dimension(600,400));
		setResizable(false);
		setLayout(new GridLayout(2,1));
		mainPanel = new JPanel();
		
		infoText = new JTextArea();
		infoText.setText("<html><p><span style=font-size:12px;><span style=font-family:lucida sans unicode,lucida grande,sans-serif;><strong>Instructions:</strong></span></span></p><ol><li><span style=font-size:12px;><span style=font-family:lucida sans unicode,lucida grande,sans-serif;>Choose a Mode: Single Player or Multiplayer</span></span></li><li><span style=font-size:12px;><span style=font-family:lucida sans unicode,lucida grande,sans-serif;>If you are playing <u>Multi-player</u>:</span></span><ol><li><span style=font-size:12px;><span style=font-family:lucida sans unicode,lucida grande,sans-serif;>Type in your name and your partners name</span></span></li><li><span style=font-size:12px;><span style=font-family:lucida sans unicode,lucida grande,sans-serif;>Player 1 Plays</span></span></li><li><span style=font-size:12px;><span style=font-family:lucida sans unicode,lucida grande,sans-serif;>Player 2 Plays</span></span></li><li><span style=font-size:12px;><span style=font-family:lucida sans unicode,lucida grande,sans-serif;>Continue Playing until you wish to exit by pressing the Main Menu button on the end game screen.</span></span></li></ol></li><li><span style=font-size:12px;><span style=font-family:lucida sans unicode,lucida grande,sans-serif;>If you are playing <u>Single player</u>:</span></span><ol><li><span style=font-size:12px;><span style=font-family:lucida sans unicode,lucida grande,sans-serif;>Go right into playing against the computer</span></span></li></ol></li></ol><p><span style=font-size:12px;><span style=font-family:lucida sans unicode,lucida grande,sans-serif;><strong>Gameplay</strong></span></span></p><ol><li><span style=font-size:12px;><span style=font-family:lucida sans unicode,lucida grande,sans-serif;>Your Goal is to form the hidden word by typing it into the text box.</span></span></li><li><span style=font-size:12px;><span style=font-family:lucida sans unicode,lucida grande,sans-serif;>After typing your guess in, the blanks will turn into various symbols:</span></span><ol><li><span style=font-size:12px;><span style=font-family:lucida sans unicode,lucida grande,sans-serif;>A Letter means that letter is in the correct spot and is the right letter</span></span></li><li><span style=font-size:12px;><span style=font-family:lucida sans unicode,lucida grande,sans-serif;>A &quot;^&quot; means that the letter is in the word, but in the incorrect position.</span></span></li><li><span style=font-size:12px;><span style=font-family:lucida sans unicode,lucida grande,sans-serif;>A &quot;*&quot; means that the letter is not in the word</span></span></li></ol></li><li><span style=font-size:12px;><span style=font-family:lucida sans unicode,lucida grande,sans-serif;>You will be given 4 chances to guess before you lose.</span></span></li><li><span style=font-size:12px;><span style=font-family:lucida sans unicode,lucida grande,sans-serif;>If you are playing in multiplayer, your scores will be shown after every round!</span></span></li></ol></html>");
		infoText.setEditable(false);

		infoText.setWrapStyleWord(true);
		scrollPane = new JScrollPane(infoText);

        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
		mainPanel.add(scrollPane);
		add(mainPanel);
		
		buttonPanel = new JPanel();
		returnButton = new JButton("Return to Main Menu");
		returnButton.addActionListener(this);
		buttonPanel.add(returnButton);
		add(buttonPanel);
		
		setVisible(true);
		setLocationRelativeTo(null);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource().equals(returnButton)){
			setVisible(false);
			new MainMenu();
		}
		
	}
}
