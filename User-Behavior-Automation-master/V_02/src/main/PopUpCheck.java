package main;

import java.awt.AWTException;
import java.awt.Robot;

public class PopUpCheck {
	
	// A Method to check the existence of pop up window and click the button on it if check passed
		static void check(int[] pinPoint) throws AWTException, InterruptedException {
		// One possible pop-up	
			int stepX = 58;
			int stepY = 133;
			int color = -16139610;
			Robot bot = new Robot();
			
			if (bot.getPixelColor(pinPoint[0]+stepX, pinPoint[1]+stepY).getRGB() == color) {
				Mouse.click(new int[] {pinPoint[0]+stepX, pinPoint[1]+stepY});
			}
		//Second possible pop-up
			int stepX2 = 46;
			int stepY2 = 115;
		//	int color2 = -16139610;
						
			if (bot.getPixelColor(pinPoint[0]+stepX2, pinPoint[1]+stepY2).getRGB() == color) {
				Mouse.click(new int[] {pinPoint[0]+stepX2, pinPoint[1]+stepY2});
			}
			
		//Fours possible pop-up
			int stepX4 = 67;
			int stepY4 = 89;
		//	int color2 = -16139610;
						
			if (bot.getPixelColor(pinPoint[0]+stepX4, pinPoint[1]+stepY4).getRGB() == color) {
				Mouse.click(new int[] {pinPoint[0]+stepX4, pinPoint[1]+stepY4});
			}
			
			
		//Third possible pop-up
			int stepX3 = 61;
			int stepY3 = 183;
			int color3 = -14540498;
						
			if (bot.getPixelColor(pinPoint[0]+stepX3, pinPoint[1]+stepY3).getRGB() == color3) {
				Mouse.click(new int[] {pinPoint[0]+stepX3, pinPoint[1]+stepY3});
			}
			
		}

}
