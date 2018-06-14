public class Time {

    private int t;

    public static int TIME_UNIT = 1;

    public Time(){
        t = 0;
    }

    public void TimeRun(){
        t++;
    }

    public int WhatTime(){
        return t;
    }

}
