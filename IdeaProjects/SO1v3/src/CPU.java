import java.util.ArrayList;

public class CPU implements Runnable {

    Time time;
    private boolean START = true;

    public CPU(Time time){

        this.time = time;

    }

    public void STOP(){
        START = false;
    }

    @Override
    public void run() {
        while(START){
            time.TimeRun();
            //System.out.println(time.WhatTime());
            try {
                Thread.sleep(Time.TIME_UNIT);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }

    }
}
