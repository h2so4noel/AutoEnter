package main;

import java.awt.AWTException;

import javax.swing.JTextArea;

import ui.MainUI;

import bot.Bot;

public class Main {

	public static void main(String[] args) throws AWTException {
		JTextArea log = new JTextArea(10, 10);
		Bot bot = new Bot(log);
		MainUI ui = new MainUI(bot);
		ui.run();
	}
}
