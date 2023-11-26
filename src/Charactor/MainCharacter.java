
package Charactor;


import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;
import javax.swing.Timer;
import util.Resource;

public class MainCharacter {
    	public int x ;
	public int y;
	public int health = 200;
	public static int speedMainCharacter = 100;
        private BufferedImage MainCharacterimage, imageHealth;
        private MainCharacter MainCharacter;
        
	public MainCharacter() {}
                                
	public BufferedImage getImage() {
		MainCharacterimage = Resource.getResouceImage("data//80*120 walk.png");
		return MainCharacterimage;
	}
	
	public MainCharacter(int x,int y) {
		this.x=x;
		this.y=y;
	}
        
        public void jump(JPanel page) {
		this.y -= speedMainCharacter;
		page.repaint();

		Timer timer =new Timer(300,new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					y += speedMainCharacter;
					page.repaint();
			}
		});
		timer.setRepeats(false);
		timer.start();
	}
        
        public void MainCharacterTapHealth(Graphics g) {
            Graphics2D g2 = (Graphics2D) g;
            imageHealth = Resource.getResouceImage("data//h1.png");
            g2.drawImage(imageHealth, 8, 10, 35, 40, null);
            g2.setStroke(new BasicStroke(22.0f));
            g2.setColor(new Color(255,51,51));
	}
}
