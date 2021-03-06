package starwars;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

/*
Made by @arstagaev in 2020
 */

public class StarWars {

    private JFrame frame;
    private DrawPanel6 drawPanel = new DrawPanel6();
    private int sizeoval = 2;

    private int numOfFlakes = 1000;
    private int FALLINGSPEED = 1;

    HashMap<Integer, Integer> hashMap = new HashMap<>();
    ArrayList<Float> fountainX = new ArrayList<>();
    ArrayList<Float> fountainY = new ArrayList<>();
    ArrayList<Double> radiansArray = new ArrayList<>();
    ArrayList<Double> speedArray = new ArrayList<>();
    ArrayList<Double> orbitArrayX = new ArrayList<>();
    Random rand = new Random();

    public static void main(String... args)
    {
        new StarWars().go();
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

            radiansArray.add(Math.toRadians(rand.nextDouble()*360));//***
            speedArray.add(rand.nextDouble()*2);
            orbitArrayX.add(rand.nextDouble()*100);

        }
        System.out.println(fountainX.toString());
    }



    int directionCtrl = 2;
    int timeInterval = 0;

    double orbitRadius = 50;
    double orbitSpeed = Math.PI / 90;
    double sphereRadius = 10;

    float currentElementX =100;
    float currentElementY= 100;

    double radian = 0;
    class DrawPanel6 extends JPanel
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
//                currentElementX = fountainX.get(i);
//                currentElementY = fountainY.get(i);
//
//                fountainX.set(i, currentElementX - rand.nextInt(5));
//                fountainY.set(i, currentElementY - rand.nextInt(4));

                g.setColor(Color.WHITE);

                g.fillOval((int)(150+1+orbitArrayX.get(i)*(speedArray.get(i)) * Math.cos(radiansArray.get(i))),
                           (int)(150+1+orbitArrayX.get(i)*(speedArray.get(i)) * Math.sin(radiansArray.get(i))),
                            sizeoval,sizeoval);

               // orbitArrayX.set(i,orbitArrayX.get(i-1)*0.5);

                orbitArrayX.set(i,orbitArrayX.get(i)+1);
                if (orbitArrayX.get(i)>100){
                    if (i!=0){
                        orbitArrayX.set(i,rand.nextDouble()*4);
                    }
                }

            }
//            orbitRadius =orbitRadius+1;
//            if (orbitRadius>1000){
//                orbitRadius=0;
//            }

            timeInterval++;

            g.dispose();
            System.out.println("Orbit R = "+orbitArrayX  );

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


