
package display;

import Charactor.MainCharacter;
import static display.Game.display;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.io.File;

public class Point {
    private long point = 0;
    private MainCharacter MainCharacter;
    
    public Point(){}
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
    
    public void update(Graphics g){
        g.setFont(getFont(20));
	g.setColor(Color.white);
	g.drawString("Point : "+ point, 48 ,65);
        this.point += 1;
    }

    
    public void reset(){
        if(MainCharacter.health <= 0) {
            display.End(this.point);
		MainCharacter.health = new MainCharacter().health;
		this.point = 0;	
	}
    }
}
