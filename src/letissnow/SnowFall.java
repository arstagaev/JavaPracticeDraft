package letissnow;

import javax.swing.JFrame;


public class SnowFall {
    public static void main(String args[]) {
        System.out.println("Hello");
        JFrame win = new JFrame("SnowFall...");

        DrawingComponent DC = new DrawingComponent();
        DC.clockStart();
        win.add(DC);

        win.setSize(900,506);
        win.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        win.setVisible(true);
    }
}
