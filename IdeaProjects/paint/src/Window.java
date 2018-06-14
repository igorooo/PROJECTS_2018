import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



public class Window extends JFrame
{

    public static final int HEIGHT = 600;
    public static final int WIDTH = 800;
    JButton btnC,btnR,btnP,btnI;

    public static int tape;

    Window()
    {
        super("Figures drawing program");
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
        setLayout(null);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);

        Panel  pane = new Panel();

        setVisible(true);
        setResizable(false);

        btnR = new JButton("Rectangle");
        btnR.setBounds(5,550,140,20);

        add(btnR);

        btnC = new JButton("Circle");
        btnC.setBounds(145,550,140,20);

        add(btnC);

        btnP = new JButton("Polygon");
        btnP.setBounds(285,550,140,20);

        add(btnP);

        btnI = new JButton("Info");
        btnI.setBounds(720,550,70,20);

        add(btnI);

        pack();

        pane.activ = active.start;

        btnI.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e)
            {
                new Information();
            }
        });

        btnR.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e)
            {
                pane.activ = active.nPros;

            }

        });

        btnC.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e)
            {
                pane.activ = active.nKolo;

            }
        });

        btnP.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e)
            {
                pane.activ = active.nWiel;

            }
        });

        add(pane);

        pack();

    }
}