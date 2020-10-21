package snowfall2;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;

public class DrawModule extends JPanel  {
    SnowFalling sf = new SnowFalling();

    int ovalX, ovalY = 20;
    int sizeoval = 10;
    int numOfFlakesStart = 0;
    int numOfFlakes = 20;
    Random rand = new Random(); //instance of random class
    int upperbound = 25;
    int fps = 0;

    private SnowBall[] Drops = new SnowBall[numOfFlakes];
    //Initializes the world timer
    //private Timer worldT = new Timer (5,this);

    public void initx() {

        try {
            imageLoad();
        } catch (IOException e) {
            e.printStackTrace();
        }
        //Moveit();

        for (int o = 0; o<numOfFlakes; o++){
            //Also init all the drops
            Drops[o] = new SnowBall();
            Drops[o].setSnowX(rand.nextInt(500));



        }
        //worldT.start();

    }
    //Loads these images in as a BufferedImage class when called
    BufferedImage snowflakeSmall,snowflakeBig,backdrop;
    // BufferedImage foreground;
    public void imageLoad () throws IOException {

        File file1 = new File("snowflakeSmall.png");
        snowflakeSmall = ImageIO.read(file1);
    }

    //Paints to the JPanel
    public void paintComponent(Graphics g){
        super.paintComponent(g);
       // Graphics2D g2d = (Graphics2D)g;
        System.out.println("Size Is = "+ Drops.length);
        //g.clearRect(0, 0, 500, 400);


        //setBackground(Color.BLACK);
//        Rectangle rect1 = new Rectangle(20,20,50,50);
//        g.draw(rect1);

//        while (numOfFlakesStart<numOfFlakes){
//
//        }

//        if (fps%2==0){
//            for (int a = 0; numOfFlakes>a; a++){
//
//                Drops[a].updateLoc();
//
//                int int_random = rand.nextInt(upperbound);
//                g.setColor(Color.RED);
//                //Drops[a].setSnowY(Drops[a].getY()+10);
//               g.fillOval(Drops[a].getX(),Drops[a].getY(),sizeoval,sizeoval);
//               // g.drawImage(snowflakeSmall,Drops[a].getX(),Drops[a].getY(),null);
//
//                numOfFlakesStart++;
//
//            }
//
//        }
        g.setColor(Color.RED);
        g.fillOval(fps,fps,sizeoval,sizeoval);

        g.setColor(Color.YELLOW);
        g.fillOval(Drops[1].getX(),Drops[1].getY(),sizeoval,sizeoval);


        //g.clearRect(0, 0, 100, 400);

        updateUI();

    }
//    public void Moveit(){
//        for (int a = 0; a<100;a++ ){
//            fps++;
//            updateUI();
//        }
//    }

    public void updateUI(){

        //removeAll();
        //FPS
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //sf.repaintMaster();
        repaint();
    }


//    public DrawModule() {
//        Timer timer = new Timer(10, new ActionListener() {
//            public void actionPerformed(ActionEvent arg0) {
//                DrawModule.this.repaint();
//            }
//        });
//        timer.start();
//    }


//    @Override
//    public void actionPerformed(ActionEvent actionEvent) {
//        for (int j = 0; j < numOfFlakes; j++) {
//            Drops[j].updateLoc();
//        }
//        repaint();
//    }

}



