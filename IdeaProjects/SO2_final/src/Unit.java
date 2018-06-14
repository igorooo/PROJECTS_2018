public class Unit implements Comparable<Unit> {

    private int BLOCK;
    private boolean done;
    private int DEADLINE;

    public Unit(int BLOCK,int DEADLINE){

        this.BLOCK = BLOCK;
        done = false;
        this.DEADLINE = DEADLINE;

    }

    public int getDeadline(){
        return DEADLINE;
    }

    public int getBlock(){
        return BLOCK;
    }

    public boolean isDone(){
        return done;
    }

    public void setDone(boolean t){
        done = t;
    }

    @Override
    public int compareTo(Unit unit) {
        return this.BLOCK - unit.BLOCK;
    }
}
