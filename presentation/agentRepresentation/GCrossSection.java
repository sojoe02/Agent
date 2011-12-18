/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package presentation.agentRepresentation;

import java.awt.Color;
import java.awt.Graphics;

/**
 *
 * @author Zagadka
 */
public class GCrossSection {
    private int posx, posy;
    private String name;
    

    public GCrossSection(String name,int posx, int posy) {
        //System.out.println(posy);
        this.posx = posx;
        this.posy = posy;
        this.name = name;        
    }

    public void draw(Graphics graphics) {        
        graphics.setColor(Color.red);
        graphics.drawRect(posx, posy, 20, 20);
            
    }
    
}
