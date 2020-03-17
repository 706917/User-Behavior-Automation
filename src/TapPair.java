import java.awt.AWTException;
import java.awt.Robot;

public class TapPair {
	
	public static void main(String[] args) {
		
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
				
				if (countGames == 1999) {
					Thread.sleep(900000000);
				}
	//================================================================
				}
			}
			System.out.print("\nTap finished");		
		}
	}

}
