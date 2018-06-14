import java.util.ArrayList;

public class CPU implements Runnable {

    Time time;

    public CPU(Time time){

        this.time = time;

    }


    @Override
    public void run() {
        while(true){
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
