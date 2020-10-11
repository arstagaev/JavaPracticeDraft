


import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class Snowman
{
    public void buildGUI()
    {
        JFrame f = new JFrame();

        f.getContentPane().add(new SnowmanImagePanel("Snowman.gif"));
        f.setSize(500,500);
        f.setLocationRelativeTo(null);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setResizable(false);
        f.setVisible(true);
    }
    public static void main(String[] args)
    {
        SwingUtilities.invokeLater(new Runnable(){
            public void run(){
                new Snowman().buildGUI();
            }
        });
    }
}

class SnowmanImagePanel extends JPanel
{
    Image img;
    public SnowmanImagePanel(String file)
    {
        setLayout(new BorderLayout());
        try
        {
            img = javax.imageio.ImageIO.read(new java.net.URL(getClass().getResource(file), file));
        }
        catch(Exception e){}
        add(new FallingSnow());
    }
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        if(img != null) g.drawImage(img,0,0,getWidth(),getHeight(),this);
    }
}
class FallingSnow extends JPanel
{
    java.util.List<SnowLayer> snowLayers = new java.util.ArrayList<SnowLayer>();
    public FallingSnow()
    {
        setOpaque(false);
        startTheSnow();
    }
    public void startTheSnow()
    {
        ActionListener al = new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                snowLayers.add(new SnowLayer());
                repaint();
                if(snowLayers.size() > 9)
                {
                    snowLayers.remove(0);
                    snowLayers.add(new SnowLayer());
                }
            }
        };
        new javax.swing.Timer(100,al).start();
    }
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        g.setColor(Color.WHITE);
        for(int x = 0, y = snowLayers.size(); x < y; x++)
        {
            SnowLayer snowLayer = (SnowLayer)snowLayers.get(x);
            for(int z = 0, zz = snowLayer.snowFlakes.length; z < zz; z++)
            {
                SnowFlake snowFlake = snowLayer.snowFlakes[z];
                g.fillOval(snowFlake.x,snowFlake.y,10,10);
                snowFlake.y += 50;
            }
        }
    }
}
class SnowLayer
{
    SnowFlake[] snowFlakes;

    static java.util.Random r = new java.util.Random();
    public SnowLayer()
    {
        snowFlakes = new SnowFlake[r.nextInt(6)+5];
        for(int x = 0, y = snowFlakes.length; x < y; x++)
        {
            snowFlakes[x] = new SnowFlake();
        }
    }
}
class SnowFlake
{
    int x;
    int y;
    static java.util.Random r1 = new java.util.Random();
    public SnowFlake()
    {
        x = r1.nextInt(500);
        y = 10;
    }
}