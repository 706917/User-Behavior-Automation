
package main;

import java.awt.AWTException;
import java.io.IOException;

public class Index {
	public static void main(String[] args) throws AWTException, IOException, InterruptedException {

		// Amount of games to be played
		int playGames = 1;
		// Games played counter
		int countGames = 0;

		// Starter class instance to get PinPoint coordinate
		Starter bot = new Starter();

		while (countGames < playGames) {

			// Click on PinPoint
			Mouse.click(bot.getPinPoint());

		}

	}

}
