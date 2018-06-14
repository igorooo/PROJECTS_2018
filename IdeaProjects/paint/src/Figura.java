import java.awt.*;
import java.awt.geom.*;
import java.util.ArrayList;


public class Figura implements Shape {

    public Shape figura;
    public Color color = Color.WHITE;
    public int typ;
    public Panel panel;
    double x,y;


    //Konstruktor dla okręgu

    public Figura(double x, double y, double r, Panel panell)
    {
        panel = panell;
        figura = new Ellipse2D.Double(x,y,2*r,2*r);
        typ = 1;
    }

    public void editoval(double dx, double dy, Color colorr )
    {
        color = colorr;
        double x = figura.getBounds().getCenterX();
        double y = figura.getBounds().getCenterY();
        double r = Math.sqrt((dx - x) * (dx - x) + (dy - y) * (dy - y));
        figura = new Ellipse2D.Double(x - r, y - r, 2 * r, 2 * r);
    }

    //prostokat

    public Figura(double x, double y, double w, double h, Panel panell)
    {
        panel=panell;
        figura = new Rectangle2D.Double(x-(w/2),y-(h/2),w,h);
        typ=2;
    }


    public void editrect(double dx, double dy, Color colorr)
    {
        double x = figura.getBounds().getCenterX();
        double y = figura.getBounds().getCenterY();
        double w = 2*(Math.abs(dx-x));
        double h = 2*(Math.abs(dy-y));
        figura = new Rectangle2D.Double(x-w/2,y-h/2,w,h);
    }

    //wielokat

    public ArrayList<Point2D> points;

    public Figura(double x, double y, Panel pane)
    {
        points=new ArrayList<>();
        figura = new GeneralPath();
        ((GeneralPath)figura).moveTo(x,y);
        points.add(new Point2D.Double(x,y));
        this.x=x;
        this.y=y;
        typ=3;
    }

    public void lineTo(double x, double y)
    {
        ((GeneralPath)figura).lineTo(x,y);
        points.add(new Point2D.Double(x,y));
    }

    public double getx()
    {
        return this.x;
    }

    public double gety()
    {
        return this.y;
    }

    public void closeP()
    {
        GeneralPath ff = new GeneralPath();
        ff.moveTo(points.get(0).getX(),points.get(0).getY());
        for (int i = 1; i <points.size() ; i++)
        {
            ff.lineTo(points.get(i).getX(),points.get(i).getY());
        }
        ff.closePath();
        figura = ff;

    }

    public void move(double dx, double dy){
        if (typ == 1 )
        {
            ((Ellipse2D)figura).setFrame(((Ellipse2D)figura).getX()+dx,((Ellipse2D)figura).getY()+dy, ((Ellipse2D)figura).getWidth(),((Ellipse2D)figura).getHeight());
        }
        if (typ == 2)
        {
            ((Rectangle2D)figura).setFrame(((Rectangle2D)figura).getX()+dx,((Rectangle2D)figura).getY()+dy, ((Rectangle2D)figura).getWidth(),((Rectangle2D)figura).getHeight());
        }
        if (typ == 3)
        {
            ((GeneralPath)figura).transform(AffineTransform.getTranslateInstance(dx,dy));
            for (int i = 0; i < points.size(); i++)
            {
                points.get(i).setLocation(points.get(i).getX()+dx,points.get(i).getY()+dy);
            }

        }
    }

    public void changesize(double f)
    {
        if (typ == 1)
        {
            Ellipse2D e = ((Ellipse2D)figura);
            double nw=e.getWidth()*f;
            double nh=e.getHeight()*f;
            double nx=e.getCenterX()-nw/2;
            double ny=e.getCenterY()-nh/2;
            e.setFrame(nx, ny, nw, nh);
        }
        if (typ == 2)
        {
            Rectangle2D e = ((Rectangle2D)figura);
            double nw=e.getWidth()*f;
            double nh=e.getHeight()*f;
            double nx=e.getCenterX()-nw/2;
            double ny=e.getCenterY()-nh/2;
            e.setFrame(nx,ny,nw,nh );
        }
        if (typ == 3)
        {
            GeneralPath e = ((GeneralPath)figura);
            double x=e.getBounds().getCenterX();
            double y=e.getBounds().getCenterY();
            e.transform(AffineTransform.getTranslateInstance(-x,-y));
            e.transform(AffineTransform.getScaleInstance(f, f));
            e.transform(AffineTransform.getTranslateInstance(x,y));
        }
    }


    @Override
    public Rectangle getBounds() {
        return figura.getBounds();
    }

    @Override
    public Rectangle2D getBounds2D() {
        return figura.getBounds2D();
    }

    @Override
    public boolean contains(double x, double y) {
        return figura.contains(x,y);
    }

    @Override
    public boolean contains(Point2D p) {
        return figura.contains(p);
    }

    @Override
    public boolean intersects(double x, double y, double w, double h) {
        return figura.intersects(x,y,w,h);
    }

    @Override
    public boolean intersects(Rectangle2D r) {
        return figura.intersects(r);
    }

    @Override
    public boolean contains(double x, double y, double w, double h) {
        return figura.contains(x,y,w,h);
    }

    @Override
    public boolean contains(Rectangle2D r) {
        return figura.contains(r);
    }

    @Override
    public PathIterator getPathIterator(AffineTransform at) {
        return figura.getPathIterator(at);
    }

    @Override
    public PathIterator getPathIterator(AffineTransform at, double flatness) {
        return figura.getPathIterator(at,flatness);
    }
}
