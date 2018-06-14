import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

public class RR implements Runnable {

    CopyOnWriteArrayList<Proces> queue;
    Iterator<Proces> iter;
    Time time;
    int AMOUNT;
    Proces current;
    Result RR_RESULT;
    int DELAY;
    int TIME_QUANT;
    int TQUANT;

    public RR(CopyOnWriteArrayList<Proces> queue, Time time, int AMOUNT, Result RR_RESULT,int TIME_QUANT){

        this.queue = queue;
        this.time = time;
        iter = queue.iterator();
        this.AMOUNT = AMOUNT;
        this.RR_RESULT = RR_RESULT;
        this.TIME_QUANT = TIME_QUANT;

    }



    @Override
    public void run() {

        DELAY = time.WhatTime();
        boolean flag = false;

        while (AMOUNT > 0){

            //System.out.println("run");

            while(queue.size() == 0){
                //System.out.println("waiting...");

                try {
                    Thread.sleep(Time.TIME_UNIT);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }

            current = queue.get(0);

            if(current.ShowLastPhaseEnd() == 0){
                current.UpW8Time(time.WhatTime() - current.AppearTime());
            }

            if(current.ShowLastPhaseEnd() > 0){
                current.UpW8Time(time.WhatTime() - current.ShowLastPhaseEnd());
            }


            /*
            TQUANT = TIME_QUANT;

            while (!current.IsDone()){

                if(TQUANT == 0){

                    current.UpdateLastPhaseEnd(time.WhatTime());

                    queue.remove(current);
                    queue.add(current);

                    current = queue.get(0);

                    if(current.ShowLastPhaseEnd() == 0){
                        current.UpW8Time(time.WhatTime() - current.AppearTime());
                    }

                    if(current.ShowLastPhaseEnd() > 0){
                        current.UpW8Time(time.WhatTime() - current.ShowLastPhaseEnd());
                    }

                    TQUANT = TIME_QUANT;

                }


                current.Do();
                TQUANT--;


                try {
                    Thread.sleep(Time.TIME_UNIT);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            } */

            flag = false;

            for(int i = 0;i < TIME_QUANT; i++){

                current.Do();

                try {
                    Thread.sleep(Time.TIME_UNIT);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                if(current.IsDone()){
                    RR_RESULT.ADD(current.ShowW8Time());
                    queue.remove(current);
                    AMOUNT--;
                    flag = true;
                    break;
                }

            }

            if(flag == false){
                current.UpdateLastPhaseEnd(time.WhatTime());

                queue.remove(current);
                queue.add(current);

            }


        }

        System.out.print("RR finished, Result: ");
        System.out.println(RR_RESULT);



    }
}
