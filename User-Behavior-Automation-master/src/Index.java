import java.awt.AWTException;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.event.InputEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashSet;
import java.util.function.BiFunction;
import java.util.function.Function;

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
		int startCoins = 688;
		int playGames = 10000;
		
		
		
		// Start time meter for total Session time
				long startSessionTime = System.currentTimeMillis();
				
		
	// Possibility of take the pause after played game
		double possibilityPause = 0;
	// How long is the pause after play
		long timeRest = (long) (Math.random()*8000 + 1000);
		
		// how many games we want to play
		int countGames = 0;
		
		while (countGames<playGames){
// STEP 1 : Get PinPoint coordinates
			
// Start play
		long startTime = System.currentTimeMillis();
		
		// Array to store X and Y coordinates of PinPoint and its color
		int[] pinPoint = getPinPointCoordinates();
		
		System.out.print("Pin Point coordinates identifyed: \n" +
		"x = " + pinPoint[0] + " : y =  " + pinPoint[1] + "\n Color: " + pinPoint[2]);
		
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
		System.out.print("\nPinPoint clicked");
		sleep();
		
// STEP 3 : Click on "Yes" Button on the Prompt-pop-up-Window to clean the tile
		
		// Calculate coordinates to click
		int [] yesButtonCoordinates = {pinPoint[0] + 40, pinPoint[1] + 70};
		
		// Move mouse and click
		mouseClick(yesButtonCoordinates,0);
		System.out.print("\nMiniGame initiated\n");
	//	sleep();
		
// Identify the miniGame type and play it
		
		//Identify the name of miniGame
		String gameName = getGameName(pinPoint);
		System.out.print("Game chosen - ");
		
		// Play the miniGame
		play(gameName, pinPoint, countGames);	
		
// Stop playTime and print duration
		long finishTime = System.currentTimeMillis();
		
		
		countGames++;
		System.out.print("\n\n__ " + countGames + " ____Time: " +
		(finishTime - startTime)/1000 + "_\n\n");
		
		Thread.sleep(500);
		

					
					
// Check the pop Up of Big GeoMines
		popup_BigGeoMine(pinPoint);
		
		
// Calculate chances to take a pause and take it if it happen
		// Random number between 0 and 100 to compare with possibility
		int random = (int)(Math.random()*100);
		if(possibilityPause > random) {
			System.out.print("\n___Taking the Rest___\n\n");
			Thread.sleep(timeRest);
			
		}
		else
		{Thread.sleep((int)(Math.random()*500) + 500);}
		}


		
		// Finish Session time
		long finishSessionTime = System.currentTimeMillis();
		
		long SessionTime = finishSessionTime - startSessionTime;
		System.out.println("\n Session Time : " +
		SessionTime/60000 + " min. " + SessionTime%60000/1000 + " sec.");
		System.out.println("Coins on start: " + startCoins);
	
	}
	
	
	
	// A Method to check the existence of pop up window and click the button on it if check passed
	private static void popup_BigGeoMine(int[] pinPoint) throws AWTException, InterruptedException {
		// TODO Auto-generated method stub
		int stepX = 58;
		int stepY = 133;
		int color = -16139610;
		Robot bot = new Robot();
		
		if (bot.getPixelColor(pinPoint[0]+stepX, pinPoint[1]+stepY).getRGB() == color) {
			mouseClick(new int[] {pinPoint[0]+stepX, pinPoint[1]+stepY}, 0);
		}
	}




	// A Method to witness a Big GeoMines
	private static void witness(int[] pinPoint) throws AWTException, InterruptedException {

		//------------ STEPS-----------//
		// Steps to the check Point #1 - checking for the blue stars
		int stepX_CheckPoint_1 = -160;
		int stepY_CheckPoint_1 = -186;
		
		// Steps to the check Point #2 - checking for the blue stars
		int stepX_CheckPoint_2 = -158;
		int stepY_CheckPoint_2 = -130;
		
		// Steps to the First witness point
		int stepX_Witness_1 = 79;
		int stepY_Witness_1 = -120;
				
		// Steps to the Second witness point
		int stepX_Witness_2 = 79;
		int stepY_Witness_2 = -50;
				
		// Steps to the Closing Button
		int stepX_Close = 107;
		int stepY_Close = -208;
		
		//--------------POINTS------------------//		
		// First Check Point coordinates - blue stars
		int x_CheckPoint_1 = pinPoint[0] + stepX_CheckPoint_1;
		int y_CheckPoint_1 = pinPoint[1] + stepY_CheckPoint_1;
		
		// Second Check Point coordinates - blue stars
		int x_CheckPoint_2 = pinPoint[0] + stepX_CheckPoint_2;
		int y_CheckPoint_2 = pinPoint[1] + stepY_CheckPoint_2;
		
		// Color of the Check Point (Blue Star)
		int checkColor = -12683849;
		
		// First Witness Point Coordinates
		int x_Witness_1 = pinPoint[0] + stepX_Witness_1;
		int y_Witness_1 = pinPoint[1] + stepY_Witness_1;
		
		// Second Witness Point Coordinates
		int x_Witness_2 = pinPoint[0] + stepX_Witness_2;
		int y_Witness_2 = pinPoint[1] + stepY_Witness_2;
		
		// Closing Button Point Coordinates
		int x_Close = pinPoint[0] + stepX_Close;
		int y_Close = pinPoint[1] + stepY_Close;
		
		
		
		Robot bot = new Robot();
		
		//if (bot.getPixelColor(x_CheckPoint_1, y_CheckPoint_1).getRGB() == checkColor) {
//			System.out.println("Topstars");
//			mouseClick(new int[] {x_CheckPoint_1, y_CheckPoint_1}, 0);
//			Thread.sleep(500);
//			
//			// Click on witness
//			mouseClick(new int[] {x_Witness_1, y_Witness_1}, 0);
//			Thread.sleep(100);
//			mouseClick(new int[] {x_Witness_2, y_Witness_2}, 0);
//			
//			// Click on close button
//			mouseClick(new int[] {x_Close, y_Close}, 0);
					
		//		}
		System.out.println("Witness");
			Thread.sleep(100);
		if (bot.getPixelColor(x_CheckPoint_2, y_CheckPoint_2).getRGB() != -15789806) {//checkColor) {
			
			// Click on stars
			mouseClick(new int[] {x_CheckPoint_2, y_CheckPoint_2}, 0);
			Thread.sleep(200);
						
			// Click on witness
			mouseClick(new int[] {x_Witness_1, y_Witness_1}, 0);
			Thread.sleep(100);
			mouseClick(new int[] {x_Witness_2, y_Witness_2}, 0);
						
			// Click on close button
			mouseClick(new int[] {x_Close, y_Close}, 0);
			}
//		
		
		
			
		}
		
		
			



	// A Method to play the miniGame depending on its name
	private static void play(String gameName, int[] pinPoint, int countGames) throws AWTException, InterruptedException {
		if (gameName == "Tap") {
			playTap(pinPoint, countGames);			
		}
		else if (gameName == "Pair") {
			playPair(pinPoint, countGames);
		}
		else if (gameName == "Swipe"){
			playSwipe(pinPoint, countGames);
		}	
		
	}

	// A Method to play SWIPE miniGame
	private static void playSwipe(int[] pinPoint, int countGames) throws AWTException, InterruptedException {
		sleep();
		System.out.print("Playing Swipe - \n");
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
		
		// Step from PinPoint to the CheckPoint coordinates  - Swipe - word
				int stepX_S = 67;
				int stepY_S = 244;
		
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
				// Checking loop
				int count = 0;
				bigloop:
				while (bot.getPixelColor(pinPoint[0]-stepX_S, pinPoint[1]-stepY_S).getRGB() == -1) {
					if (compareColor(mainCHP,topCHP) == true) {
						mouseClick(topCHP, 0);
					}
					else if (compareColor(mainCHP,rightCHP) == true) {
						mouseClick(rightCHP, 0);
					}
					else if (compareColor(mainCHP,bottomCHP) == true) {
						mouseClick(bottomCHP, 0);
					}
					else if (compareColor(mainCHP,leftCHP) == true) {
						mouseClick(leftCHP, 0);
						}
					System.out.println(++count);
	//========================== Regular brake every 500 games=====================
					
//					if (countGames == 4999) {
//						Thread.sleep(900000000);
//					}
	//============================================================================
					
					Thread.sleep(100);
//					if(bot.getPixelColor(pinPoint[0]-stepX_S, pinPoint[1]-stepY_S).getRGB() != -1) {
//						System.out.print("\nSwap finished");
//						break;
					if (count >10) { break bigloop;}	
					}
				System.out.println("Swipe finished\n");
					}
				
	
	// A Method to compare the color in different points for Swipe game
	private static boolean compareColor (int[]main, int[] side) throws AWTException {
		
		Robot bot = new Robot();
		
		if(bot.getPixelColor(main[0], main[1]).getRGB() == bot.getPixelColor(side[0], side[1]).getRGB()) {
			return true;
		}
		else {
			return false;	
		}
		
	}
	
	// A Method to play TAP miniGame
	private static void playTap(int[] pinPoint, int countGames) throws AWTException, InterruptedException {
		
		// Steps from PinPoint coordinates to the CheckPoint coordinates (letter "S" in the
				// name of the Swipe game
				int stepX = 63;//90;
				int stepY = 257;//173;
		
		//steps to coordinates of CheckPoint from PinPoint (claim white circle)
		int stepPPCHPX = 90;
		int stepPPCHPY = 173;
		
		// Steps from PinPoint to the center of first tile
		int stepPPTLX = 110;
		int stepPPTLY = 110;
		
		// Step between tiles 
		int stepTile = 110;
		
		System.out.print("Playing Tap - \n");
		Robot tapBot = new Robot();
		int count = 0;	
		
		// while (tapBot.getPixelColor(pinPoint[0]+stepPPCHPX, pinPoint[1]+stepPPCHPY).getRGB() == -10592674) {
		bigloop:
		while (tapBot.getPixelColor(pinPoint[0]-stepX, pinPoint[1]-stepY).getRGB() == -1) {	
		//while (count <5 ) {
		loop:	
		for( int x = pinPoint[0]-stepPPTLX; x < 450; x += stepTile) {
			for( int y = pinPoint[1]-stepPPTLY; y < 720; y += stepTile) {
			//	System.out.print("\nChecking color\n");
				
				if (tapBot.getPixelColor(x, y).getRGB() != -11315627) {
					mouseClick(new int[]{x,y},0);
					count++;
					System.out.println(count);
					}

				
				Thread.sleep(80);
				if (tapBot.getPixelColor(pinPoint[0]-stepX, pinPoint[1]-stepY).getRGB() != -1) {
				//if (tapBot.getPixelColor(pinPoint[0]+stepPPCHPX, pinPoint[1]+stepPPCHPY).getRGB() != -10592674) {
					break loop;
				}
				
				}
			// =================Regular brake every 500 games=========================
			
//			if (countGames == 4999) {
//				Thread.sleep(900000000);
//			}
//================================================================
			}
		if (count >10) { break bigloop;}
		}
		System.out.print("\nTap finished");		
	}
	

///===================================
	// A Method to play TAP miniGame
		private static void playPair(int[] pinPoint, int countGames) throws AWTException, InterruptedException {
			
			// Steps from PinPoint coordinates to the CheckPoint coordinates (letter "T" in the
					// word THE 
					int stepX = 109;//90;
					int stepY = 159;//173;
			
			// Steps from PinPoint to the center of first tile
			int stepPPTLX = -147;
			int stepPPTLY = -144;
			
			// Step between tiles 
			int stepTile = 110;
			
			System.out.print("Playing PAIRS - \n");
			Robot tapBot = new Robot();
			int count = 0;	
		
			bigloop:
			while (tapBot.getPixelColor(pinPoint[0]+stepX, pinPoint[1]+stepY).getRGB() != -1513240) {
			Boolean unique;
			HashSet<Integer> set = new HashSet<Integer>();
			loop:
			for( int x = pinPoint[0]+stepPPTLX; x < 410; x += stepTile) {
				for( int y = pinPoint[1]+stepPPTLY; y < 690; y += stepTile) {
					
					int color = tapBot.getPixelColor(x, y).getRGB();
					unique = set.add(color);
					if (!unique) {
						mouseClick(new int[] {x, y}, 0);
						System.out.println(++count);
						Thread.sleep(100);
						break loop;
						}					
					}
				// =================Regular brake every 500 games=========================
				
//				if (countGames == 4999) {
//					Thread.sleep(900000000);
//				}
	//================================================================
				}
			if (count >10) { break bigloop;}
			}
			System.out.print("\nPAIR finished");		
		}
	
	
	// A Method to identify the miniGame and get its name
	private static String getGameName(int[] pinPoint) throws AWTException, InterruptedException {
		Thread.sleep(300);
		
		// Steps from PinPoint coordinates to the CheckPoint coordinates  - The - word
		int stepX_P = 23;//61;;
		int stepY_P = -256;//-244;
		
		// Steps from PinPoint coordinates to the CheckPoint coordinates  - Tap - word
		int stepX_T = 64;//90;
		int stepY_T = -253;//173;
		
		// Step from PinPoint to the CheckPoint coordinates  - Swipe - word
		int stepX_S = -67;
		int stepY_S = -244;
		
		// Step between PinPoint and 
			
		// Empty string to store the name of miniGame		
		String name = "no game name";
		
		// robot to get colors at specified points
		Robot bot = new Robot();

		
			if(bot.getPixelColor(pinPoint[0]+stepX_S, pinPoint[1]+stepY_S).getRGB() == -1) {
					name = "Swipe";	
					}
			
			if(bot.getPixelColor(pinPoint[0]+stepX_T, pinPoint[1]+stepY_T).getRGB() == -1){
				name = "Tap";
				}	
			
			if (bot.getPixelColor(pinPoint[0]+stepX_P, pinPoint[1]+stepY_P).getRGB() == -1) {
				name = "Pair";
			}
		
			System.out.println(name);
		return name;
	}
	
	// A Method to put program on pause
	private static void sleep() throws InterruptedException {
		Thread.sleep((int)Math.random()*200 + 200);
		
	}
	// A Method to move mouse to the coordinates and make a click
	private static void mouseClick(int[] coordinates, int shift) throws AWTException, InterruptedException {
		// Create a robot
		Robot player = new Robot();
		
		// Move mouse to the PinPoint and click
		player.mouseMove(coordinates[0]+shift/3, coordinates[1]+shift);	
		player.delay(80);
		
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
