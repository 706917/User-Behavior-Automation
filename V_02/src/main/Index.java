
package main;

import java.awt.AWTException;
import java.io.IOException;

import games.Game;

public class Index {
	public static void main(String[] args) throws AWTException, IOException, InterruptedException {

		// Amount of games to be played
		int playGames = 1;
		// Games played counter
		int countGames = 0;

		// Starter class instance to get PinPoint coordinates
		Starter bot = new Starter();

		// Start the FUN
		while (countGames < playGames) {

			// Click on PinPoint
			Mouse.clickPinPoint(bot.getPinPoint());

			Thread.sleep(300);

			Game.play(bot.getPinPoint());

			Thread.sleep(500);

			System.out.println("_______" + ++countGames + "_______");

		}

	}

}
