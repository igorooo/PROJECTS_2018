import java.util.ArrayList;
import java.util.Collections;
import java.util.concurrent.CopyOnWriteArrayList;

public class Main implements Runnable{




    public static void main(String args[]) throws InterruptedException {

        int AMOUNT = 500;
        int MAX_PHASE_LENGTH = 50;
        int MAX_APPEAR_TIME = 2500;
        int TIME_QUANT = 15;


        ArrayList<Proces> array = new ArrayList<Proces>();

        CopyOnWriteArrayList<Proces> queueFCFS = new CopyOnWriteArrayList<Proces>();
        CopyOnWriteArrayList<Proces> queueSJF = new CopyOnWriteArrayList<Proces>();
        CopyOnWriteArrayList<Proces> queueSJFW = new CopyOnWriteArrayList<Proces>();
        CopyOnWriteArrayList<Proces> queueRR = new CopyOnWriteArrayList<Proces>();

        Generator gen = new Generator(array,MAX_PHASE_LENGTH,MAX_APPEAR_TIME,AMOUNT);



        /** CREATING TIME OBJECT, CPU AND RTQUEUE **/

        Time TIME = new Time();
        CPU CLOCK = new CPU(TIME);
        RealTimeAppearQueue RTQUEUE = new RealTimeAppearQueue(array,queueFCFS,queueSJF,queueSJFW,queueRR,TIME,AMOUNT);

        /** OBJECTS WITH RESULTS **/

        Result FCFS_RESULT = new Result(AMOUNT);
        Result SJF_RESULT = new Result(AMOUNT);
        Result SJFW_RESULT = new Result(AMOUNT);
        Result RR_RESULT = new Result(AMOUNT);

        /**OBJECTS WITH ALGORITHMS**/


        FCFS fcfs = new FCFS(queueFCFS,TIME,AMOUNT,FCFS_RESULT);
        SJF sjf = new SJF(queueSJF,TIME,AMOUNT,SJF_RESULT);
        SJFW sjfw = new SJFW(queueSJFW,TIME,AMOUNT,SJFW_RESULT);
        RR rr = new RR(queueRR,TIME,AMOUNT,RR_RESULT,TIME_QUANT);

        /**THREADS*/

        Thread CLOCKthr = new Thread(CLOCK);
        Thread RTQthr = new Thread(RTQUEUE);

        Thread FCFSthr = new Thread(fcfs);
        Thread SJFthr = new Thread(sjf);
        Thread SJFWthr = new Thread(sjfw);
        Thread RRthr = new Thread(rr);



        CLOCKthr.start();
        RTQthr.start();

        synchronized (System.out){

            FCFSthr.start();
            SJFthr.start();
            SJFWthr.start();
            RRthr.start();


        }


        while(FCFSthr.isAlive() || SJFthr.isAlive() || SJFWthr.isAlive() || RRthr.isAlive()){

            Thread.sleep(100);

        }

        CLOCK.STOP();


        System.out.println("-----All threads have finished------");



    }

    @Override
    public void run() {

    }
}
