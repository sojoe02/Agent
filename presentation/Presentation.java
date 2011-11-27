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

    private HashMap<String, JPerson> persons = new HashMap<String, JPerson>();
    private HashMap<String, JStore> stores = new HashMap<String, JStore>();

    public Presentation() {
    }

    @Override
    public void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();
        peopleRender(g);
    }

    public void peopleRender(Graphics g) {
        Collection p = persons.values();
        Iterator<JPerson> itr = p.iterator();

        while (itr.hasNext()) {
            itr.next().draw(g);
        }
        Collection s = stores.values();
        Iterator<JStore> sitr = s.iterator();

        while (sitr.hasNext()) {
            sitr.next().draw(g);
        }
    }

    public void addStore(String name, int posx, int posy) {
        JStore tmp = new JStore(name, posx, posy);
        stores.put(name, tmp);
    }

    public void updatePos(String name, int posx, int posy) {
        if (!persons.containsKey(name)) {
            JPerson tmp = new JPerson(name, posx, posy);
            persons.put(name, tmp);
        } else {
            JPerson tmp = persons.get(name);
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
