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
public class GStore {

    private int posx, posy;
    private String name;
    private Image img = null;

    public GStore(String name, int posx, int posy) {
        this.posx = posx;
        this.posy = posy;
        this.name = name;

        try {
            img = ImageIO.read(new File("images/store00.png"));
        } catch (IOException ex) {
            System.out.println("image not found");
        }
    }

    public void draw(Graphics graphics) {
        Font f = new Font("SansSerif", Font.BOLD, 15);

        graphics.setFont(f);
        graphics.setFont(null);
        graphics.drawString(name, posx, posy);
        graphics.drawImage(img, posx, posy, 40, 30, null);
    }
}
