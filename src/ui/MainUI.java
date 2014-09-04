package ui;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import bot.Bot;

public class MainUI extends JFrame implements Runnable {
	
	Bot bot;

	JButton run;
	JButton stop;
	
	JLabel intervalL;
	JLabel delayL;
	JTextField interval;
	JTextField delay;
	JButton intervalConfirm;
	JButton delayConfirm;
	
	JLabel logL;
	JTextArea log;
	JScrollPane logPane;
	
	public MainUI(Bot bot){
		this.log = bot.getLog();
		this.bot = bot;
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	@Override
	public void run() {
		initComponents();
		this.pack();
		this.setVisible(true);
	}
	
	private void initComponents(){
		this.setTitle("Enter Bot");
		
		Container container = this.getContentPane(); 
		container.setLayout( new BoxLayout(container, BoxLayout.PAGE_AXIS) );
		
		RunListener runListener = new RunListener(bot, log);
		StopListener stopListener = new StopListener(bot, log);
		
		run = new JButton("RUN");
		stop = new JButton("STOP");
		run.addActionListener(runListener);
		stop.addActionListener(stopListener);
		
		intervalL = new JLabel("Interval (Max = 99999)");
		delayL = new JLabel("Delay (in seconds)");
		interval = new JTextField("0", 10);
		delay = new JTextField("0", 10);
		
		intervalConfirm = new JButton("Interval Confirm");
		intervalConfirm.addActionListener(new ActionListener(){
			public void actionPerformed (ActionEvent e){
				log.append(bot.setInterval(Integer.parseInt(interval.getText())) + "\n");
			}
		});
		delayConfirm = new JButton("Delay Confirm");
		delayConfirm.addActionListener(new ActionListener(){
			public void actionPerformed (ActionEvent e){
				log.append(bot.setDelay(Integer.parseInt(delay.getText())) + "\n");
			}
		});
		
		logL = new JLabel("Log");
		logPane = new JScrollPane(log);
		logPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		logPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		
		container.add(run);
		container.add(stop);
		container.add(intervalL);
		container.add(interval);
		container.add(intervalConfirm);
		container.add(delayL);
		container.add(delay);
		container.add(delayConfirm);
		container.add(logL);
		container.add(logPane);
	}

}
