import javax.swing.*;
import java.awt.*;


class Information extends JDialog
{
    JTextArea desc;
    JLabel t;

    Information()
    {
        setTitle("Info");
        setLocationRelativeTo(null);

        setSize(320,300);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);

        t = new JLabel();
        t.setText("Figures drawing program");
        t.setFont(new Font("SansSerif", Font.BOLD, 18));
        t.setBounds(60, 11, 274, 21);
        add(t);


        desc = new JTextArea();
        desc.setEditable(false);

        desc.setText
                (
                        "This program will let user draw \n" +
                                " simple shapes like: \n"+
                                "circle, rectangle and polygon\n" +
                                " and edit those figures\n" +
                                " \n\nAuthor - Igor Czeczot"
                );
        desc.setFont(new Font("SansSerif", Font.BOLD, 15));
        desc.setBounds(20, 80, 300, 150);
        add(desc);

        setResizable(false);
        setVisible(true);

    }

}
