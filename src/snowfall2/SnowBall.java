package snowfall2;

import java.util.Random;

public class SnowBall {
    Random rand = new Random(); //instance of random class

    int snowX;
    int snowY = 0;

    public int getX() {

        return snowX;
    }
    public int getY() {

        return snowY;
    }

    public void updateLoc() {
        if (snowY<3){
            snowX = rand.nextInt(600);
            snowY++;
        }else{
            snowY = snowY+10;

        }




    }

    public void setSnowY(int snowY) {
        this.snowY = snowY;
    }

    public void setSnowX(int snowX) {
//        Random rand = new Random(); //instance of random class
//        snowX = rand.nextInt(25);
        this.snowX = snowX;
    }
}
