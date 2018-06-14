import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class window extends JFrame {



    private JLabel msg;
    private JButton amountOfPagesButton;
    private JButton simulateButton;
    private JButton amountOfFramesButton;
    private JTextField frames;
    private JTextField pages;
    private JTextArea text;
    private JButton clearButton;
    private JButton infosButton;
    private JPanel RootPanel;




    int AMOUNT_OF_PAGES;
    int AMOUNT_OF_FRAMES;
    int LENGTH;
    int RADIUS;



    VirtualMemory vm;



    public window() {

        super("SO LAB 4");

        AMOUNT_OF_PAGES = 1000;
        AMOUNT_OF_FRAMES = 250;
        LENGTH = 1000;
        RADIUS = 15;

        pages.setText("Default: 1000");
        frames.setText("Default: 500");

        text.setText("Amount of frames shouldnt be less than half of amount of pages. \n If it is, then probability that working set will crush is high.");



        amountOfPagesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                int var;

                try{
                    var = Integer.parseInt(pages.getText());
                    AMOUNT_OF_PAGES = var;

                }

                catch(Exception a){
                    a.printStackTrace();
                    pages.setText("Wrong number");

                }

            }
        });

        amountOfFramesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {


                int var;

                try{
                    var = Integer.parseInt(frames.getText());
                    AMOUNT_OF_FRAMES = var;
                   // vm.setFrames(var);

                }

                catch(Exception a){
                    a.printStackTrace();
                    frames.setText("Wrong number");

                }
            }
        });


        simulateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                vm = new VirtualMemory(AMOUNT_OF_PAGES,AMOUNT_OF_FRAMES,text);


            }
        });

        infosButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                JFrame frame2 = new JFrame("Informations");
                frame2.setSize(500,150);
                frame2.setLocation(300,300);
                frame2.setLayout(new GridBagLayout());
                JLabel label = new JLabel("Program made by \n\nIgor Czeczot   ");
                JLabel label2 = new JLabel("Test frames allocation algorithms");
                frame2.add(label);
                frame2.add(label2);
                frame2.setVisible(true);

            }
        });

        clearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                text.setText("");
            }
        });
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here



    }

    public static void main(String[] args){

        JFrame frame = new JFrame("SO LAB 4");
        frame.setContentPane(new window().RootPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);




    }
}
