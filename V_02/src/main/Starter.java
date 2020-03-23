package main;

import java.awt.AWTException;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;

import javax.imageio.ImageIO;

public class Starter {

//***************Attributes*************//

	// Start time meter for total Session time
	private long startSessionTime;

	// Array to store X, Y coordinates of PinPoint and its color
	private int[] pinPoint;

//***************Just Getters for attributes***********//
	public long getStartSessionTime() {
		return startSessionTime;
	}

	public int[] getPinPoint() {
		return pinPoint;
	}

//************Default Constructor**************//
	Starter() throws AWTException, IOException {

		this.startSessionTime = System.currentTimeMillis();
		this.pinPoint = getPinPointCoordinates();

	}

	
	// A method to get coordinates of PinPoint
	private static int[] getPinPointCoordinates() throws AWTException, IOException {

		// Step from HomeButton Y to the PinPoint Y
		int step = 332;
		// The path to the image file which serves as a anchor-point
		// to calculate all coordinates in the mirrored screen
		String imageName = "src/img/HomeButton.png"; // ImageToSearch_01.png";// 

		// capture current screen and create an object with it
		Robot robot = new Robot();
		BufferedImage currentScreen = robot
				.createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));

		// create an object with an image to search
		BufferedImage icon = ImageIO.read(new File(imageName));

		// Search the image

		// Declare and initialize array to store matched coordinates
		int[] coordinates = new int[3];

		// Loop through the screen
		loopscreen: for (int x = 0; x < currentScreen.getWidth() - icon.getWidth(); x++) {
			for (int y = 0; y < currentScreen.getHeight() - icon.getHeight(); y++) {

				// image moving through the screen
				Boolean pixelsMathed = true;
				overloop: for (int x2 = 0; x2 < icon.getWidth(); x2++) {
					for (int y2 = 0; y2 < icon.getHeight(); y2++) {

						// Exit the loop if colors does not matched
						if (icon.getRGB(x2, y2) != currentScreen.getRGB(x + x2, y + y2)) {
							pixelsMathed = false;
							break overloop;
						}
					}
				}
				if (pixelsMathed) {

					coordinates[0] = x;// - icon.getWidth();
					coordinates[1] = y - step;// - icon.getHeight();
					coordinates[2] = robot.getPixelColor(coordinates[0], coordinates[1]).getRGB();
					break loopscreen;
				}
			}
		}
		return coordinates;
	}
}
