public class Page implements Comparable<Page> {

    boolean correct;
    int id;
    int LAST_USE;
    int dist;

    public Page(int id){
        this.correct = false;
        this.id = id;
        LAST_USE = 0;
        dist = 0;

    }

    public void changeBit(){
        correct = !correct;
    }

    public void setTime(int time){
        LAST_USE = time;
    }


    @Override
    public int compareTo(Page o) {
        return LAST_USE - o.LAST_USE;
    }
}
