package letissnow;

import java.util.Random;


public class SnowBall{

    //Gives a random horizontal location for the rain drop and velocity
    Random randx = new Random();
    Random randv = new Random();
    //Sets the location vars for the objects on screen
    private int snowx = randx.nextInt(1600) + 4 , snowy = 0, vely = randv.nextInt(4) + 8;
    private boolean wobble = false;

    public int getX() {
        return snowx;
    }
    public int getY() {
        return snowy;
    }

    //Updates the location of each snowflake object

    public void updateLoc() {
        if(snowy >= 900) {
            Random randx = new Random();
            Random randv = new Random();
            snowy = 0;
            snowx = randx.nextInt(1600) + 4;
            vely = randv.nextInt(4) + 8;
            System.out.println("SnowFlake vel = " + vely);
        }


        //!!**Work on making the snowflakes float down
//		 if(wobble == true) {
//			 snowx += 1;
//		 }else {
//			 snowx -= 1;
//		 }

//		 wobble = !wobble;

        snowy += vely;
    }
}


