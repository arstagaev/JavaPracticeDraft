



import java.awt.*;
import javax.swing.*;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.RenderingHints;
import java.awt.Stroke;
import java.awt.geom.QuadCurve2D;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javax.swing.*;

@SuppressWarnings("serial")
public class ArsChart1 extends JPanel {
    private static final int MAX_SCORE = 20;
    private static final int PREF_W = 800;
    private static final int PREF_H = 650;
    private static final int BORDER_GAP = 30;

    private static final Color GRAPH_COLOR = Color.green;
    private static final Color GRAPH_POINT_COLOR = new Color(150, 50, 50, 180);
    private static final Stroke GRAPH_STROKE = new BasicStroke(3f);
    private static final Stroke GRAPH_STROKE2 = new BasicStroke(3f);

    private static final int GRAPH_POINT_WIDTH = 12;
    private static final int Y_HATCH_CNT = 10;
    private List<Integer> scores;

    double ctrlx;
    double ctrly ;

    public ArsChart1(List<Integer> scores) {
        this.scores = scores;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D)g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        double xScale = ((double) getWidth() - 2 * BORDER_GAP) / (scores.size() - 1);
        double yScale = ((double) getHeight() - 2 * BORDER_GAP) / (MAX_SCORE - 1);

        List<Point> graphPoints = new ArrayList<Point>();
        for (int i = 0; i < scores.size(); i++) {
            int x1 = (int) (i * xScale + BORDER_GAP);
            int y1 = (int) ((MAX_SCORE - scores.get(i)) * yScale + BORDER_GAP);
            graphPoints.add(new Point(x1, y1));
        }

        // create x and y axes
        g2.drawLine(BORDER_GAP, getHeight() - BORDER_GAP, BORDER_GAP, BORDER_GAP);
        g2.drawLine(BORDER_GAP, getHeight() - BORDER_GAP, getWidth() - BORDER_GAP, getHeight() - BORDER_GAP);

        // create hatch marks for y axis.
        for (int i = 0; i < Y_HATCH_CNT; i++) {
            int x0 = BORDER_GAP;
            int x1 = GRAPH_POINT_WIDTH + BORDER_GAP;
            int y0 = getHeight() - (((i + 1) * (getHeight() - BORDER_GAP * 2)) / Y_HATCH_CNT + BORDER_GAP);
            int y1 = y0;
            g2.drawLine(x0, y0, x1, y1);
        }

        // and for x axis
        for (int i = 0; i < scores.size() - 1; i++) {
            int x0 = (i + 1) * (getWidth() - BORDER_GAP * 2) / (scores.size() - 1) + BORDER_GAP;
            int x1 = x0;
            int y0 = getHeight() - BORDER_GAP;
            int y1 = y0 - GRAPH_POINT_WIDTH;
            g2.drawLine(x0, y0, x1, y1);
        }

        Stroke oldStroke = g2.getStroke();
        g2.setColor(GRAPH_COLOR);
        //g2.setStroke(GRAPH_STROKE);
        g2.setStroke(new BasicStroke(4.0f,                      // Width
                BasicStroke.CAP_ROUND,    // End cap
                BasicStroke.CAP_ROUND));     // Dash phase); // Vertex join style docstore.mik.ua/orelly/java-ent/jfc/ch04_05.htm

        QuadCurve2D q = new QuadCurve2D.Float();
        double x1 = 1;
        double y1 = 1;
        double x2 = 4;
        double y2 = 4;
        if ((x2-x1)>0){
            double ctrlx = ((x1+x2)/2)*-1.1;
        }
        if (y2-y1>0){
            double ctrly = ((y1+y2)/2)*-1.1;
        }
        ctrlx = ((x2-x1))*1;
        ctrly = ((y2-y1))*1;

        q.setCurve(x1, y1, ctrlx, ctrly, x2, y2);
        g2.draw(q);
//        for (int i = 0; i < graphPoints.size() - 1; i++) {
//            // create new QuadCurve2D.Float
//
//// draw QuadCurve2D.Float with set coordinates
////            int x1 = graphPoints.get(i).x;
////            int y1 = graphPoints.get(i).y;
////            int x2 = graphPoints.get(i + 1).x;
////            int y2 = graphPoints.get(i + 1).y;
////
//
//            //g2.drawLine(x1, y1, x2, y2);
//        }

    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(PREF_W, PREF_H);
    }

    private static void createAndShowGui() {
        List<Integer> scores = new ArrayList<Integer>();
        Random random = new Random();
        int maxDataPoints = 16;
        int maxScore = 20;
        for (int i = 0; i < maxDataPoints ; i++) {
            scores.add(random.nextInt(maxScore));
        }
        DrawGraph mainPanel = new DrawGraph(scores);

        JFrame frame = new JFrame("DrawGraph");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(mainPanel);
        frame.pack();
        frame.setLocationByPlatform(true);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGui();
            }
        });
    }
}
