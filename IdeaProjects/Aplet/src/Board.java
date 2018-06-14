import java.applet.Applet;
import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;


class Field extends Thread {

    private Component parent;
    private int x;
    private int y;
    private int width;
    private int height;
    private Color color;


    public Field(Component parent, int x, int y, int width, int height, Color color) {
        this.parent = parent;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.color = color;
        start();
    }

    public void paint(Graphics g) {
        g.setColor(color);
        g.fillRect(x, y, width, height);
    }

    @Override
    public void run() {
        for (;;) {
            try {
                color = new Color((int) (Math.random() * 0x1000000));
                parent.repaint();
                Thread.sleep((int) (Math.random() * 2000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

public class Board extends Applet {

    private static final long serialVersionUID = 8790896860695061640L;

    private Field leftField;
    private Field rightField;


    @Override
    public void init() {
        leftField = new Field(this, 0, 0, 50, 50, Color.RED);
        rightField = new Field(this, 60, 0, 50, 50, Color.GREEN);
    }

    @Override
    public void paint(Graphics g) {
        leftField.paint(g);
        rightField.paint(g);

        super.paint(g);
    }

}