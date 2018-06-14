import java.util.ArrayList;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.concurrent.CopyOnWriteArrayList;

public class FCFS implements Runnable {

    CopyOnWriteArrayList<Proces> queue;
    Iterator<Proces> iter;
    Time time;
    int AMOUNT;
    Proces current;
    Result FCFS_RESULT;
    int DELAY;
    int i;


    public FCFS(CopyOnWriteArrayList<Proces> queue, Time time, int AMOUNT, Result FCFS_RESULT){

        this.queue = queue;
        this.time = time;
        iter = queue.iterator();
        this.AMOUNT = AMOUNT;
        this.FCFS_RESULT = FCFS_RESULT;

    }


    @Override
    public void run() {

        DELAY = time.WhatTime();

        while (AMOUNT > 0){


            while(queue.size() == 0){

                try {
                    Thread.sleep(Time.TIME_UNIT);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            current = queue.get(0);
            AMOUNT--;

            FCFS_RESULT.ADD(time.WhatTime()-current.AppearTime());


            while (!current.IsDone()){

                current.Do();

                try {
                    Thread.sleep(Time.TIME_UNIT);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
            queue.remove(current);

        }

        System.out.print("FCFS finished, Result: ");
        System.out.println(FCFS_RESULT);

    }
}
