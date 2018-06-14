

import java.awt.event.*;



public class Program
{
    public static void main(String[] args)
    {
        Window start = new Window();
        start.setVisible(true);
        start.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e)
            {
                System.exit(0);
            }
        });
    }
}