


import java.awt.Component;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.GeneralPath;

public class CreateShapes {

    public static void main(String[] args) {

        // Create a frame

        Frame frame = new Frame();

        // Add a component with a custom paint method

        frame.add(new CustomPaintComponent());

        // Display the frame

        int frameWidth = 300;

        int frameHeight = 300;

        frame.setSize(frameWidth, frameHeight);

        frame.setVisible(true);

    }

    /**
     * To draw on the screen, it is first necessary to subclass a Component
     * and override its paint() method. The paint() method is automatically called
     * by the windowing system whenever component's area needs to be repainted.
     */
    static class CustomPaintComponent extends Component {

        public void paint(Graphics g) {

            // Retrieve the graphics context; this object is used to paint shapes

            Graphics2D g2d = (Graphics2D)g;

            /**

             * The coordinate system of a graphics context is such that the origin is at the

             * northwest corner and x-axis increases toward the right while the y-axis increases

             * toward the bottom.

             */

            int x = 0;

            int y = 0;

            int w = getSize().width-1;

            int h = getSize().height-1;

            GeneralPath shape = new GeneralPath();

            shape.moveTo(x, y);

            shape.lineTo(w/4, h/2);

            shape.quadTo(3*w/2, 4*h/3, x/2, y/3);

            shape.curveTo(w, h, w/2, h/4, x, y);

            shape.closePath();

            g2d.draw(shape);

        }

    }

}