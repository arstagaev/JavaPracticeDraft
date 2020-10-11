import javax.swing.*;
import javax.swing.border.AbstractBorder;
import java.awt.*;
import java.awt.geom.Path2D;
import java.awt.geom.Rectangle2D;
import java.awt.geom.RoundRectangle2D;

public class RoundedRectangleTest extends JFrame {
    public RoundedRectangleTest() {
        setTitle("RoundedRectangle Test");
        setSize(350, 275);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //setLocationRelativeTo(null);
        setVisible(true);
    }
    public void paint(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.drawRoundRect(1, 50, 150, 150, 50, 3); // to draw a rounded rectangle.
    }
    public static void main(String []args) {
        new RoundedRectangleTest();
    }
}