

public class Proces {

    private int fazaProc;
    private int id;
    private int delay;
    private int timeDone;

    public Proces(int fazaProc, int id, int appearTime){

        this.fazaProc = fazaProc;
        this.id = id;
        this.delay = appearTime;
        timeDone = 0;

    }

    public int getFazaProc(){
        return fazaProc;
    }

    public int getTimeLeft(){

        if(fazaProc - timeDone >= 0){
            return fazaProc - timeDone;
        }

        else
            return 0;

    }

    public int getId(){
        return id;
    }

    public int getDelay(){
        return delay;
    }

    public int getTimeDone(){
        return timeDone;
    }

    public void setTimeDone(int timeDone){
        this.timeDone += timeDone;
    }

    public boolean isDone(){
        return timeDone >= fazaProc;
    }


}
