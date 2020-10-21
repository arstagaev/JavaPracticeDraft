package snowfall;

import javax.swing.*;

public class SnowFall {

    public static void main(String[] args) {
        JFrame jf = new JFrame("SnowFall...");

        DrawComponent dc = new DrawComponent();
        dc.clockStart();
        jf.add(dc);

        jf.setSize(900,506);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.setVisible(true);

    }
}
