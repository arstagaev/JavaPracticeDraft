package starwars;


import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

/*
Made by @arstagaev in 2020
 */

public class CircleMove {

    private JFrame frame;
    private DrawPanel3 drawPanel = new DrawPanel3();
    private int sizeoval = 60;

    private int numOfFlakes = 4000;
    private int FALLINGSPEED = 6;

    HashMap<Integer, Integer> hashMap = new HashMap<>();
    ArrayList<Float> fountainX = new ArrayList<>();
    ArrayList<Float> fountainY = new ArrayList<>();
    Random rand = new Random();

    public static void main(String... args)
    {
        new CircleMove().go();
    }

    private void go()
    {
        frame = new JFrame("by ars");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

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
            //hashMap.put(rand.nextInt(400),-rand.nextInt(400) );
            fountainX.add(100*rand.nextFloat());
            fountainY.add(100*rand.nextFloat());

        }
        System.out.println(fountainX.toString());
    }



    int directionCtrl = 2;
    int timeInterval = 0;

    double orbitRadius = 50;
    double orbitSpeed = Math.PI / 60;
    double sphereRadius = 10;
    class DrawPanel3 extends JPanel
    {
        private static final long serialVersionUID = 1L;
        double gCos(double y) {
            return Math.cos(y);
        }
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

            for (int i = 0; i<fountainX.size(); i++){
//                int currentElementX = fountainX.get(i);
//                int currentElementY = fountainY.get(i);
                float currentElementX = fountainX.get(i);
                float currentElementY = fountainY.get(i);


//                if (directionCtrl == 1) {
//                    fountainX.set(i, currentElementX - rand.nextInt(5));
//                    fountainY.set(i, currentElementY - rand.nextInt(4));
//                    directionCtrl = 2;
//                }else if (directionCtrl == 2){
//                    fountainX.set(i,currentElementX-1);
//                    fountainY.set(i,currentElementY-rand.nextInt(3));
//                    directionCtrl = 3;
//
//                }else if (directionCtrl == 3){
//                    fountainX.set(i,currentElementX-rand.nextInt(2));
//                    fountainY.set(i,currentElementY+rand.nextInt(1));
//                    directionCtrl = 4;
//                }else if (directionCtrl == 4) {
//                    fountainX.set(i, currentElementX + rand.nextInt(5));
//                    fountainY.set(i, currentElementY + 1);
//                    directionCtrl = 5;
//
//                }else if (directionCtrl == 5){
//                    fountainX.set(i,currentElementX+1);
//                    fountainY.set(i,currentElementY+rand.nextInt(3));
//                    directionCtrl = 6;}
//
//                else if (directionCtrl == 6){
//                    fountainX.set(i,currentElementX+1);
//                    fountainY.set(i,currentElementY+rand.nextInt(4));
//                    directionCtrl = 7;
//                }else if (directionCtrl == 7) {
//                    fountainX.set(i, currentElementX + rand.nextInt(2));
//                    fountainY.set(i, currentElementY - rand.nextInt(3));
//                    directionCtrl = 8;
//                }else if (directionCtrl == 8){
//                    fountainX.set(i,currentElementX-rand.nextInt(4));
//                    fountainY.set(i,currentElementY-1);
//                    directionCtrl = 1;
//                }
                fountainX.set(i, currentElementX - rand.nextInt(5));
                fountainY.set(i, currentElementY - rand.nextInt(4));

            }
            double radian = orbitSpeed * timeInterval;
//                double drawX = orbitX + orbitRadius * Math.cos(radian);
//                double drawY = orbitY + orbitRadius * Math.sin(radian);
            g.setColor(Color.RED);
            g.fillOval((int)(150+orbitRadius * Math.cos(radian)),(int)(150+orbitRadius * Math.sin(radian)),20,20);


            timeInterval++;

            //g.setColor(Color.WHITE);
            //g.fillOval((int) ((int)7.34+rand.nextInt(5)), (int) ((int)8f +rand.nextInt(5)), 7, 7);
            //g.fillOval(fountainY.get(i), fountainX.get(i),2,2);
            // g.fillOval(12f,213f,23f,34f);
            g.dispose();




//            for (Map.Entry<Integer, Integer> e : hashMap.entrySet()) {
//                sizeoval = rand.nextInt(4);
//
//                Integer key = e.getKey();
//                Integer value = e.getValue();
//                g.setColor(Color.WHITE);
//                g.fillOval(key,value,sizeoval,sizeoval);
//
//                e.setValue(value+rand.nextInt(2));
//
//                if (value>400){ e.setValue(1); }
//            }


        }
    }

    private void moveIt() {
        for (int turn = 0; turn<360;turn++ ){
            try
            { Thread.sleep(FALLINGSPEED); }
            catch (Exception e) { e.printStackTrace(); }

            frame.repaint();
            if (turn>330){
                turn = 0;
            }
        }
    }
}

