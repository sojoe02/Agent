/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package presentation;

import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

/**
 *
 * @author Zagadka
 */
public class Frame {

    private JFrame f = new JFrame("Animated Graphics");
    private Presentation pres;
    
    public Frame(Presentation pres){
        this.pres = pres;
    }

    private void createAndShowGUI() {
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setPreferredSize(new Dimension(1024, 768));
        f.add(pres);  
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
}
