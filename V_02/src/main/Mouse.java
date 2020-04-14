package main;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.InputEvent;

import games.Game;

public class Mouse {

	// A Method to move mouse to the coordinates and make a click
	public static void click(int[] coordinates) throws AWTException, InterruptedException {

		// Create a robot
		Robot bot = new Robot();

		// Move mouse to the Point and click
		bot.mouseMove(coordinates[0], coordinates[1]);
		bot.delay(80);

		bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
		bot.delay(100);
		bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
		
		bot.delay(300);
		
		

	}
	
	public static void shift(int[]down, int[]up) throws AWTException {
		Robot bot = new Robot();
		// Move mouse to the Point and clickOn
		bot.mouseMove(down[0], down[1]);
		bot.delay(80);
		bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
		bot.delay(400);
		
		// Move mouse to the Point and clickOff
		bot.mouseMove(up[0], up[1]);
		bot.delay(80);
		bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
		bot.delay(100);
		
		
		
	}

	static void clickPinPoint(int[] coordinates) throws AWTException, InterruptedException {
		
		while (Game.getGameName(coordinates)=="") {

			PopUpCheck.check(coordinates);

			// Shift mouse from coordinates before click
			int shift = (int)(Math.random()*60);
			// Shift-Xdevider
			int deviderX = (int)(Math.random()*20+1);
			// Shift-Ydevider
			int deviderY = (int)(Math.random()*20+1);
			
	
			// Create a robot
			Robot player = new Robot();
	
			// Move mouse to the PinPoint and click
			player.mouseMove(coordinates[0] + shift / deviderX, coordinates[1] + shift/deviderY);
			player.delay(80);
	
			player.mousePress(InputEvent.BUTTON1_DOWN_MASK);
			player.delay(100);
			player.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
	
			Thread.sleep(300);
	
			// Check if and Move mouse to the "Yes" button and click
			
			// Shift from PinPoint to the "Yes" button
			int shiftYesBottonX = 40;
			int shiftYesBottonY = 70;
			
			if(player.getPixelColor(coordinates[0] + shiftYesBottonX, coordinates[1] + shiftYesBottonY).getRGB()==-16139610)	{	
				player.mouseMove(coordinates[0] + shiftYesBottonX, coordinates[1] + shiftYesBottonY);
				player.delay(80);
		
				player.mousePress(InputEvent.BUTTON1_DOWN_MASK);
				player.delay(100);
				player.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
				}
			Thread.sleep(1000);
			}
		}
}
