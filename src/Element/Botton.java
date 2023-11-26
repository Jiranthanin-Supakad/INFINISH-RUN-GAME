package Element;

import java.awt.Color;
import java.awt.Font;
import java.io.File;
import javax.swing.JButton;

public class Botton extends JButton{

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
	public Botton(String title,int size,int x,int y,int width,int height) {
		super(title);
		this.setBackground(new Color(255, 255, 255));
		this.setFont(getFont(size));
		this.setBounds(x, y, width, height);
		}
}