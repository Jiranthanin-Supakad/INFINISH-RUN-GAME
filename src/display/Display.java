package display;

import Element.Botton;
import java.awt.Color;
import java.awt.Graphics;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

import javax.swing.JFrame;

import javax.swing.Timer;
import util.Resource;


public class Display extends JFrame implements ActionListener{
	private BufferedImage displaybackground;
        Timer timer;
        static Game game;

        
	public Display() {
            this.setTitle("INFINIX RUN GAME");
            this.setSize(1024,768);
            this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            this.setResizable(false);//ไม่ให้เปลี่ยนขนาด
            this.setLocationRelativeTo(null);
            this.setVisible(true);
            this.fistpage();
                                      
	}

        private void fistpage(){
            Botton play = new Botton("PLAY",50,400,400,200,80);
            play.setForeground(Color.BLACK);
            play.setBackground(new Color(0-255-51));
            play.setBorderPainted(false);
            play.setFocusPainted(false); 
            //play.setContentAreaFilled(false);
                
            Botton exit = new Botton("EXIT",50,400,500,200,80);
            exit.setForeground(Color.BLACK);
            exit.setBackground(new Color(0-255-51));
            exit.setBorderPainted(false);
            exit.setFocusPainted(false); 
            //exit.setContentAreaFilled(false);
                
                  
        play.addActionListener ( new ActionListener ( ){
            public void actionPerformed ( ActionEvent event ){
                getContentPane().add(new Game());
                add(new Game());
                removeContent();
                add(new Game());
            }
        });
            this.add(play);            			
	exit.addActionListener(new ActionListener() {
	public void actionPerformed(ActionEvent e) {
                System.exit(0);          
	    }
	});
            this.add(exit);                         
        }
        
	@Override
        public void paint(Graphics g){
            displaybackground = Resource.getResouceImage("data//displaystart.jpg");
                g.drawImage( displaybackground, 0, 0, this);
        }
        
	private void removeContent() {
		this.getContentPane().removeAll();
		this.getContentPane().repaint();
	}
	
	public void End(long point) {
		removeContent();
		this.getContentPane().add(new Menu(point,this));
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		removeContent();
		Game game = new Game();
		this.getContentPane().add(game);
		game.requestFocus();

	}
}