import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

public class RealTimeAppearQueue implements Runnable {


    ArrayList<Proces> array;
    CopyOnWriteArrayList<Proces> queue = new CopyOnWriteArrayList<Proces>();

    Iterator<Proces> iter;
    int AMOUNT;

    Proces current;

    Time time;

    public RealTimeAppearQueue(ArrayList<Proces> args,CopyOnWriteArrayList<Proces> queue, Time time,int AMOUNT){

        array = args;
        this.queue = queue;

        this.time = time;
        Proces.SORT_BY = true;
        Collections.sort(array);
        iter = array.iterator();
        AMOUNT = AMOUNT-1;
        current = iter.next();


        /*for(Proces proces:  array){

            System.out.println(proces);

        }

        System.out.println("---------"); */

    }

    @Override
    public void run() {



        while(true){



            if(current.Appear(time)){
                queue.add(new Proces(current));

                //System.out.println("Current--> "+current);

                try{
                    current = iter.next();
                }
                catch (NoSuchElementException e){
                    try {
                        Thread.sleep(1000000);
                    } catch (InterruptedException e1) {
                        e1.printStackTrace();
                    }
                }

            }

            try {
                Thread.sleep(Time.TIME_UNIT/2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }

    }

}
