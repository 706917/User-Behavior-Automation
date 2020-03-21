package main;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.InputEvent;

public class Mouse {

	// A Method to move mouse to the coordinates and make a click
	static void click(int[] coordinates) throws AWTException, InterruptedException {

		// Shift mouse from coordinates before click
		int shift = 0;

		// Create a robot
		Robot player = new Robot();

		// Move mouse to the PinPoint and click
		player.mouseMove(coordinates[0] + shift / 3, coordinates[1] + shift);
		player.delay(80);

		player.mousePress(InputEvent.BUTTON1_DOWN_MASK);
		player.delay(100);
		player.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);

	}

}
