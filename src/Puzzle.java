import java.io.IOException;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Puzzle extends JFrame {
	private static final long serialVersionUID = 1L;
	Dimension DEFAULT = new Dimension(500,500); 
	Dimension d = new Dimension(90,90);
	
	int i,j;
	int ox,oy;
	public static int level = 0;
	public static JButton Startbutton = new JButton("Start");
	public static JButton Exitbutton = new  JButton("Exit");
	public static JButton OKbutton = new JButton("OK");
	 
	Container c = getContentPane();
  
	public Puzzle() throws IOException
	{
	
        Toolkit kit = Toolkit.getDefaultToolkit();             //定义工具包
        setLocation(kit.getScreenSize().width/3, kit.getScreenSize().height/3);//设置窗口居中显示
	    setIconImage(new ImageIcon("con.gif").getImage());
        setSize(DEFAULT);
        setTitle("拼图通关游戏");
		c.setLayout(null);	
		c.setSize(d);
		c.setLocation(100,100);
		c.setBackground(Color.gray);
		
		for(i = 0 ; i < 16; i++)
		 {
	    	c.add(Mybutton.makeButton(i,true));	
		 }
	
		Startbutton.setBackground(Color.WHITE);
		Startbutton.setSize(80,40);
		Startbutton.setLocation(400,0);
		Exitbutton.setBackground(Color.WHITE);
		Exitbutton.setSize(80,40);
		Exitbutton.setLocation(400,40);
		OKbutton.setBackground(Color.WHITE);
		OKbutton.setSize(80,40);
		OKbutton.setLocation(400,80);
	
		OKbutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(e.getSource() == Puzzle.OKbutton)
				{
			        if(MyRandomPoint.check())
			        {
			        if(level >= 3)
			        	{
			        	JOptionPane.showConfirmDialog(null, "You are the best !", "Congratulaton ! YOU WIN !", JOptionPane.CLOSED_OPTION);
			        	}
			        else{  
			        	int res = JOptionPane.showConfirmDialog(null, "Next Level ?", "You have passed this levels!", JOptionPane.YES_NO_OPTION);
			            if(res == JOptionPane.YES_OPTION)
			            {
			            	 c.removeAll();
						     add(Startbutton);
						     add(Exitbutton);
						     add(OKbutton);
                             level ++;
							 for(i = 0 ; i < 16; i++)
							{
							c.add(Mybutton.makeButton(i,true));
							repaint();
						  }
			            }
			        }
			        
			        }
			        else   JOptionPane.showConfirmDialog(null, "Sorry, Please try again!", "", JOptionPane.CLOSED_OPTION);	
			       
				}	
			}
		});
		
		
		Exitbutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(e.getSource() == Puzzle.Exitbutton)
				{
			        System.exit(0);
				}	
			}
		});
		
		
		
		add(Startbutton);
		Startbutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(e.getSource() == Puzzle.Startbutton)
				{
			        c.removeAll();
			        add(Startbutton);
			        add(Exitbutton);
			    	add(OKbutton);
	
					for(i = 0 ; i < 16; i++)
					 {
					  c.add(Mybutton.makeButton(i,false));
					  repaint();
					 }
				}	
			}
		});
			
	}

	public static void main(String args[]) throws IOException
	{
		Puzzle x = new Puzzle();
		x.setVisible(true);
	}
}