import java.util.ArrayList;
import java.util.Random;

public class Main {



    public static void main(String[] args){

        int AMOUNT_OF_PAGES = 6;
        int AMOUNT_OF_FRAMES = 2;
        int LENGTH = 80;
        int RADIUS = 3;

        //int tab[];// = new int[LENGTH];

        Random rand = new Random();

        Time time = new Time();
        CLOCK clk = new CLOCK(time);
        Thread clkt = new Thread(clk);

        //int tab[] = {3, 3, 2, 3, 0, 0, 3, 2, 4, 0, 1, 4, 3, 0, 4, 3, 2, 3, 2, 1, 0, 1, 0, 0, 4, 0, 3, 2, 5, 5, 2, 1, 0, 3, 4, 0, 0, 1, 3, 5, 2, 2, 2, 1, 3, 0, 0, 5, 5, 4, 1, 2, 0, 1, 1, 2, 4, 3, 4, 3, 2, 1, 2, 0, 0, 1, 2, 0, 2, 3, 1, 1, 1, 0, 0, 2, 1, 5, 5, 5 };
        int tab[] = {1, 2, 1, 1, 0, 1, 3, 1, 1, 2, 4, 3, 3, 2, 4, 3, 5, 3, 4, 4, 5, 4, 2, 4, 0, 1, 3, 5, 5, 5, 5, 3, 4, 2, 1, 3, 1, 3, 4, 2, 4, 1, 3, 0, 1, 1, 4, 4, 2, 0, 0, 0, 5, 5, 5, 1, 0, 0, 2, 0, 0, 0, 1, 0, 0, 0, 0, 1, 3, 1, 5, 0, 0, 1, 0, 3, 4, 1, 2, 5 };


        /** Generowanie ciagu z lokalnie kumulujacymi sie numerami */

        int i = 0;

        /*

        while( i < LENGTH ){

            int x = rand.nextInt(AMOUNT_OF_PAGES-1);  // center of numbers

            int y = rand.nextInt(RADIUS) +1;    // radius

            for(int j = 0; j <= y; j++){



                int n = rand.nextInt(2*y);

                n += (x - y);  //offset vector = x-y

                while( n < 0 ){
                    n++;
                }

                while( n >= AMOUNT_OF_PAGES ){
                    n--;
                }

                tab[i] = n;
                i++;

                if(i >= LENGTH){
                    break;
                }
            }


        } */

        /** END */


        clkt.start();
        VirtualMemory vm = new VirtualMemory(AMOUNT_OF_PAGES,AMOUNT_OF_FRAMES,tab,time);
        vm.show();
        clk.STOP();



    }
}
