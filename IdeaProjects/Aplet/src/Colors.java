import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

import javax.swing.JApplet;


public class Colors extends JApplet {

    private static final long serialVersionUID = -437629470755224352L;

    private Random rand = new Random();
    private int m = 100;
    private int n = 100;
    private Field fields[][];

    int k=500;
    double p = 0.8;


    @Override
    public void init() {
       /* try {
            m = Integer.parseInt(getParameter("m"));
            n = Integer.parseInt(getParameter("n"));
        } catch (NumberFormatException ex) {
            ex.printStackTrace();
            m = 10;
            n = 10;
        }

        double p;
        try {
            p = Double.parseDouble(getParameter("p"));
            if (p < 0) p = 0;
            if (p > 1) p = 1;
        } catch (NumberFormatException ex) {
            ex.printStackTrace();
            p = 0.5;
        }

        int k;
        try {
            k = Integer.parseInt(getParameter("k"));
        } catch (NumberFormatException ex) {
            ex.printStackTrace();
            k = 1000;
        }
        */

        int w = getWidth();
        int h = getHeight();
        int dw = w / m;
        int dh = h / n;

        fields = new Field[m][n];
        for (int x = 0; x < m; ++x) {
            for (int y = 0; y < n; ++y) {
                int left = x * dw;
                int top = y * dh;
                Color color = new Color(rand.nextInt(0x1000000));
                fields[x][y] = new Field(this, rand, x, y, left, top, dw, dh, k, p, color);
            }
        }

        for (int x = 0; x < m; ++x) {
            for (int y = 0; y < n; ++y) {
                fields[x][y].start();
            }
        }
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        for (int x = 0; x < m; ++x) {
            for (int y = 0; y < m; ++y) {
                fields[x][y].paint(g);
            }
        }
    }

    public void avarageField(Field field) {
        int xc = field.getXCoord();
        int yc = field.getYCoord();
        int totalFields = 0;
        int r = 0;
        int g = 0;
        int b = 0;

        for (int x = (xc - 1); x <= (xc + 1); ++x) {
            for (int y = (yc - 1); y <= (yc + 1); ++y) {
                if (x >= 0 && y >= 0 && x < m && y < n) {
                    Color fieldColor = fields[x][y].getColor();
                    r += fieldColor.getRed();
                    g += fieldColor.getGreen();
                    b += fieldColor.getBlue();
                    totalFields++;
                }
            }
        }

        Color color = new Color(r / totalFields, g / totalFields, b / totalFields);
        field.setColor(color);
    }
}
