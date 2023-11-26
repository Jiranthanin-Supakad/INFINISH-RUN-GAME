package display;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.*;

import Charactor.*;
import event.Event;

import java.awt.image.BufferedImage;
import util.Resource;

public class Game extends JPanel implements KeyListener{
    private static int speed = 60,MainCharacterSize = 80  ,Height = 60;
    private static int base= 630, mark = 1000;
    private BufferedImage imagebackground;
    private MainCharacter MainCharacter = new MainCharacter(150 , 600);
    static Display display;
    private Objects[] objects = Objects(5);
    private Land land;
    private BufferedImage imageObjects;
    private Point point;
    public long point1 = 0;
    private MainCharacter MainCharacter1;
    
    
	public Game(){
            MainCharacter1 = new MainCharacter();
            land = new Land();
            point = new Point();
            this.setBounds(0,0,1024,768);
	    this.addKeyListener(this);
	    this.setLayout(null);
	    this.setFocusable(true);   
	}
	
	@Override
	public void paint(Graphics g) {
            super.paint(g);
		Graphics2D g2 = (Graphics2D) g;
                imagebackground = Resource.getResouceImage("data//Bg2.png");
                g.drawImage(imagebackground, 0, 0, this);
                
                land.draw(g2);
                
		g.setColor(Color.RED);
                MainCharacter1.MainCharacterTapHealth(g);
                Health(g);
		g.drawImage(MainCharacter.getImage(),MainCharacter.x,MainCharacter.y,MainCharacterSize,MainCharacterSize + 40, null);
                
		for(Objects item : objects) {
			Objectsrun(item,g2);
                }    
		point.update(g);
                this.point1 += 1;
			
	}
        	
	private Objects[] Objects(int num) {
		Objects[] Set = new Objects[num];
		int far = 500;
		for(int i=0;i<num;i++) {
			Set[i] = new Objects(mark + far, base + 40 ,speed,this);
			far+=500;
		}
		return Set;
	}
        
        private void Health(Graphics g){
            Graphics2D g2 = (Graphics2D) g;
            g2.drawLine(60, 30,70 + MainCharacter.health,30);	
            g2.setColor(Color.white);
            g2.setStroke(new BasicStroke(6.0f));
            g2.drawRect(50,20, 230,20);
        }
	
	private void Objectsrun(Objects objects,Graphics2D g2) {
            imageObjects = Resource.getResouceImage("data//M1.png");
		g2.drawImage(imageObjects ,objects.x ,(objects.y - Height), 35, Height+50 ,null);
		if(Event.MainCharacterHit(MainCharacter, objects , MainCharacterSize,Height)){
					g2.setColor(new Color(153, 0, 0));
					g2.fillRect(0, 0,getWidth(),getHeight());			
					MainCharacter.health-=15;
	
    }
}
	
	@Override
	public void keyPressed(KeyEvent e) {
	if(e.getKeyCode()== 32){
		MainCharacter.jump(this);
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {}

	@Override
	public void keyReleased(KeyEvent e) {}
	
	public static void main(String[] arg) {
		 display = new Display();
	}
}