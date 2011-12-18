/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package presentation;

import presentation.agentRepresentation.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.*;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Soren V. Jorgensen
 */
public class Presentation extends JComponent implements MouseListener {

    private HashMap<String, GPerson> persons = new HashMap<String, GPerson>();
    private HashMap<String, GStore> stores = new HashMap<String, GStore>();
    private HashMap<String, GCrossSection> crosssections = 
            new HashMap<String, GCrossSection>();

    public Presentation() {
        
    }

    @Override
    public synchronized void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();
        actorRender(g);
    }

    public synchronized void actorRender(Graphics g) {
        Collection p = persons.values();
        Iterator<GPerson> itr = p.iterator();
        while (itr.hasNext()) {
            itr.next().draw(g);
        }
        
        Collection s = stores.values();
        //System.out.println(stores.size());
        Iterator<GStore> sitr = s.iterator();
        while (sitr.hasNext()) {
            sitr.next().draw(g);
        }
        
        Collection t = crosssections.values();
        //System.out.println(crosssections.size());
        Iterator<GCrossSection> titr = t.iterator();
        while (titr.hasNext()) {
            titr.next().draw(g);
        }
        
        
    }

    public synchronized void addStore(String name, int posx, int posy) {
        GStore tmp = new GStore(name, posx, posy);
        stores.put(name, tmp);
    }
    
    public synchronized void addCross(String name, int posx, int posy) {
        GCrossSection tmp = new GCrossSection(name, posx, posy);
        crosssections.put(name, tmp);
    }

    public synchronized void updatePos(String name, int posx, int posy) {
        if (!persons.containsKey(name)) {
            GPerson tmp = new GPerson(name, posx, posy);
            persons.put(name, tmp);
        } else {
            GPerson tmp = persons.get(name);
            tmp.updatePos(posx, posy);
        }
    }

    public void updateSpeech(String name, String sentence) {
        if (persons.containsKey(name)) {
            persons.get(name).setSentence(sentence);
        }
    }

    public void mouseClicked(MouseEvent me) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void mousePressed(MouseEvent me) {
        repaint();
    }

    public void mouseReleased(MouseEvent me) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void mouseEntered(MouseEvent me) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void mouseExited(MouseEvent me) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
