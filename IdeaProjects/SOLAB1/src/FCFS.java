

public class FCFS {

    IQueue queue;

    private int avarageTime;

    public FCFS(IQueue queue){

        this.queue = queue;
        avarageTime = 0;
        int i;

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
