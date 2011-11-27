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
import javax.imageio.ImageIO;

/**
 *
 * @author Zagadka
 */
public class JStore {

    private int posx, posy;
    private String name;
    private Image img = null;

    public JStore(String name, int posx, int posy) {
        this.posx = posx;
        this.posy = posy;
        this.name = name;

        try {
            img = ImageIO.read(new File("images/store.jpg"));
        } catch (IOException ex) {
            System.out.println("images/store.jpg not found");
        }
    }

    public void draw(Graphics graphics) {
        Font f = new Font("SansSerif", Font.BOLD, 25);

        graphics.setFont(f);
        graphics.setFont(null);
        graphics.drawString(name, posx, posy);
        graphics.drawImage(img, posx, posy, 100, 100, null);
    }
}
