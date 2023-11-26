package display;

import java.awt.Color;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

import Element.Botton;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import util.Resource;

public class Menu extends JPanel {
        public long point1;
	private BufferedImage rebackground;
                                  
	public Menu() {}
		
	public Menu(long point,ActionListener main) {
	{
		this.point1 = point;
		this.setBounds(0,0,1024,768);
		this.setFocusable(true);
		this.setLayout(null);
									
                Botton restart = new Botton("restart",25,400,450,200,50);
                restart.addActionListener(main);		
                this.add(restart);
	} 
}
        public static Font getFont(int size){
		Font font = null;
		try {
			font = Font.createFont(Font.TRUETYPE_FONT,new File("font//Paul-le1V.ttf"));
			return font.deriveFont((float)size);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return font;
	}
        
        public void paint(Graphics g){           
            rebackground = Resource.getResouceImage("data//re.jpg");
                g.drawImage( rebackground, 0, 0, this);
                g.setFont(getFont(60));
                g.setColor(Color.white);
                g.drawString("You Died!", 400,200);
                g.drawString("Total: "+ this.point1,400,350);
}
}