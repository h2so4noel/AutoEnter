package ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextArea;

import bot.Bot;

public class StopListener implements ActionListener {
	
	Bot bot;
	JTextArea log;
	
	public StopListener(Bot bot, JTextArea log){
		this.bot = bot;
		this.log = log;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		bot.stop();
		log.append("Bot stopped" + "\n");
	}
}
