/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package presentation;

import presentation.agentRepresentation.*;
import java.awt.Canvas;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.*;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.Random;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Soren V. Jorgensen
 */
public class Presentation extends JComponent implements MouseListener {

    private void createAndShowGUI() {        
        JFrame f = new JFrame("Animated Graphics");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setPreferredSize(new Dimension(800, 600));
        JPerson mp = new JPerson();
        mp.setBackground(Color.yellow);
        f.add(mp);
        f.setVisible(true);
        f.pack();
        //f.addMouseListener(mp);        
    }    
    
    public void showGui() {

        Runnable doCreateAndShowGUI = new Runnable() {

            @Override
            public void run() {

                createAndShowGUI();
            }
        };
        SwingUtilities.invokeLater(doCreateAndShowGUI);
        try {
            Thread.sleep(2);
        } catch (Exception e) {
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
