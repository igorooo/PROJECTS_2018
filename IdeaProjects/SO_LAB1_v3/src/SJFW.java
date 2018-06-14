import java.util.Collections;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

public class SJFW implements Runnable{


    CopyOnWriteArrayList<Proces> queue;
    Iterator<Proces> iter;
    Time time;
    int AMOUNT;
    Proces current;
    Result SJFW_RESULT;
    int DELAY;



    public SJFW(CopyOnWriteArrayList<Proces> queue, Time time, int AMOUNT, Result SJFW_RESULT){

        this.queue = queue;
        this.time = time;
        iter = queue.iterator();
        this.AMOUNT = AMOUNT;
        this.SJFW_RESULT = SJFW_RESULT;

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

            if(current.ShowLastPhaseEnd() == 0){
                current.UpW8Time(time.WhatTime() - current.AppearTime());
            }

            if(current.ShowLastPhaseEnd() > 0){
                current.UpW8Time(time.WhatTime() - current.ShowLastPhaseEnd());
            }

            while (!current.IsDone()){

                current.Do();

                Proces.SORT_BY = false;
                Collections.sort(queue);

                if(current != queue.get(0)){
                    current.UpdateLastPhaseEnd(time.WhatTime());
                    current = queue.get(0);

                    if(current.ShowLastPhaseEnd() == 0){
                        current.UpW8Time(time.WhatTime() - current.AppearTime());
                    }

                    if(current.ShowLastPhaseEnd() > 0){
                        current.UpW8Time(time.WhatTime() - current.ShowLastPhaseEnd());
                    }
                }

                try {
                    Thread.sleep(Time.TIME_UNIT);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            SJFW_RESULT.ADD(current.ShowW8Time());
            queue.remove(current);
            AMOUNT--;
        }

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.print("SJFW finished, Result: ");
        System.out.println(SJFW_RESULT);

    }
}
