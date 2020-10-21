package snowfall2;

import javax.swing.*;

class SnowFalling {

    JFrame jf = new JFrame("SnowFallштп");

    public static void main(String[] args) {

        SnowFalling sf = new SnowFalling();
        sf.initFrame();



    }

    private void initFrame() {
        DrawModule dc = new DrawModule();

        jf.add(dc);
        //jf.repaint();

        jf.setSize(900,500);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.setVisible(true);
        dc.initx();
    }

    public void repaintMaster(){
        jf.repaint();
    }
}
