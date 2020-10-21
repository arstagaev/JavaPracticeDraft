package snowfall3;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class LetItSnow {

    private JFrame frame;
    private DrawPanel3 drawPanel = new DrawPanel3();

    private int oneX = 7;
    private int oneY = 7;

    private int ovalX = 300;
    private int ovalY = 120;

    private int oval2X = 1;
    private int oval2Y = 120;

    private int sizeoval = 60;
    private int pillarOval = 1;
    private boolean increase = true;

    boolean goToRight = true;

    int a = 0;
    private int numOfFlakes = 400;
    //private SnowBall[] Drops = new SnowBall[numOfFlakes];
    HashMap<Integer, Integer> hashMap = new HashMap<>();
    Random rand = new Random();

    public static void main(String... args)
    {
        new LetItSnow().go();
    }

    private void go()
    {
        frame = new JFrame("by ars");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //drawPanel = new AnimTest2().drawPanel;

        frame.getContentPane().add(BorderLayout.CENTER, drawPanel);

        frame.setResizable(true);
        frame.setSize(360, 360);
        frame.setLocationByPlatform(true);
        frame.setVisible(true);
        initArray();
        moveIt();
        //heartanim();
    }
    public void initArray(){




        for (int o = 0; o<numOfFlakes; o++){
            //Also init all the drops
            hashMap.put(rand.nextInt(400),-rand.nextInt(400) );

            //Drops[o].setSnowX(rand.nextInt(500));
        }
        System.out.println(hashMap.toString());
    }




    class DrawPanel3 extends JPanel
    {
        private static final long serialVersionUID = 1L;
        public void paintComponent(Graphics g) {
           /*
           Parameters:
              x - the x coordinate of the rectangle to be filled.
              y - the y coordinate of the rectangle to be filled.
              width - the width of the rectangle to be filled.
              height - the height of the rectangle to be filled.
            */
            g.setColor(Color.BLACK);
            g.fillRect(0, 0, this.getWidth(), this.getHeight());

            g.setColor(Color.RED);
            g.setFont(new Font("TimesRoman", Font.PLAIN, 50));
            g.drawString("Tatar",60,150);
            g.setColor(Color.GREEN);
            g.setFont(new Font("TimesRoman", Font.PLAIN, 50));
            g.drawString("stan",175,150);



            if (sizeoval>60){
                sizeoval =60;
            }
            for (Map.Entry<Integer, Integer> e : hashMap.entrySet()) {
                Integer key = e.getKey();
                Integer value = e.getValue();
                g.setColor(Color.WHITE);
                g.fillOval(key,value,rand.nextInt(4),rand.nextInt(6));

                e.setValue(value+rand.nextInt(2));

                if ( a% 2== 0) {
                }
                a++;
                if (value>400){ e.setValue(1); }
            }



        }
    }

    private void moveIt() {


        for (int turn = 0; turn<360;turn++ ){


            try
            { Thread.sleep(50); }
            catch (Exception e) { e.printStackTrace(); }

            frame.repaint();
            if (turn>330){
                turn = 0;
            }
        }


    }
}

