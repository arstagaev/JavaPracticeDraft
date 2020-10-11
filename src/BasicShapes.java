import java.awt.geom.GeneralPath;

public class BasicShapes {
    public static void main(String[] args) {
        GeneralPath shape = new GeneralPath();
        shape.moveTo(1, 1);
        shape.lineTo(2, 2);
        shape.quadTo(3, 3, 4, 4);
        shape.curveTo(5, 5, 6, 6, 7, 7);
        shape.closePath();
        System.out.println(101%2);
    }
}