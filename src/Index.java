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
		
		// Array to store X and Y coordinates of PinPoint and its color
		int[] pinPoint = getPinPointCoordinates();
		
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
		// shift on X to get out from PinPoint
		int shift = 10;
		mouseClick(pinPoint, shift);
		System.out.print("\nMining initiated");
		sleep();
		
// STEP 3 : Click on "Yes" Button on the Prompt-pop-up-Window to clean the tile
		
		// Calculate coordinates to click
	//	int [] yesButtonCoordinates = {pinPoint[0] + 27, pinPoint[1] + 40};
		
		// Move mouse and click
	//	mouseClick(yesButtonCoordinates);
		System.out.print("\nMiniGame initiated");
		sleep();
		
// Identify the miniGame type and play it
		
		//Identify the name of miniGame
		String gameName = getGameName(pinPoint);
		System.out.print("\nGame choosen");
		
		// Play the miniGame
		play(gameName, pinPoint);
		
		
		
	}
	// A Method to play the miniGame depending on its name
	private static void play(String gameName, int[] pinPoint) throws AWTException, InterruptedException {
		if (gameName == "Tap") {
			playTap(pinPoint);
			
		}
		else {
			playSwipe(pinPoint);
		}		
	}

	// A Method to play SWIPE miniGame
	private static void playSwipe(int[] pinPoint) throws AWTException, InterruptedException {
		sleep();
		System.out.print("\nPlaying Swipe");
		//steps to coordinates of CheckPoint from PinPoint (claim white circle)
				int stepPPCHPX = 50;
				int stepPPCHPY = 80;
		// Steps from TOP CheckPoint to the PinPoint
				int stepTopPPX = 90;
				int stepTopPPY = 190;
		// Steps from RIGHT CheckPoint to the PinPoint
				int stepRightPPX = 130;
				int stepRightPPY = 70;
		// Steps from Bottom CheckPoint to the PinPoint
				int stepBottomPPX = 66;
				int stepBottomPPY = 170;
		// Steps from LEFT CheckPoint to the PinPoint
				int stepLeftPPX = 132;
				int stepLeftPPY = 50;
		
		// Main Check point coordinates
				int[] mainCHP = new int[] {pinPoint[0] - stepPPCHPX, pinPoint[1] - stepPPCHPY};
		// Top Check point coordinates
				int[] topCHP = new int[] {pinPoint[0] - stepTopPPX, pinPoint[1] - stepTopPPY};
		// Right Check point coordinates
				int[] rightCHP = new int [] {pinPoint[0] + stepRightPPX, pinPoint[1] - stepRightPPY};
		// Bottom Check point coordinates
				int[] bottomCHP = new int[] {pinPoint[0] - stepBottomPPX, pinPoint[1] + stepBottomPPY};
		// Left Check point coordinates
				int[] leftCHP = new int[] {pinPoint[0] - stepLeftPPX, pinPoint[1] + stepLeftPPY};
				
				Robot bot = new Robot();
				
		// Color at Main Check Point
				int mainColor = bot.getPixelColor(mainCHP[0], mainCHP[1]).getRGB();
		// Top color
				int topColor = bot.getPixelColor(topCHP[0], topCHP[1]).getRGB();
		// Right color
				int rightColor = bot.getPixelColor(rightCHP[0], rightCHP[1]).getRGB();
		// Bottom Color
				int bottomColor = bot.getPixelColor(bottomCHP[0], bottomCHP[1]).getRGB();
		// Left Color
				int leftColor = bot.getPixelColor(leftCHP[0], leftCHP[1]).getRGB();
				
				// Checking loop
				int loop = 0;
				
				while (loop<5) {
					if (mainColor == topColor) {
						mouseClick(topCHP, 0);
					}
					else if(mainColor == rightColor){
						mouseClick(rightCHP, 0);
					}
					else if(mainColor == bottomColor) {
						mouseClick(bottomCHP, 0);
					}
					else {
						mouseClick(leftCHP, 0);
						}
					System.out.print(loop++);
					Thread.sleep(500);
					//if (bot.getPixelColor(pinPoint[0], pinPoint[1]).getRGB() == pinPoint[2]) {
						//break;
				//	}
					}
				}
		
	
	// A Method to play TAP miniGame
	private static void playTap(int[] pinPoint) throws AWTException, InterruptedException {
		
		//steps to coordinates of CheckPoint from PinPoint (claim white circle)
		int stepPPCHPX = 90;
		int stepPPCHPY = 173;
		
		// Steps from PinPoint to the center of first tile
		int stepPPTLX = 110;
		int stepPPTLY = 110;
		
		// Step between tiles 
		int stepTile = 100;
		
		System.out.print("\nPlaying Tap - ");
		Robot bot = new Robot();
		int count = 0;	
		
		while (bot.getPixelColor(pinPoint[0]+stepPPCHPX, pinPoint[1]+stepPPCHPY).getRGB() == -10592674) {
		//while (count <5 ) {
		loop:	
		for( int x = pinPoint[0]-stepPPTLX; x < 350; x += stepTile) {
			for( int y = pinPoint[1]-stepPPTLY; y < 590; y += stepTile) {
				
				if (bot.getPixelColor(x, y).getRGB() != -11315627) {
					mouseClick(new int[]{x,y},0);
					count++;
					System.out.print(count);
					}
				Thread.sleep(100);
				if (bot.getPixelColor(pinPoint[0]+stepPPCHPX, pinPoint[1]+stepPPCHPY).getRGB() != -10592674) {
					break loop;
				}
				}
			}
		}
		System.out.print("\nTap finished");		
	}
	
	
	// A Method to identify the miniGame and get its name
	private static String getGameName(int[] pinPoint) throws AWTException, InterruptedException {
		Thread.sleep(500);
		
		// Steps from PinPoint coordinates to the CheckPoint coordinates (letter "S" in the
		// name of the Swipe game
		int stepX = 90;
		int stepY = 173;
			
		// Empty string to store the name of miniGame		
		String name = "";
		
		// robot to get colors at specified points
		Robot bot = new Robot();

		if (bot.getPixelColor(pinPoint[0]+stepX, pinPoint[1]+stepY).getRGB() != -10592674) {
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
	private static void mouseClick(int[] coordinates, int shift) throws AWTException, InterruptedException {
		// Create a robot
		Robot player = new Robot();
		
		// Move mouse to the PinPoint and click
		player.mouseMove(coordinates[0]+shift, coordinates[1]);	
		player.delay(500);
		
		player.mousePress(InputEvent.BUTTON1_DOWN_MASK);
		player.delay(100);
		player.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
		
		sleep();
	}

	// This method made out from findImageCoordinates Method from class Find_Image_Get_Coordinates
	private static int[] getPinPointCoordinates() throws AWTException, IOException {
		
		// Step from HomeButton Y to the PinPoint Y
		int step = 332;
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
		int[] coordinates = new int [3];
		
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
					coordinates[1] = y-step;// - icon.getHeight();
					coordinates[2] = robot.getPixelColor(coordinates[0], coordinates[1]).getRGB();
					break loopscreen;
					}
			}
		}
		return coordinates;
	}

}
