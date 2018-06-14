import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.Ellipse2D;
import java.util.ArrayList;



public class Panel extends JPanel implements MouseListener {
    public ArrayList<Figura> figury = new ArrayList<>();
    double x=10, y=10, X, Y,x1,y1,x2,y2;
    double odl=10;
    public Figura figura;
    public active activ = active.empty;
    int index = 1;
    int tracked;
    boolean track = false;



    public Panel() {
        setOpaque(true);
        setSize(800, 550);

        this.addMouseListener(this);
        this.addMouseMotionListener(new MouseMotionListener() {

            public void mouseDragged(MouseEvent e) {

                X=e.getX();x2=X-x;
                Y=e.getY();y2=Y-y;


                if(activ == active.zKolo)
                {
                    figura.editoval(X,Y,Color.WHITE);
                    repaint();
                }

                if(activ == active.zPros)
                {
                    figura.editrect(X,Y,Color.WHITE);
                    repaint();
                }

                if(activ == active.empty && track)
                {
                    figury.get(tracked).move(x2, y2);
                    repaint();
                    x = X;
                    y = Y;
                }

            }

            @Override
            public void mouseMoved(MouseEvent e) {

            }


        });


        this.addMouseWheelListener(new MouseWheelListener() {
            @Override
            public void mouseWheelMoved(MouseWheelEvent e) {

                if(track)
                {
                    figury.get(tracked).changesize((e.getPreciseWheelRotation()/35)+1);
                    repaint();
                }

            }
        });
    }


    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        this.removeAll();
        this.updateUI();



        for (int i = 0; i < figury.size(); i++)
        {

            g2d.setPaint(figury.get(i).color);
            g2d.fill(figury.get(i));
            g2d.setPaint(Color.BLACK);
            g2d.draw(figury.get(i));
            g2d.setStroke(new BasicStroke(1));

        }

        if(figura != null)
        {
            g2d.setPaint(figura.color);
            g2d.fill(figura);
            g2d.setPaint(Color.BLACK);
            g2d.draw(figura);
            g2d.setStroke(new BasicStroke(1));
        }

        if(track)
        {
            g2d.setStroke(new BasicStroke(5));
            g2d.draw(figury.get(tracked));
        }



    }

   /* public void delete()
    {
        figury.remove(tracked);
        track=false;
        repaint();
    }*/

    @Override
    public void mouseClicked(MouseEvent e) {

        if(track && SwingUtilities.isRightMouseButton(e) && figury.get(tracked).contains(x,y) && activ == active.empty)
        {
            PopUp pop=new PopUp(this);
            pop.show(e.getComponent(),e.getX(), e.getY());
        }

    }

    @Override
    public void mousePressed(MouseEvent e) {

        x=e.getX();
        y=e.getY();

        if (activ == active.empty)
        {

            if(!track)
            {
                for(int i=figury.size()-1;i>=0;i--){
                    if(figury.get(i).contains(x,y))
                    {
                        tracked=i;
                        track = true;
                        repaint();
                        break;
                    }
                }
            }

            else
            {
                track = false;
            }



        }

        if(activ == active.nKolo)
        {
            figura = new Figura(x,y,10,this);
            activ = active.zKolo;
            repaint();
        }

        if(activ == active.nPros)
        {
            figura = new Figura(x,y,10,10,this);
            activ = active.zPros;
            repaint();
        }

        if(activ == active.nWiel)
        {
            figura = new Figura(x,y,this);
            activ = active.zWiel;
            repaint();
        }

        if(activ == active.zWiel)
        {
            x1=figura.getx();
            y1=figura.gety();

            if((((x-x1)*(x-x1) + (y-y1)*(y-y1))  < 500 ) && figura.points.size() > 2  )
            {
                System.out.println("czad");
                figura.lineTo(x1,y1);
                figura.closeP();
                figury.add(figura);
                activ = active.empty;

                repaint();
            }

            else
            {
                figura.lineTo(x,y);
                repaint();
            }

        }


    }

    @Override
    public void mouseReleased(MouseEvent e) {



        if(activ != active.zWiel){
            figury.add(figura);
            activ = active.empty;
        }



    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
