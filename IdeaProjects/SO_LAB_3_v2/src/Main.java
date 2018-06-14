import java.util.ArrayList;
import java.util.Random;

public class Main {



    public static void main(String[] args){

        int AMOUNT_OF_PAGES = 200;
        int AMOUNT_OF_FRAMES = 50;
        int LENGTH = 1000;
        int RADIUS = 15;

        int tab[];

        Random rand = new Random();

        Time time = new Time();
        CLOCK clk = new CLOCK(time);
        Thread clkt = new Thread(clk);

        Generator gen = new Generator();

        tab = gen.gen();



        clkt.start();
        VirtualMemory vm = new VirtualMemory(AMOUNT_OF_PAGES,AMOUNT_OF_FRAMES,tab,time);
        //vm.show();
        clk.STOP();



    }
}
