package ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextArea;

import bot.Bot;

public class RunListener implements ActionListener {

	Bot bot;
	JTextArea log;
	
	public RunListener(Bot bot, JTextArea log){
		this.bot = bot;
		this.log = log;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		bot.initiate();
		log.append("Bot Started" + "\n");
	}
}
