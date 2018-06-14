public class Stat {

    int l;

    public Stat(){
        this.l = 0;
    }

    public void up(){
        l++;
    }

    public void show(){
        System.out.println(l);
    }

    public void restart(){ l = 0; }

    public int get(){
        return l;
    }

}
