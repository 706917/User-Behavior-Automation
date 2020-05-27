package alex.lab.wordscapes;

/**
 * Hello world!
 *
 */
import java.io.*;
import net.sourceforge.tess4j.*;
import net.sourceforge.tess4j.ITessAPI.TessBaseAPI;
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        
        File imageFile = new File("C:/Alex/GitHub/User-Behavior-Automation/wordscapes/002.PNG");
        Tesseract instance = new Tesseract();; //
        
      
         
        try {
         
        String result = instance.doOCR(imageFile);
        System.out.println(result);
         
        } catch (TesseractException e) {
        System.err.println(e.getMessage());
        }
    }
}
