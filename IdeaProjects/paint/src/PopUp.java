
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class PopUp extends JPopupMenu implements ActionListener
{
    Panel panel = null;
    private JMenuItem red;
    private JMenuItem blue;
    private JMenuItem green;
    private JMenuItem yellow;
    private JMenuItem white;
    private JMenuItem magenta;
    private JMenuItem usunButton;
    private Color color=Color.GRAY;

    public PopUp(Panel p)
    {
        panel = p;
        setPreferredSize(new Dimension(150,160));

        usunButton = new JMenuItem("Delete");

        red = new JMenuItem("Red");
        blue = new JMenuItem("Blue");
        green = new JMenuItem("Green");
        yellow = new JMenuItem("Yellow");
        magenta= new JMenuItem("Magenta");
        white = new JMenuItem("White");

        add(red);
        add(blue);
        add(green);
        add(yellow);
        add(magenta);
        add(white);
        add(usunButton);

        red.addActionListener(this);
        blue.addActionListener(this);
        green.addActionListener(this);
        yellow.addActionListener(this);
        magenta.addActionListener(this);
        white.addActionListener(this);
        usunButton.addActionListener(this);
    }

    public void actionPerformed(ActionEvent e)
    {
        Object source = e.getSource();

        if (source==red)
        {
            panel.figury.get(panel.tracked).color = Color.red;
            panel.repaint();
        }
        else if (source==blue)
        {
            panel.figury.get(panel.tracked).color = (Color.blue);
            panel.repaint();
        }
        else if (source==green)
        {
            panel.figury.get(panel.tracked).color = (Color.green);
            panel.repaint();
        }
        else if (source==yellow)
        {
            panel.figury.get(panel.tracked).color = (Color.yellow);
            panel.repaint();
        }
        else if (source==white)
        {
            panel.figury.get(panel.tracked).color = (Color.white);
            panel.repaint();
        }
        else if (source==magenta)
        {
            panel.figury.get(panel.tracked).color = (Color.magenta);
            panel.repaint();
        }
        else if (source==usunButton)//jezeli usuwa
        {
            //panel.delete();
        }
    }
}
