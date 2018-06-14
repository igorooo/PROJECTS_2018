public class Proces implements Comparable<Proces> {

    private int PHASE_LENGTH;
    private int ID;
    private int TIME_DONE;
    private int APPEAR_TIME;  // time unit is 1 CPU clock
    private int WAIT_TIME;
    private int LAST_PHASE_END;

    public static boolean SORT_BY = true;  //false - then sort by PHASE LENGTH, true - then sort by APPEAR TIME

    public Proces(int PHASE_LENGTH,int ID, int APPEAR_TIME){
        this.PHASE_LENGTH = PHASE_LENGTH;
        this.ID = ID;
        this.TIME_DONE = 0;
        this.APPEAR_TIME = APPEAR_TIME;
        WAIT_TIME = 0;
        LAST_PHASE_END = 0;

    }

    public Proces(Proces proces){
        this.PHASE_LENGTH = proces.PHASE_LENGTH;
        this.ID = proces.ID;
        this.APPEAR_TIME = proces.APPEAR_TIME;
        WAIT_TIME = 0;
        LAST_PHASE_END = 0;

    }

    public boolean IsDone(){
        return (PHASE_LENGTH <= 0);
    }

    public void Do(){
        PHASE_LENGTH--;
    }

    public void UpW8Time(int t){
        WAIT_TIME += t;
    }

    public int ShowW8Time(){
        return WAIT_TIME;
    }

    public void UpdateLastPhaseEnd(int t){
        LAST_PHASE_END = t;
    }

    public int ShowLastPhaseEnd(){
        return LAST_PHASE_END;
    }


    public boolean Appear(Time time){

        if(time.WhatTime() >= APPEAR_TIME)
            return true;

        return false;
    }

    public int AppearTime(){
        return APPEAR_TIME;
    }


    public String toString(){

        String a = (Integer.toString(ID) + " " + Integer.toString(PHASE_LENGTH) + " " + Integer.toString(APPEAR_TIME));
        return a;
    }


    @Override
    public int compareTo(Proces proces) {
        int comp;

        if(SORT_BY){
            comp = APPEAR_TIME - proces.APPEAR_TIME;
        }

        else{
            comp = PHASE_LENGTH - proces.PHASE_LENGTH;
        }

        return comp;
    }

}
