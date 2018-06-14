import java.util.ArrayList;

public class CLOCK implements Runnable {

    Time time;
    private boolean START = true;

    public CLOCK(Time time){

        this.time = time;

    }

    public void STOP(){
        START = false;
    }

    @Override
    public void run() {
        while(START){
            time.TimeRun();
            try {
                Thread.sleep(Time.TIME_UNIT);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }

    }
}
