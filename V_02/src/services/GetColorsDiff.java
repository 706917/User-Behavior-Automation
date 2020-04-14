package services;

import java.awt.AWTException;
import java.awt.Color;
import java.awt.MouseInfo;
import java.awt.Robot;

public class GetColorsDiff {

	public static void main(String[] args) throws AWTException {
		// Create a robot
				Robot bot = new Robot();

			
				// Wait mouse get desired position
				bot.delay(2000);
				
				System.out.println("\nPoint_1 coordinates: ");
				int mouseX_1 = (int)MouseInfo.getPointerInfo().getLocation().getX();
				int mouseY_1 = (int)MouseInfo.getPointerInfo().getLocation().getY();
				Color c1 = bot.getPixelColor(mouseX_1, mouseY_1);
				
				
				System.out.println("x_1 coordinate : " + mouseX_1);
				System.out.println("y_1 coordinate : " + mouseY_1);
				System.out.println("Color object for point_1 created");
				System.out.println("Transparency = " + c1.getTransparency());
				
								
				
				System.out.println("\nMove your mouse");
				bot.delay(2000);
				
				
				System.out.println("\n\nPoint_2 coordinates: ");
				int mouseX_2 = (int)MouseInfo.getPointerInfo().getLocation().getX();
				int mouseY_2 = (int)MouseInfo.getPointerInfo().getLocation().getY();
				Color c2 = bot.getPixelColor(mouseX_2, mouseY_2);
				
				System.out.println("x_1 coordinate : " + mouseX_2);
				System.out.println("y_1 coordinate : " + mouseY_2);
				System.out.println("Color object for point_2 created");
				System.out.println("Transparency = " + c2.getTransparency());
				
				double diff = Math.sqrt((c2.getRed() - c1.getRed()) * (c2.getRed() - c1.getRed()) + 
						(c2.getBlue() - c1.getBlue()) * (c2.getBlue() - c1.getBlue()) +
						(c2.getGreen() - c1.getGreen()) * (c2.getGreen() - c1.getGreen()));
			
				System.out.println("\n\nThe different is " + diff);
				
				

	}

}
