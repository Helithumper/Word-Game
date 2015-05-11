package com.peyton.wordgame.util;

/**
 * This is a utilities class made for many
 * projects that contains many common
 * methods and constants
 * @Author Peyton Duncan
 * @version 1.0.0
 */

import java.awt.Desktop;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.net.URI;
import java.net.URL;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Utilities {

	/**
	 * @param Message
	 *            that you want to display in the error window
	 * @param Title
	 *            of the Error Window
	 */
	public static void throwErrorBox(String message, String title) {
		JOptionPane.showMessageDialog(new JFrame(), message, title,
				JOptionPane.ERROR_MESSAGE);
	}

	/**
	 * Main font for most texts
	 */

	public static final Font TITLE_FONT = new Font("Serif", Font.BOLD, 36);
	public static final Font TEXT_FONT = new Font("Serif", Font.BOLD, 16);

	public static void openInBrowser(String url) {
		try {
			URI uri = new URL(url).toURI();
			Desktop desktop = Desktop.isDesktopSupported() ? Desktop
					.getDesktop() : null;
			if (desktop != null && desktop.isSupported(Desktop.Action.BROWSE))
				desktop.browse(uri);
		} catch (Exception e) {
			/*
			 * I know this is bad practice but we don't want to do anything
			 * clever for a specific error
			 */
			e.printStackTrace();

			// Copy URL to the clipboard so the user can paste it into their
			// browser
			StringSelection stringSelection = new StringSelection(url);
			Clipboard clpbrd = Toolkit.getDefaultToolkit().getSystemClipboard();
			clpbrd.setContents(stringSelection, null);
			// Notify the user of the failure
			throwErrorBox(
					"This program just tried to open a webpage."
							+ "\n"
							+ "The URL has been copied to your clipboard, simply paste into your browser to access.",
					"Webpage: " + url);
		}
	}

}
