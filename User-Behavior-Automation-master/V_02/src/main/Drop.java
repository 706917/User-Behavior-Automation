package main;

import java.awt.AWTException;
import java.io.IOException;

public class Drop {
	
	
	public static void run() throws InterruptedException, AWTException, IOException {
		// Amount to drop
				int amount = 2000;
				
				// Instance of Starter class to get pinPoin coordinates
				Starter bot = new Starter();
				
				// shifts from Pinpoint to the drop-button
				int dropX = -118;
				int dropY = 183;
				// Array of coordinates to drop button
				int[] drop_button = new int []{bot.getPinPoint()[0]+dropX, bot.getPinPoint()[1]+dropY};
				
				// shifts from pinPoint to the amount scroll
				int scrollX = 101;
				int scrollY = -95;
				// Array of coordinates to the amount scroll
				int[] scroll = new int []{bot.getPinPoint()[0]+scrollX, bot.getPinPoint()[1]+scrollY};
				
				// shifts from PinPoint to the "current" button
				int currentX = -18;
				int currentY = -52;
				// Array of coordinates to "current" button
				int[] current = new int []{bot.getPinPoint()[0]+currentX, bot.getPinPoint()[1]+currentY};
				
				// shifts from Pinpoint to the "ok" button
				int okX = 66;
				int okY = 173;
				// Array of coordinates to the "ok" button
				int[] ok = new int []{bot.getPinPoint()[0]+okX, bot.getPinPoint()[1]+okY};
		
		int counter = 0;
		while(counter<amount) {
			
		Mouse.click(drop_button);
		 Thread.sleep(1500);
		 
		 Mouse.click(scroll);
		 Thread.sleep(1500);
		 
		 Mouse.click(current);
		 Thread.sleep(1500);
		 
		 Mouse.click(ok);
		 Thread.sleep(1500);
		 counter = counter+200;
		 System.out.println ("Total droped: " + counter);
		 
		}
	}

}
