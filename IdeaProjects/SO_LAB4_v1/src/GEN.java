import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class GEN {

    ArrayList<Page> pages;
    ArrayList<Proces> process;
    int AMOUNT_OF_PAGES;
    Random rand = new Random();



    public GEN(ArrayList<Page> pages, int AMOUNT_OF_PAGES){

        this.pages = pages;
        this.AMOUNT_OF_PAGES = AMOUNT_OF_PAGES;

    }

    public ArrayList<Proces> generate(){

        ArrayList<Integer> temp = new ArrayList<>();
        process = new ArrayList<Proces>();
        int val = 0;
        int var;
        int am;
        int sum = 0;
        Proces proc;


        for(int i = 0; i < 10; i++){       //rand 10 amounts of pages for process

            int r = rand.nextInt(AMOUNT_OF_PAGES-1) +1;
            Integer rr = new Integer(r);


            while( temp.contains(rr) ){
                r = rand.nextInt(AMOUNT_OF_PAGES-1) +1;
                rr = new Integer(r);
            }

            temp.add(r);
        }

        Collections.sort(temp);

        for(int i = 0; i < 10; i++){

            var = temp.get(i);
            am = 0;


            if(i == 0){
                am = var;
            }

            if( i != 0){
                am = var - val;
            }

            /*for(Page pagee: pages){
                System.out.println("vm-- "+pagee);

            } */

            proc = new Proces( i, am,val,var,pages);
            process.add(proc);
            val = var;

            sum += am;

        }

        return process;
    }



}
