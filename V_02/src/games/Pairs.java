package games;

import java.awt.AWTException;
import java.awt.Robot;
import java.util.Arrays;
import java.util.HashSet;

import main.Mouse;

class Pairs {

	// A Method to play Pair miniGame
	static void play(int[] pinPoint) throws AWTException, InterruptedException {
		System.out.println("PinPoint: " + Arrays.toString(pinPoint));

		// Steps from PinPoint coordinates to the CheckPoint coordinates (letter "T" in
		// the word "THE"
		int stepX = 109;// 90;
		int stepY = 159;// 173;

		// Steps from PinPoint to the center of first tile
		int stepPPTLX = -147;
		int stepPPTLY = -144;

		// Step between tiles
		int stepTile = 110;

		System.out.println("+++Playing PAIRS+++");
		Robot tapBot = new Robot();
		int count = 0;

		bigloop:
		// while (Game.getGameName(pinPoint) == "Pair") {
		while (tapBot.getPixelColor(pinPoint[0] + stepX, pinPoint[1] + stepY).getRGB() != -1513240) {
			Boolean unique;
			HashSet<Integer> set = new HashSet<Integer>();
			loop: for (int x = pinPoint[0] + stepPPTLX; x < 410; x += stepTile) {
				for (int y = pinPoint[1] + stepPPTLY; y < 690; y += stepTile) {

					int color = tapBot.getPixelColor(x, y).getRGB();
					unique = set.add(color);
					if (!unique) {
						Mouse.click(new int[] { x, y });
						System.out.println(++count);
						break loop;
					}

					Thread.sleep(100);
				}
			}
			if (count > 10) {
				break bigloop;
			}
		}
		System.out.println("---PAIRS finished---");
	}

}
