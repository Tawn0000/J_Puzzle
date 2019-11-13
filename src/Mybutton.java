import java.awt.Dimension;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class Mybutton extends JButton {

	public static Dimension d = new Dimension(90,90);
	public static int ox,oy;
	public static int i,j,N = 16;
    	public static int dist;
    	public static Point p1;
    	public static boolean t;
   
	public static JButton makeButton(int x,boolean y)
	{
		JButton b = new JButton();
		try{
		ImageIcon bi = SplitPic.GetIcon(x);
		b.setBorder(null);
		b.setIcon(bi);
		b.setSize(d);
	
		}
		catch(IOException e)
		{
			System.out.println(e);
		}
	
		if(y) {MyRandomPoint.num[x] = x; MyRandomPoint.vis[x] = true; b.setLocation(MyRandomPoint.GetPoint(x));return b;}
		else   b.setLocation(MyRandomPoint.GetRandomPoint(x));
		
		
		
		b.addMouseListener(new MouseAdapter()
				{
		         	public void mousePressed(MouseEvent e)
		         	{
		                ox = e.getX();
		                oy = e.getY();
		                p1 = new Point(b.getX() + e.getX() - ox,b.getY() + e.getY() - oy);
		         	}
		         	
		         	public void mouseReleased(MouseEvent e)
		         	{
		         		b.setLocation(MyRandomPoint.GetPostionPoint(p1,x));	         		
		         	}
		         	
				});
		
		b.addMouseMotionListener(new MouseMotionAdapter()
				{		       
		         	 public void mouseDragged(MouseEvent e)
		         	 {
		         	         p1 = new Point(b.getX() + e.getX() - ox,b.getY() + e.getY() - oy);
		         		     b.setLocation(p1);        
		         		 }
		      	 });
		return b;
	}

	
}
