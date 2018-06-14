import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;


public class Field extends Thread {

    private Colors parent;
    private Random rand;
    private Color color;
    private int xCoord;
    private int yCoord;
    private int left;
    private int top;
    private int width;
    private int height;
    private int k;
    private double p;    /**Kolumna*/
    public int m;
    /**Wiersz*/
    public int n;
    /**Szybkosc*/
    public int k;
    /**Prawdopodobienstwo*/
    public double p;
    for(int i=0;i<m;i++)
    {
        for(int j=0;j<n;j++)
        {
            grid[i][j]=new Board(this,i,j,k,p);
            threads[i][j]=new Thread(grid[i][j]);
            add(grid[i][j]);
        }
    }

    for(int i=0;i<m;i++)
    {
        for(int j=0;j<n;j++)
        {
            threads[i][j].start();
        }
    }

    pack();


    public Field(Colors parent, Random rand, int xCoord, int yCoord,
                 int left, int top, int width, int height, int k, double p,
                 Color color) {

        this.parent = parent;
        this.rand = rand;
        this.xCoord = xCoord;
        this.yCoord = yCoord;
        this.width = width;
        this.height = height;
        this.left = left;
        this.top = top;
        this.color = color;
        this.k = k;
        this.p = p;
    }

    public void paint(Graphics g) {
        g.setColor(color);
        g.fillRect(left, top, width, height);
    }

    public void setColor(Color color) {
        this.color = color;
        parent.repaint(left, top, width, height);
    }

    @Override
    public void run() {
        for (;;) {
            double eventProbability = rand.nextDouble();
            if (eventProbability <= p) {
                setColor(new Color(rand.nextInt(0x1000000)));
            } else {
                parent.avarageField(this);
            }

            try {
                int sleepTime = (int) ((rand.nextDouble() + 0.5) * k);
                Thread.sleep(sleepTime);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
    }

    public int getXCoord() {
        return xCoord;
    }

    public int getYCoord() {
        return yCoord;
    }

    public Color getColor() {
        return color;
    }
}