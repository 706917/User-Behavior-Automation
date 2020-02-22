import java.awt.AWTException;
import java.awt.MouseInfo;
import java.awt.Robot;

public class Get_Mouse_Coordinates_Color {
	
	public static void main(String[]args) throws AWTException {
		
		// Create a robot
		Robot bot = new Robot();
		
		// Wait mouse get desired position
		bot.delay(3000);
		
		System.out.print("Mouse coordinates: \n\n");
		int mouseX = (int)MouseInfo.getPointerInfo().getLocation().getX();
		int mouseY = (int)MouseInfo.getPointerInfo().getLocation().getY();
		
		System.out.print("x coordinate : " + mouseX);
		System.out.print("\ny coordinate : " + mouseY);
		
		System.out.print("\nMove your mouse");
		bot.delay(2000);
		
		int step = 1;
		
		for (int x = mouseX; x<mouseX +step; x++){
			for (int y = mouseY; y<mouseY+step; y++){
				System.out.print("\nRGB\n" + x + ',' + y + '-' + bot.getPixelColor(x,y).getRGB());
				}
			}
	}
}
