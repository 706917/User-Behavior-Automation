import java.awt.AWTException;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Find_Image_Get_Coordinates {


public static void main(String[] args) throws AWTException, IOException {
	
	String imageName = "src/img/ImageToSearch.png";
	
	// declare array to store coordinates and assign its values via launch the method
	int [] xy = findImageCoordinates(imageName);
	
	// print them
	System.out.print("Check Point coordinates are: \n x = " + xy[0] + " \n y = " + xy[1]);
	
	

}

private static int[] findImageCoordinates(String imageName) throws AWTException, IOException {
	
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
				coordinates[1] = y;// - icon.getHeight();
				break loopscreen;
				}
		}
	}
	return coordinates;
}

}
