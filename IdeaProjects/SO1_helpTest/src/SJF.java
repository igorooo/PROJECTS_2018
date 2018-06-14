import java.util.Collections;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

public class SJF implements Runnable {

    CopyOnWriteArrayList<Proces> queue;
    Iterator<Proces> iter;
    Time time;
    int AMOUNT;
    Proces current;
    Result SJF_RESULT;
    int DELAY;


    public SJF(CopyOnWriteArrayList<Proces> queue, Time time, int AMOUNT, Result SJF_RESULT){

        this.queue = queue;
        this.time = time;
        iter = queue.iterator();
        this.AMOUNT = AMOUNT;
        this.SJF_RESULT = SJF_RESULT;

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

            Proces.SORT_BY = false;
            Collections.sort(queue);

            current = queue.get(0);
            AMOUNT--;

            SJF_RESULT.ADD(time.WhatTime()-current.AppearTime());


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

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.print("SJF finished, Result: ");
        System.out.println(SJF_RESULT);


    }
}
