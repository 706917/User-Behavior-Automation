package games;

import java.awt.AWTException;
import java.awt.Color;
import java.awt.Robot;

import main.Mouse;

public class Drag {

	//public static void main(String[] args) throws AWTException, InterruptedException {
		
	public static void play(int[]pinPoint) throws AWTException, InterruptedException {
		
		Robot bot = new Robot();
		int x = pinPoint[0];
		int y = pinPoint[1];
		
		// Coordinates  of points in the middle lane
		int []leftLeft = new int [] {x-170,y-30};
		int []left = new int[] {x-90,y-30};
		int []center = new int[] {x,y-30};
		int []right = new int[] {x+90,y-30};
		int []rightRight = new int[] {x+160,y-30}; 
		
		//  Array of points in the middle lane
		int[][] middleLane = new int[][] {leftLeft, left, center, right, rightRight};
				
		// Coordinates of points in the upper lane
		int []leftUp = new int[] {x-90,y-115};
		int []centerUp = new int[] {x,y-115};
		int []rightUp = new int[] {x+90,y-115};
		
		// Array of points in the upper lane
		int[][] upperLane = new int[][] {leftUp, centerUp, rightUp};
		
		System.out.println("---Playing Drag---");
		int count = 0; // solved puzzles counter
		
		
		while(Game.getGameName(pinPoint)=="Drag") {
			Thread.sleep(1200);
			boolean swaped = false;
			outerloop:
			for (int i = 0; i<middleLane.length; i++) {
				for (int j = 0; j<upperLane.length; j++) {
					
					
					if(compare(middleLane[i], upperLane[j])) {
						Mouse.shift(middleLane[i], upperLane[j]);
						System.out.println(count++);
						swaped = true;
						break outerloop;
						}				
				}
			}
				if(!swaped) {

					if (bot.getPixelColor(leftLeft[0], leftLeft[1]).getRGB() == -16447481 ||
							bot.getPixelColor(leftLeft[0], leftLeft[1]).getRGB() == -16249838) {
						Mouse.shift(rightRight, leftLeft);
					}
					else if (bot.getPixelColor(rightRight[0], rightRight[1]).getRGB() == -16447481 ||
					bot.getPixelColor(leftLeft[0], leftLeft[1]).getRGB() == -16249838) {
						Mouse.shift(leftLeft, rightRight);
						}
					else Mouse.shift(left, center);
					}
				}
		}
		
		
		
//		System.out.println(compare(leftLeft, leftUp));
//		System.out.println(compare(left, centerUp));
//		System.out.println(compare(center, rightUp));
//		System.out.println("=============");
//		
//		System.out.println(compare(right, leftUp));
//		System.out.println(compare(right, centerUp));
//		System.out.println(compare(right, rightUp));
//		
//		System.out.println("=============");
//		
//		System.out.println(compare(rightRight, leftUp));
//		System.out.println(compare(rightRight, centerUp));
//		System.out.println(compare(rightRight, rightUp));
		
		

	
	
	
	
	private static boolean compare(int[]down, int[]up) throws AWTException {
		Robot bot = new Robot();
		// Color object of Up point
		Color colup = bot.getPixelColor(up[0], up[1]);
		// Color object of Down point
		Color coldown = bot.getPixelColor(down[0], down[1]);
		
		int threshold = 73;
		
		double diff = Math.sqrt((colup.getRed() - coldown.getRed()) * (colup.getRed() - coldown.getRed()) + 
					(colup.getBlue() - coldown.getBlue()) * (colup.getBlue() - coldown.getBlue()) +
					(colup.getGreen() - coldown.getGreen()) * (colup.getGreen() - coldown.getGreen()));
		
		if((int)diff==55 || (int)diff==56|| (int)diff==41 || (int)diff==70) return false;
		
		if (diff<threshold) return true;
		
		return false;
		
		
//		int diffUp = 32;
//		int  diffDown = 26;
//		
//		Color c = bot.getPixelColor(up[0], up[1]);
//		c.
//		int  colup = Math.abs(bot.getPixelColor(up[0], up[1]).getRGB())/100000;
//		int coldown = Math.abs(bot.getPixelColor(down[0], down[1]).getRGB())/100000;
//		
//		if( colup - coldown  > 0 &&
//			colup - coldown  < diffUp && 
//			colup - coldown   > diffDown 
//			) 
//			return true;
//		
////		if(bot.getPixelColor(down[0], down[1]).getRGB() == 491521 &&
////				bot.getPixelColor(up[0], up[1]).getRGB() == 3641186)
////			return true;
//				
//		return false;
		
	}

}
