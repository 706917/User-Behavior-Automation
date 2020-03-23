package games;

import java.awt.AWTException;
import java.awt.Robot;
import java.util.Arrays;

import main.Mouse;

public class Tap {
	
	// How long to wait
		private static int wait = (int)(Math.random()*300 + 300);

	// A Method to play TAP miniGame
	static void play(int[] pinPoint) throws AWTException, InterruptedException {
		System.out.println("PinPoint: " + Arrays.toString(pinPoint));

		// Steps from PinPoint coordinates to the CheckPoint coordinates (letter "S" in
		// the name of the Swipe game
		int stepX = 63;// 90;
		int stepY = 257;// 173;

		// Steps from PinPoint to the center of first tile
		int stepPPTLX = 110;
		int stepPPTLY = 110;

		// Step between tiles
		int stepTile = 110;

		System.out.println("---Playing Tap---");
		Robot tapBot = new Robot();
		int count = 0;

		bigloop:
		while(Game.getGameName(pinPoint)=="Tap") {
		//while (tapBot.getPixelColor(pinPoint[0] - stepX, pinPoint[1] - stepY).getRGB() == -1) {
			// while (count <5 ) {
			loop: for (int x = pinPoint[0] - stepPPTLX; x < 450; x += stepTile) {
				for (int y = pinPoint[1] - stepPPTLY; y < 720; y += stepTile) {
					// System.out.print("\nChecking color\n");

					if (tapBot.getPixelColor(x, y).getRGB() != -11315627) {
						Mouse.click(new int[] { x, y });
						System.out.println(++count);
						Thread.sleep(wait);
					}

					Thread.sleep(80);
					// if (Game.getGameName(pinPoint)!="Tap") {
					if (tapBot.getPixelColor(pinPoint[0] - stepX, pinPoint[1] - stepY).getRGB() != -1) {
						break loop;
					}

				}
			}
			if (count > 10) {
				break bigloop;
			}
		}
		System.out.println("---Tap finished---");
	}

}
