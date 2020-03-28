package main;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.InputEvent;

import games.Game;

public class Mouse {

	// A Method to move mouse to the coordinates and make a click
	public static void click(int[] coordinates) throws AWTException, InterruptedException {

		// Create a robot
		Robot player = new Robot();

		// Move mouse to the Point and click
		player.mouseMove(coordinates[0], coordinates[1]);
		player.delay(80);

		player.mousePress(InputEvent.BUTTON1_DOWN_MASK);
		player.delay(100);
		player.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
		
		

	}

	static void clickPinPoint(int[] coordinates) throws AWTException, InterruptedException {
		
		while (Game.getGameName(coordinates)=="") {

		BigGeoMine.check(coordinates);

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

		Thread.sleep(400);

		// Move mouse to the "Yes" button and click
		
		// Shift from PinPoint to the "Yes" button
//		int shiftYesBottonX = 40;
//		int shiftYesBottonY = 70;
//				
//		player.mouseMove(coordinates[0] + shiftYesBottonX, coordinates[1] + shiftYesBottonY);
//		player.delay(80);
//
//		player.mousePress(InputEvent.BUTTON1_DOWN_MASK);
//		player.delay(100);
//		player.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
		}

	}

}
