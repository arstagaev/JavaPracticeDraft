package letissnow;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.image.*;
import javax.imageio.*;
import java.io.*;

public class DrawingComponent extends JPanel implements ActionListener{


    /**
     *
     */
    private static final long serialVersionUID = -7756330398076254264L;

    //Initializes the world timer
    private Timer worldT = new Timer (5,this);

    //Sets the number of RainDrop objects generated
    private int numOfDrops = 1200;
    //Makes an array of RainDrop objects
    private SnowBall[] Drops = new SnowBall[numOfDrops];


    public void clockStart(){
        //Also init all the drops
        for(int i=0; i<numOfDrops ; i++){
            Drops[i] = new SnowBall();
        }

        worldT.start();
        System.out.println("Object clocks initialized :)");
    }


    //Loads these images in as a BufferedImage class when called
    BufferedImage snowflakeSmall,snowflakeBig,backdrop,foreground;

    public void imageLoad () throws IOException{
        File file = new File("backDrop.png");
        backdrop = ImageIO.read(file);

        File file1 = new File("snowflakeSmall.png");
        snowflakeSmall = ImageIO.read(file1);

        File file3 = new File("snowflakeBig.png");
        snowflakeBig = ImageIO.read(file3);

        File file2 = new File("foreground.png");
        foreground = ImageIO.read(file2);
    }

    //Paints to the JPanel
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D)g;

        //Runs the function to load in the images
        try {
            imageLoad();
        }   catch (IOException e) {
            System.out.println("Image failed to load");
        }

        setBackground(Color.BLACK);
        Rectangle rect1 = new Rectangle(20,20,50,50);
        g2d.draw(rect1);
        g2d.drawImage(backdrop,0,0,null);

        //Draws all the raindrops!
        for(int c = numOfDrops/8; c<numOfDrops; c++) {
            g2d.drawImage(snowflakeSmall,Drops[c].getX(),Drops[c].getY(),null);
        }

        //Draws the foreground (The boy and girl) for layering effect
        g2d.drawImage(foreground,0,310,null);


        for(int k = 0; k<numOfDrops/8; k++) {
            g2d.drawImage(snowflakeBig,Drops[k].getX(),Drops[k].getY(),null);
        }


        //Creates a "text console"
        g2d.setColor(Color.WHITE);
        g2d.drawString("~By Nick Rich~", 12, 450);
        g2d.drawString("Window Size : "+getWidth()+"X"+getHeight(), 10, 465);
        g2d.drawString("Panel repaints every "+worldT.getDelay()+"ms",10,480);
    }

    public void actionPerformed(ActionEvent e){
        for(int j = 0; j<numOfDrops; j++) {
            Drops[j].updateLoc();
        }
        repaint();
    }


}