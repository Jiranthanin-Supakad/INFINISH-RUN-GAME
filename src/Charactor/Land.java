
package Charactor;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import util.Resource;

public class Land {
    private List<LandImage> listLand;
    private BufferedImage land1, land2, land3;
    
    public Land(){
        land1 = Resource.getResouceImage("data/u1.png");
        land2 = Resource.getResouceImage("data/u2.png");
        land3 = Resource.getResouceImage("data/u3.png");
        int numberOfImageLand = 1024 / land1.getWidth() + 2;
        listLand = new ArrayList<LandImage>();
        for(int i = 0; i < numberOfImageLand; i++) {
            LandImage imageLand = new LandImage();
            imageLand.posX = i * land1.getWidth();
            setImageLand(imageLand);
            listLand.add(imageLand);
    }
}

    private int getrandomOfLand(){
        Random random = new Random();
        int type = random.nextInt(10);
        if(type == 1) {
            return 1;
        } else if (type == 9) {
            return 3;
        } else {
            return 2;
        }
    }
    
    public void draw(Graphics g) {
        for(LandImage imgLand : listLand) {
            g.drawImage(imgLand.image, (int) imgLand.posX, 680, null);
        }
    }
    
    private void setImageLand(LandImage listLand) {
        int typeLand = getrandomOfLand();
        if(typeLand == 1) {
            listLand.image = land1;
        } else if(typeLand == 3) {
            listLand.image = land3;
        } else {
            listLand.image = land2;
        }
    }
    
    private class LandImage{
        float posX;
        BufferedImage image;
    }
}
