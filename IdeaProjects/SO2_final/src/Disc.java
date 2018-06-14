import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Disc implements Runnable {

    List<Unit> queue = new ArrayList<Unit>();

    Random rand = new Random();

    /** LOTTERY STATMENT IN EVERY ALGORITHM WILL SIMULATE REALTIME APPEARANCE EFFECT */

    int LOTTERY;
    private int CHANCE = Main.CHANCE_FOR_REALTIME_APPEARANCE;
    boolean flag;

    public Disc(){

        Random rand = new Random();

        for(int i=0; i < Main.MAX_UNITS; i++){
            queue.add(new Unit(rand.nextInt(Main.MAX_BLOCKS),rand.nextInt(Main.MAX_DEADLINE)));
        }

    }



    public int FCFS(){
        int TOTAL = 0;
        int next = 1;
        Unit arg,current;
        current = queue.get(0);
        int i=0;


        while(!AllDone(queue)){

            while(queue.get(next).isDone()){

                if(next == queue.size()-1){
                    next = 0;
                }

                next++;
            }


            TOTAL += Math.abs(queue.get(i).getBlock() - queue.get(next).getBlock());
            queue.get(i).setDone(true);

            LOTTERY = rand.nextInt(CHANCE);

            if(LOTTERY == 1){

                arg = NextShortestDeadline(queue.get(i));

                TOTAL += Math.abs(queue.get(i).getBlock() - arg.getBlock());
                queue.get(i).setDone(true);
                next = queue.indexOf(arg);


            }

            i=next;

        }

        Restart();
        return TOTAL;
    }

    public int SSTF(){

        int TOTAL = 0;
        Unit NEXT,current;
        current = queue.get(0);

        while(!AllDone(queue)){

            NEXT = NextShortestSeek(current);

            TOTAL += Math.abs(current.getBlock() - NEXT.getBlock());
            current.setDone(true);
            current = NEXT;

            LOTTERY = rand.nextInt(CHANCE);

            if(LOTTERY == 1){

                NEXT = NextShortestDeadline(current);

                TOTAL += Math.abs(current.getBlock() - NEXT.getBlock());
                current.setDone(true);

            }

        }

        Restart();
        return TOTAL;

    }

    public int SCAN() {

        int TOTAL = 0,i,j=0;
        Unit NEXT,current,LAST;
        current = queue.get(0);
        flag = true;

        ArrayList<Unit> SCANqueue = new ArrayList<>(queue);

        Collections.sort(SCANqueue);

        i = SCANqueue.indexOf(current);

        LAST = SCANqueue.get(i);

        if(current.getBlock() < Main.MAX_BLOCKS/2){
            flag = false;
            LAST = SCANqueue.get(i+2);
            i++;
        }

        if(current.getBlock() >= Main.MAX_BLOCKS/2){
            flag = true;
            LAST = SCANqueue.get(i-2);
            i--;
        }

        LAST.setDone(true);
        current = SCANqueue.get(i);


        while(!AllDone(SCANqueue)){


            while(SCANqueue.get(i).isDone()){

                if(i == 0){
                    flag = true;
                }

                if(i == SCANqueue.size()-1){
                    flag = false;
                }

                if(flag){
                    i++;
                }

                if(!flag){
                    i--;
                }
            }

            TOTAL += Math.abs(current.getBlock() - LAST.getBlock());
            current.setDone(true);
            LAST = current;

            current = SCANqueue.get(i);

            LOTTERY = rand.nextInt(CHANCE);

            if(LOTTERY == 1){
                current = NextShortestDeadline(LAST);

                i = SCANqueue.indexOf(current);
            }
        }

        Restart();
        return TOTAL;
    }


    public int CSCAN() {

        int TOTAL = 0,i,j=0;
        Unit NEXT,current,LAST;
        current = queue.get(0);
        flag = true;

        ArrayList<Unit> CSCANqueue = new ArrayList<>(queue);

        Collections.sort(CSCANqueue);

        i = CSCANqueue.indexOf(current);

        LAST = CSCANqueue.get(i);

        if(current.getBlock() < Main.MAX_BLOCKS/2){
            flag = false;
            LAST = CSCANqueue.get(i+2);
            i++;
        }

        if(current.getBlock() >= Main.MAX_BLOCKS/2){
            flag = true;
            LAST = CSCANqueue.get(i-2);
            i--;
        }

        LAST.setDone(true);
        current = CSCANqueue.get(i);


        while(!AllDone(CSCANqueue)){

            while(CSCANqueue.get(i).isDone()){

                if(flag){
                    i++;
                    if(i == CSCANqueue.size()) {
                        i = 0;
                    }
                }

                if(!flag){
                    i--;
                    if(i < 0){
                        i = CSCANqueue.size()-1;
                    }
                }
            }

            TOTAL += Math.abs(current.getBlock() - LAST.getBlock());
            current.setDone(true);
            LAST = current;

            current = CSCANqueue.get(i);

            LOTTERY = rand.nextInt(CHANCE);

            if(LOTTERY == 1){

                current = NextShortestDeadline(LAST);

                i = CSCANqueue.indexOf(current);

            }
        }

        Restart();
        return TOTAL;
    }





    public Unit NextShortestSeek(Unit current){

        int MIN_PATH = Main.MAX_BLOCKS;
        Unit NEXT_BLOCK = current;

        for(int i = 0; i < queue.size(); i++){

            if((Math.abs(current.getBlock() - queue.get(i).getBlock()) < MIN_PATH) && (!queue.get(i).isDone()) && (current != queue.get(i))){
                MIN_PATH = Math.abs(current.getBlock() - queue.get(i).getBlock());
                NEXT_BLOCK = queue.get(i);
            }

        }

        return NEXT_BLOCK;
    }


    public Unit NextShortestDeadline(Unit current){

        int MIN_DEADLINE = Main.MAX_DEADLINE;
        Unit NEXT_BLOCK = current;

        for(int i = 0; i < queue.size(); i++){

            if((Math.abs(current.getDeadline() - queue.get(i).getDeadline()) < MIN_DEADLINE) && (!queue.get(i).isDone()) && (current != queue.get(i))){
                MIN_DEADLINE = Math.abs(current.getDeadline() - queue.get(i).getDeadline());
                NEXT_BLOCK = queue.get(i);
            }

        }

        return NEXT_BLOCK;
    }


    public boolean AllDone(List<Unit> queue){

        for(int i=0; i < queue.size(); i++){
            if(!queue.get(i).isDone())
                return false;
        }
        return true;

    }


    /** RESTORING UNITS TO PREVIOUS SHAPE */
    public void Restart(){
        for(int i = 0; i < queue.size(); i++){
            queue.get(i).setDone(false);
        }
    }


    @Override
    public void run() {

    }
}
