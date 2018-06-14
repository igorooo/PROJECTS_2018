import java.util.Collections;

public class SJF {

    IQueue queue;

    private int avarageTime;

    public SJF(IQueue queue){

        this.queue = queue;

        avarageTime = 0;

        int i;

        Collections.sort(queue.queue, new comparator());

        for(i = 0; i < queue.size()-1; i++){

            avarageTime += queue.getProces(i).getFazaProc() - queue.getProces(i+1).getDelay();

        }

        avarageTime += queue.getProces(i).getFazaProc();

        avarageTime /= queue.size()-1;

    }

    public int getAvarageTime(){
        return avarageTime;
    }
}
