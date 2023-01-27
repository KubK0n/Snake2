package snake;

import java.awt.*;
import java.util.Random;

public class Apple extends Point {
    private static Random rnd = new Random();

    public Apple() {
        super(rnd.nextInt(Board.FIELD_X), rnd.nextInt(Board.FIELD_Y));
    }

    public void draw(Graphics g) {
        g.setColor(Color.RED);
        g.fillOval(x*Board.SIZE, y*Board.SIZE, Board.SIZE, Board.SIZE);
    }
}
