import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

public class RealTimeAppearQueue implements Runnable {


    ArrayList<Proces> array;
    CopyOnWriteArrayList<Proces> queueFCFS;
    CopyOnWriteArrayList<Proces> queueSJF;
    CopyOnWriteArrayList<Proces> queueSJFW;
    CopyOnWriteArrayList<Proces> queueRR;

    Iterator<Proces> iter;
    int AMOUNT;

    Proces current;

    Time time;

    public RealTimeAppearQueue(ArrayList<Proces> args,CopyOnWriteArrayList<Proces> queueFCFS,CopyOnWriteArrayList<Proces> queueSJF,CopyOnWriteArrayList<Proces> queueSJFW,CopyOnWriteArrayList<Proces> queueRR, Time time,int AMOUNT){

        array = args;
        this.queueFCFS = queueFCFS;
        this.queueSJF = queueSJF;
        this.queueSJFW = queueSJFW;
        this.queueRR = queueRR;

        this.time = time;
        Proces.SORT_BY = true;
        Collections.sort(array);
        iter = array.iterator();
        AMOUNT = AMOUNT-1;
        current = iter.next();



    }

    @Override
    public void run() {



        while(true){

            if(current.Appear(time)){
                queueFCFS.add(new Proces(current));
                queueSJF.add(new Proces(current));
                queueSJFW.add(new Proces(current));
                queueRR.add(new Proces(current));

                try{
                    current = iter.next();
                }
                catch (NoSuchElementException e){
                    break;
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
