package bot;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import javax.swing.JTextArea;

public class Bot {
	
	private int interval;
	private int delay;
	private Robot robot;
	private int stopper;
	private JTextArea log;
	
	public Bot(JTextArea log) throws AWTException{
		this.log = log;
		interval = 5;
		delay = 5;
		robot = new Robot();
		stopper = 9999;
	}
	
	public JTextArea getLog(){
		return log;
	}
	
	public String setInterval(int interval){
		this.interval = interval;
		System.out.println("Interval = " + interval);
		return "Interval = " + interval;
	}
	
	public String setDelay(int delay){
		this.delay = delay;
		System.out.println("Delay = " + delay);
		return "Delay = " + delay;
	}
	
	public int getInterval(){
		return interval;
	}
	
	public int getDelay(){
		return delay;
	}
	
	public void initiate(){
		Thread thread = new Thread(){
			public void run(){
				for(int i = 0; i <= interval; i++){
					try{
						if(stopper == 0 || i == interval){
							System.out.println("Interval Met.");
							stopped();
							return;
						}
						Thread.sleep(delay * 1000);
						robot.keyPress(KeyEvent.VK_ENTER);
						System.out.println("Enter Pressed " + (i+1) + " time(s).");
						pressed(i+1);
						robot.keyRelease(KeyEvent.VK_ENTER);
					} catch (Exception e){
						System.out.println("ERROR");
					}
				}
			}
		};
		thread.start();
	}
	
	public void pressed(int i){
		log.append("ENTER #" + i + " of #" + interval + "\n");
	}
	
	public void stopped(){
		log.append("==========FINISHED========");
	}
	
	public void stop(){
		stopper = 0;
	}
}
