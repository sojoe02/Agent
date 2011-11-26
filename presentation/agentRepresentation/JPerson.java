/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package presentation.agentRepresentation;

import java.awt.Color;
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
public class JPerson extends JComponent implements ActionListener, MouseListener {

    public void paint(Graphics graphics) {
        
        Image img = null;
        
        try {
            img = ImageIO.read(new File("images/man.jpg"));
        } catch (IOException ex) {
            System.out.println("images/man.jpg not found");
        }

        graphics.drawImage(img, 50, 50, 100, 100, null);
          
                //        graphics.setColor(Color.white);
                //        graphics.fillOval(50, 50, 100, 100);
                //        graphics.setColor(Color.blue);
                //        graphics.drawOval(50, 50, 100, 100);
                //        graphics.drawRoundRect(10, 10, 100, 100, 5, 5);
    
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void mousePressed(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void mouseExited(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
