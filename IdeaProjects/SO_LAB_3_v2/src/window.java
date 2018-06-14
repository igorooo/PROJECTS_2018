import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class window extends JFrame {



    private JLabel msg;
    private JButton lengthOfSequenceButton;
    private JButton levelOfNumLocalityButton;
    private JButton generateSequenceButton;
    private JButton amountOfPagesButton;
    private JButton simulateButton;
    private JButton amountOfFramesButton;
    private JTextField frames;
    private JTextField pages;
    private JTextField length;
    private JTextField level;
    private JTextArea text;
    private JButton clearButton;
    private JButton infosButton;
    private JPanel RootPanel;


    int AMOUNT_OF_PAGES;
    int AMOUNT_OF_FRAMES;
    int LENGTH;
    int RADIUS;

    Time time;

    CLOCK clk;
    Thread clkt;
    Generator gen;

    int tab[];

    VirtualMemory vm;



    public window() {

        super("SO LAB 3");

        AMOUNT_OF_PAGES = 200;
        AMOUNT_OF_FRAMES = 50;
        LENGTH = 1000;
        RADIUS = 15;

        time = new Time();

        CLOCK clk;
        Thread clkt;

        gen = new Generator();
        tab = gen.gen();

        vm = new VirtualMemory(AMOUNT_OF_PAGES,AMOUNT_OF_FRAMES,tab,time,text);
        //text.setText("");

        clk = new CLOCK(time);
        clkt = new Thread(clk);
        tab = gen.gen();
        clkt.start();




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
        lengthOfSequenceButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                int var;

                try{
                    var = Integer.parseInt(length.getText());
                    LENGTH = var;

                }

                catch(Exception a){
                    a.printStackTrace();
                    length.setText("Wrong number");

                }

            }
        });
        levelOfNumLocalityButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                int var;

                try{
                    var = Integer.parseInt(level.getText());
                    RADIUS = var;

                }

                catch(Exception a){
                    a.printStackTrace();
                    level.setText("Wrong number");

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
                    vm.setFrames(var);

                }

                catch(Exception a){
                    a.printStackTrace();
                    frames.setText("Wrong number");

                }
            }
        });
        generateSequenceButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                gen.setAMOUNT_OF_PAGES(AMOUNT_OF_PAGES);
                gen.setLENGTH(LENGTH);
                gen.setRADIUS(RADIUS);
                tab = gen.gen();



            }
        });
        simulateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                vm = new VirtualMemory(AMOUNT_OF_PAGES,AMOUNT_OF_FRAMES,tab,time,text);


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
                JLabel label2 = new JLabel("Test page replacement algorithms");
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

        JFrame frame = new JFrame("SO LAB 3");
        frame.setContentPane(new window().RootPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);




    }
}
