package games;

import java.awt.AWTException;
import java.awt.Robot;
import java.util.Arrays;

import main.Mouse;

public class Swipe {
	
	// How long to wait
		private static int wait = (int)(Math.random()*300 + 400);

	// A Method to play SWIPE miniGame
	static void play(int[] pinPoint) throws AWTException, InterruptedException {
		System.out.println("PinPoint: " + Arrays.toString(pinPoint));

		// steps to coordinates of CheckPoint from PinPoint (top left corner of center
		// tile)
		int stepPPCHPX = 50;
		int stepPPCHPY = 80;
		// Steps from TOP CheckPoint to the PinPoint
		int stepTopPPX = 90;
		int stepTopPPY = 190;
		// Steps from RIGHT CheckPoint to the PinPoint
		int stepRightPPX = 130;
		int stepRightPPY = 70;
		// Steps from Bottom CheckPoint to the PinPoint
		int stepBottomPPX = 66;
		int stepBottomPPY = 170;
		// Steps from LEFT CheckPoint to the PinPoint
		int stepLeftPPX = 132;
		int stepLeftPPY = 50;

		// Main Check point coordinates
		int[] mainCHP = new int[] { pinPoint[0] - stepPPCHPX, pinPoint[1] - stepPPCHPY };
		// Top Check point coordinates
		int[] topCHP = new int[] { pinPoint[0] - stepTopPPX, pinPoint[1] - stepTopPPY };
		// Right Check point coordinates
		int[] rightCHP = new int[] { pinPoint[0] + stepRightPPX, pinPoint[1] - stepRightPPY };
		// Bottom Check point coordinates
		int[] bottomCHP = new int[] { pinPoint[0] - stepBottomPPX, pinPoint[1] + stepBottomPPY };
		// Left Check point coordinates
		int[] leftCHP = new int[] { pinPoint[0] - stepLeftPPX, pinPoint[1] + stepLeftPPY };

		System.out.println("---Playing Swipe---");

		
		// Checking loop
		int count = 0;

		bigloop:
		while(Game.getGameName(pinPoint)=="Swipe") {
			if (compareColor(mainCHP, topCHP) == true) {
				Mouse.click(topCHP);
			} else if (compareColor(mainCHP, rightCHP) == true) {
				Mouse.click(rightCHP);
			} else if (compareColor(mainCHP, bottomCHP) == true) {
				Mouse.click(bottomCHP);
			} else if (compareColor(mainCHP, leftCHP) == true) {
				Mouse.click(leftCHP);
			}
			System.out.println(++count);

			Thread.sleep(wait);
			
			if (count > 10) {
				break bigloop;
			}
		}
	}

	// A Method to compare the color in different points for Swipe game
	private static boolean compareColor(int[] main, int[] side) throws AWTException {

		Robot bot = new Robot();

		if (bot.getPixelColor(main[0], main[1]).getRGB() == bot.getPixelColor(side[0], side[1]).getRGB()) {
			return true;
		} else {
			return false;
		}

	}
}
