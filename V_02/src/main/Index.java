
package main;

import java.awt.AWTException;
import java.io.IOException;
import java.time.LocalDateTime;

import games.Game;

public class Index {
	public static void main(String[] args) throws AWTException, IOException, InterruptedException {

		// Amount of games to be played
		int playGames = 2000;
		// Games played counter
		int countGames = 0;

		// Starter class instance to get PinPoint coordinates
		Starter bot = new Starter();

		// Start the FUN
		while (countGames < playGames) {
			System.out.println("\n_______" + ++countGames + "_______");

			// Click on PinPoint
			Mouse.clickPinPoint(bot.getPinPoint());

			Thread.sleep(400);

			Game.play(bot.getPinPoint());
			
			BigGeoMine.check(bot.getPinPoint());

			Thread.sleep(1400);	
		}
		System.out.println("\n_______FINISH_______");
		System.out.println("______________________");
		System.out.println(LocalDateTime.now());

	}

}
