import java.awt.image.*;
import java.io.File;
import java.io.IOException;
import javax.swing.ImageIcon;
import javax.imageio.*;
public class SplitPic 
{
	 public static ImageIcon GetIcon(int x) throws IOException{
	 BufferedImage bi = ImageIO.read(new File("pic\\"+ String.valueOf(Puzzle.level)+".jpg"));
     int w = bi.getWidth();
     int h = bi.getHeight();
     bi = bi.getSubimage(x%4*w/4,x/4*h/4, w/4, h/4);
	 ImageIcon ans = new ImageIcon(bi);	
	 return ans;
  }
}
