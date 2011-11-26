import java.awt.*;
import javax.swing.*;
public class GfxTest extends Canvas
{
    public GfxTest()
    {
    }
    public void paint(Graphics graphics)
    {
        graphics.drawLine(10, 20, 300, 310);
        /* We would be using this method only for the sake
         * of brevity throughout the current section. Note
         * that the Graphics class has been acquired along
         * with the method that we overrode. */
    }
    public static void main(String[] args)
    {
        GfxTest canvas = new GfxTest();
        JFrame frame = new JFrame();
        frame.setSize(400, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(canvas);
        frame.setVisible(true);
    }
}