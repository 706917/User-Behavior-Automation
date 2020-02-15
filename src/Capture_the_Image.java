import java.awt.AWTException;
import java.awt.MouseInfo;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

/**A program to capture the image on the screen for further search and use as a main check point to identify and calculate coordinates of points-of-interest.
 * 
 * -Means that every point-of-interest has the size-relationship with the main-check-point since they are on the same phone screen mirrored to the PC monitor.
 * 
 * -Points-of-interest is a points on the screen that program need to find and click on due to the certain conditions such as specified color of pixel or time passed from last event.
 * 
 */

/**
 * @author 70691
 *
 */
public class Capture_the_Image {

		public static void main(String[] args) throws InterruptedException, AWTException, IOException {
		// TODO Auto-generated method stub
		
			//First step is to get the coordinates of mouse
			// Launch the program and point the mouse to the desired place on the screen
			
			int[] coordinates = new int[2]; // declare an array as a storage for two coordinates x and y
			coordinates = mouseXY(); // assign the values to the array's elements by launching the method

			System.out.print("Mouse coordinates is: \n x = " + coordinates[0] + "\n y = " + coordinates[1]);
			
			// Put system to sleep to give a time to remove mouse from the area where he picture will be captured
			// .. to avoid capture cursor effects
			// Prompt user to remove the mouse
			
			System.out.print("\n\nRemove the mouse from the area!");
			
			Thread.sleep(2000);
			
			// Second step is to capture the image having mouse coordinates 
			int imageSize = 40;
			cutImage(coordinates[0], coordinates[1], imageSize, imageSize); // launch the method to capture image using coordinates identified above and desired values of width and height 
//			
			}
		
		
		
          // A method to get Mouse coordinates
			static int[] mouseXY() throws InterruptedException {
			//  declare array for two coordinates - x and y
				int [] mouse = new int[2];
			// put system to sleep to give a time to use a mouse to desired position
				Thread.sleep(5000);
			// catch coordinates and assign its values to the variables
				mouse[0] = (int) MouseInfo.getPointerInfo().getLocation().getX();
				mouse[1] = (int) MouseInfo.getPointerInfo().getLocation().getY();
				return mouse;
				}
						
						
						
		/** A Method to cut an small image from screenshot
		 * 
		 * @param xCut
		 * @param yCut
		 * @param imageWidth
		 * @param imageHeight
		 * @throws AWTException
		 * @throws IOException
		 */
		 static void cutImage(int xCut, int yCut, int imageWidth, int imageHeight) throws AWTException, IOException {
			Robot cutter = new Robot();
			
			// The name of future file with picture
			String format = "png";
			String fileName = "src/img/ImageToSearch." + format; 
			
			/** Define the rectangle to cut
			 * Accepts:
			 * - xCut and yCut ______________________ the coordinates of current mouse position
			 * - imageWidth, imageHeight _________ the size of rectangle's sides
			 */		 
			Rectangle rectangleToCapture = new Rectangle(xCut, yCut, imageWidth, imageHeight);
			
			// Cut the picture from the Screenshot
			BufferedImage capturedPicture = cutter.createScreenCapture(rectangleToCapture);
			// Save the picture to the file
			ImageIO.write(capturedPicture, format, new File(fileName));
			System.out.println("\n\nImage captured<---");

	}

}

