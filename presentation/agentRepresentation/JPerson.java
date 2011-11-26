/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package presentation.agentRepresentation;

import java.awt.Color;
import java.awt.Dialog;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JComponent;

/**
 *
 * @author Zagadka
 */
public class JPerson {

    private int posx, posy;
    String name;
    Image img = null;
    String sentence;

    public JPerson(String name, int posx, int posy) {
        this.posx = posx;
        this.posy = posy;
        this.name = name;
        this.sentence = null;


        try {
            img = ImageIO.read(new File("images/man.jpg"));
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
        Font f = new Font("SansSerif", Font.BOLD, 25);

        graphics.setFont(f);
        graphics.setFont(null);
        graphics.drawString(name, posx, posy);
        graphics.drawImage(img, posx, posy, 100, 100, null);   
        if(sentence != null){
            graphics.drawString(sentence, posx, posy+125);
        }

    }
}
