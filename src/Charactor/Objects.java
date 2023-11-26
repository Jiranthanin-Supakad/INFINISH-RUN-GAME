
package Charactor;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.Timer;


public class Objects {
        public int x;
        public int y;
        public int speed;
    	Timer timeMove;
        
	public Objects(int x,int y,int speed,JPanel page) {
		this.x = x;
		this.y = y;
		this.speed = speed;
		this.randomObjects(page);
	}
        		
	public void randomObjects(JPanel page) {
		this.timeMove = new Timer(speed,new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			if(x <= 0) {
                            x = (int) (1000 + (500 + Math.random() * 1000));
			}
			x -= 25;
			page.repaint();
		}
		});
		this.timeMove.start();
	}
}

