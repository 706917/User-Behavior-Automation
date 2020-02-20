import java.awt.AWTException;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.event.InputEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

/** This class suppose to be the main class to launch the program.
 * 
 * Please read the Readme.md file to get familiar with the program purposes
 * 
 */

/**
 * @author 70691
 *
 */
public class Index {
	public static void main (String[] args) throws AWTException, IOException, InterruptedException {
		
// Step 0 : Create a robot
	//	Robot player = new Robot();
		
		
// STEP 1 : Get PinPoint coordinates
		
		// Array to store X and Y coordinates of PinPoint
		int[] pinPoint = getPinPointcoordinates();
		
		System.out.print("Pin Point coordinates identifyed: \n" +
		"x = " + pinPoint[0] + "\ny =  " + pinPoint[1]);
		
//STEP 2 : Create a list with coordinates of points with 
// specified blue color around PinPoint. That points will be randomly chosen 
// for mouse-click to simulate user behavior
		
		// Radius of area across PinPoint to search pixels with blue color
//		int radiusToSearch = 40;
//		
//		for (int x = pinPoint[0] - radiusToSearch; x <= pinPoint[0] - radiusToSearch; x++) {
//			
//		}
		
// STEP 3 : Make a mouse-click to initiate a miniGame call
		
		// Move mouse to the PinPoint and click
		mouseClick(pinPoint);
		sleep();
		
// STEP 3 : Click on "Yes" Button on the Prompt-pop-up-Window to clean the tile
		
		// Calculate coordinates to click
		int [] yesButtonCoordinates = {pinPoint[0] + 27, pinPoint[1] + 40};
		
		// Move mouse and click
		mouseClick(yesButtonCoordinates);
		sleep();
		
// Identify the miniGame type and play it
		
		//Identify the name of miniGame
		String gameName = getGameName();
		
		// Play the miniGame
		play(gameName);
		
		
		
	}
	// A Method to play the miniGame depending on its name
	private static void play(String gameName) {
		if (gameName == "Tap") {
			playTap();
		}
		else {
			playSwipe();
		}		
	}

	// A Method to play SWIPE miniGame
	private static void playSwipe() {
		// TODO Auto-generated method stub
		
	}
	
	// A Method to play TAP miniGame
	private static void playTap() {
		
		Robot bot = new Robot();
		for( int x = 150; x<= 270; x += 60) {
			for( int y = 260; y <= 380; y += 60) {
				if (bot.getPixelColor(x, y).getRGB() != -11318627) {
					mouseClick(new int[x,y]);
				}
			}
		}

		
	}
	// A Method to identify the miniGame and get its name
	private static String getGameName() throws AWTException {
		
		// Coordinates of points to check colors
		int[] pointOne = {138,225};
		int[] pointTwo = {257, 222};
		
		// Empty string to store the name of miniGame		
		String name = "";
		
		// robot to get colors at specified points
		Robot bot = new Robot();
		if (bot.getPixelColor(pointOne[0], pointOne[1]).getRGB() == bot.getPixelColor(pointTwo[0], pointTwo[1]).getRGB()) {
			name = "Swipe";
		}
		else {
			name = "Tap";
		}		
		
		return name;
	}
	
	// A Method to put program on pause
	private static void sleep() throws InterruptedException {
		Thread.sleep((int)Math.random()*1000 + 300);
		
	}
	// A Method to move mouse to the coordinates and make a click
	private static void mouseClick(int[] coordinates) throws AWTException {
		// Create a robot
		Robot player = new Robot();
		
		// Move mouse to the PinPoint and click
		player.mouseMove(coordinates[0], coordinates[1]);	
		player.delay(500);
		
		player.mousePress(InputEvent.BUTTON1_DOWN_MASK);
		player.delay(100);
		player.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
		
	}

	// This method made out from findImageCoordinates Method from class Find_Image_Get_Coordinates
	private static int[] getPinPointcoordinates() throws AWTException, IOException {
		
		// The path to the image file which serves as a anchor-point 
		//to calculate all coordinates in the mirrored screen
		String imageName = "src/img/HomeButton.png";
		
		// capture current screen and create an object with it	
		Robot robot = new Robot();
		BufferedImage currentScreen = robot.createScreenCapture (new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));
		
		// create an object with an image to search
		BufferedImage icon = ImageIO.read(new File(imageName));
		
		// Search the image
		
		// Declare and initialize array to store matched coordinates
		int[] coordinates = new int [2];
		
		// Loop through the screen
		loopscreen:
		for (int x = 0; x <currentScreen.getWidth() - icon.getWidth(); x++) {
			for (int y = 0; y <currentScreen.getHeight() - icon.getHeight(); y++) {
				
				// image moving through the screen
				Boolean pixelsMathed = true; 
				overloop:
				for (int x2 = 0; x2 <icon.getWidth(); x2++) {
					for (int y2 = 0; y2 < icon.getHeight(); y2++) {
						
						// Exit the loop if colors does not matched
						if (icon.getRGB(x2, y2) != currentScreen.getRGB(x+x2, y+y2)) {						
							pixelsMathed = false;
							break overloop;
						}
					}
				}
				if (pixelsMathed) {				
					
					coordinates[0] = x;// - icon.getWidth();
					coordinates[1] = y-194;// - icon.getHeight();
					break loopscreen;
					}
			}
		}
		return coordinates;
	}

}
