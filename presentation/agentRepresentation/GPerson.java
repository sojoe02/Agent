/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package presentation.agentRepresentation;


import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.Random;
import javax.imageio.ImageIO;
/**
 *
 * @author Zagadka
 */
public class GPerson {

    private int posx, posy;
    String name;
    Image img = null;
    String sentence;

    public GPerson(String name, int posx, int posy) {
        this.posx = posx;
        this.posy = posy;
        this.name = name;
        this.sentence = null;
        Random random = new Random();
        random.nextInt(3);


        try {
            img = ImageIO.read(new File("images/person00"+random.nextInt(3) +".png"));
        } catch (IOException ex) {
            System.out.println("images/man.jpg not found");
        }
    }

    public void updatePos(int posx, int posy) {
        this.posx = posx;
        this.posy = posy;
    }
    
    public void setSentence(String sentence){
        this.sentence = sentence;
    }

    public void draw(Graphics graphics) {
        Font f = new Font("SansSerif", Font.PLAIN, 15);
        graphics.setFont(f);
        graphics.setFont(null);
        graphics.drawString(name, posx, posy);
        graphics.drawImage(img, posx, posy, 29, 45, null);   
        if(sentence != null){
            graphics.drawString(sentence, posx, posy+50);
        }

    }
}
