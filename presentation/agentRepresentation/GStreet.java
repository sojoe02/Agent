/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package presentation.agentRepresentation;

import java.awt.Graphics;

/**
 *
 * @author Zagadka
 */
public class GStreet {
      private int toposy, fromposy,fromposx, toposx;
    private String name;
    

    public GStreet(String name, int toposx, int fromposy, int toposy, int fromposx) {
        this.toposx = toposx;
        this.toposy = toposy;
        this.name = name;


    }

    public void draw(Graphics graphics) {               
        graphics.drawLine(toposx, toposy, fromposx, fromposy);
    }
}
