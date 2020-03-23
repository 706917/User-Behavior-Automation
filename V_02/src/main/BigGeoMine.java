package main;

import java.awt.AWTException;
import java.awt.Robot;

public class BigGeoMine {
	
	// A Method to check the existence of pop up window and click the button on it if check passed
		static void check(int[] pinPoint) throws AWTException, InterruptedException {
			
			int stepX = 58;
			int stepY = 133;
			int color = -16139610;
			Robot bot = new Robot();
			
			if (bot.getPixelColor(pinPoint[0]+stepX, pinPoint[1]+stepY).getRGB() == color) {
				Mouse.click(new int[] {pinPoint[0]+stepX, pinPoint[1]+stepY});
			}
		}

}
