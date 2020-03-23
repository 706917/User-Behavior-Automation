package games;

import java.awt.AWTException;
import java.awt.Robot;

public class Game {

	public static void play(int[] pinPoint) throws InterruptedException, AWTException {
		String gameName = getGameName(pinPoint);

		if (gameName == "Tap") {
			Tap.play(pinPoint);
		} else if (gameName == "Pair") {
			Pairs.play(pinPoint);
		} else if (gameName == "Swipe") {
			Swipe.play(pinPoint);
		}

	}

	// A Method to identify the miniGame type and get its name
	static String getGameName(int[] pinPoint) throws InterruptedException, AWTException {
		
		// Steps from PinPoint coordinates to the CheckPoint coordinates - "The" - word
		// in "Tap The Pair"
		int stepX_P = 23;// 61;;
		int stepY_P = -256;// -244;

		// Steps from PinPoint coordinates to the CheckPoint coordinates - Tap - word
		int stepX_T = 64;// 90;
		int stepY_T = -253;// 173;

		// Step from PinPoint to the CheckPoint coordinates - Swipe - word
		int stepX_S = -67;
		int stepY_S = -244;

		// Step between PinPoint and

		// Empty string to store the name of miniGame
		String name = "";

		// robot to get colors at specified points
		Robot bot = new Robot();

		if (bot.getPixelColor(pinPoint[0] + stepX_S, pinPoint[1] + stepY_S).getRGB() == -1) {
			name = "Swipe";
		}

		if (bot.getPixelColor(pinPoint[0] + stepX_T, pinPoint[1] + stepY_T).getRGB() == -1) {
			name = "Tap";
		}

		if (bot.getPixelColor(pinPoint[0] + stepX_P, pinPoint[1] + stepY_P).getRGB() == -1) {
			name = "Pair";
		}

		if (name==""){
				System.out.println("no game");
		}
		return name;
	}
}
