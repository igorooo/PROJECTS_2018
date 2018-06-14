import java.util.ArrayList;
import java.util.Collections;
import java.util.concurrent.CopyOnWriteArrayList;

public class Main implements Runnable{



    public static void main(String args[]) throws InterruptedException {

        int AMOUNT = 5;
        int MAX_PHASE_LENGTH = 10;
        int MAX_APPEAR_TIME = 1;
        int TIME_QUANT = 1;

        Thread thr[] = new Thread[16];

        ArrayList<Proces> array = new ArrayList<Proces>();

        CopyOnWriteArrayList<Proces> queueFCFS = new CopyOnWriteArrayList<Proces>();
        CopyOnWriteArrayList<Proces> queueSJF = new CopyOnWriteArrayList<Proces>();
        CopyOnWriteArrayList<Proces> queueSJFW = new CopyOnWriteArrayList<Proces>();
        CopyOnWriteArrayList<Proces> queueRR = new CopyOnWriteArrayList<Proces>();




        array.add(new Proces(8,0,1));
        array.add(new Proces(8,1,1));
        array.add(new Proces(4,2,1));
        array.add(new Proces(1,3,1));
        array.add(new Proces(8,4,1));



        for(Proces proces:  array){

            System.out.println(proces);

        }

        System.out.println("---------");


        /** FCFS **/

        Time FCFS_TIME = new Time();
        CPU FCFS_CLOCK = new CPU(FCFS_TIME);
        Result FCFS_RESULT = new Result(AMOUNT);
        RealTimeAppearQueue FCFS_RTQUEUE = new RealTimeAppearQueue(array,queueFCFS,FCFS_TIME,AMOUNT);
        FCFS fcfs = new FCFS(queueFCFS,FCFS_TIME,AMOUNT,FCFS_RESULT);

        thr[0] = new Thread(FCFS_CLOCK);
        thr[1] = new Thread(FCFS_RTQUEUE);
        thr[2] = new Thread(fcfs);

        thr[0].start();
        thr[1].start();
        thr[2].start();

        while(thr[2].isAlive()){

            Thread.sleep(100);

        }

        thr[0].stop();
        thr[1].stop();
        thr[2].stop();
        System.out.println("stopped");








        /** SJF **/

        Time SJF_TIME = new Time();
        CPU SJF_CLOCK = new CPU(SJF_TIME);
        Result SJF_RESULT = new Result(AMOUNT);
        RealTimeAppearQueue SJF_RTQUEUE = new RealTimeAppearQueue(array,queueSJF,SJF_TIME,AMOUNT);
        SJF sjf = new SJF(queueSJF,SJF_TIME,AMOUNT,SJF_RESULT);

        thr[3] = new Thread(SJF_CLOCK);
        thr[4] = new Thread(SJF_RTQUEUE);
        thr[5] = new Thread(sjf);

        thr[3].start();
        thr[4].start();
        thr[5].start();

        while(thr[5].isAlive()){

            Thread.sleep(100);

        }

        thr[3].stop();
        thr[4].stop();
        thr[5].stop();
        System.out.println("stopped");


        /** SJFW **/

        Time SJFW_TIME = new Time();
        CPU SJFW_CLOCK = new CPU(SJFW_TIME);
        Result SJFW_RESULT = new Result(AMOUNT);
        RealTimeAppearQueue SJFW_RTQUEUE = new RealTimeAppearQueue(array,queueSJFW,SJFW_TIME,AMOUNT);
        SJFW sjfw = new SJFW(queueSJFW,SJFW_TIME,AMOUNT,SJFW_RESULT);

        thr[6] = new Thread(SJFW_CLOCK);
        thr[7] = new Thread(SJFW_RTQUEUE);
        thr[8] = new Thread(sjfw);


        thr[6].start();
        thr[7].start();
        thr[8].start();

        while(thr[8].isAlive()){

            Thread.sleep(100);

        }

        thr[6].stop();
        thr[7].stop();
        thr[8].stop();
        System.out.println("stopped");



        /** RR **/


        Time RR_TIME = new Time();
        CPU RR_CLOCK = new CPU(RR_TIME);
        //Generator gen = new Generator(array,MAX_PHASE_LENGTH,MAX_APPEAR_TIME,AMOUNT);
        Result RR_RESULT = new Result(AMOUNT);
        RealTimeAppearQueue RR_RTQUEUE = new RealTimeAppearQueue(array,queueRR,RR_TIME,AMOUNT);
        RR rr = new RR(queueRR,RR_TIME,AMOUNT,RR_RESULT,TIME_QUANT);

        thr[9] = new Thread(RR_CLOCK);
        thr[10] = new Thread(RR_RTQUEUE);
        thr[11] = new Thread(rr);


        thr[9].start();
        thr[10].start();
        thr[11].start();

        while(thr[11].isAlive()){

            Thread.sleep(100);

        }

        thr[9].stop();
        thr[10].stop();
        thr[11].stop();
        System.out.println("stopped");



    }

    @Override
    public void run() {

    }
}
