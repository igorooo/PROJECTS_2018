public class Comp {

    int comp;
    String found;

    public Comp(){
        comp = 0;
    }

    public void next(){
        comp++;
    }

    public void restart(){
        comp = 0;
    }

    public void showUp(){
        System.out.println(comp);
    }

    public void setFound(boolean b){
        if(b){
            found = "found";
        }
        else{
            found = "not found";
        }
    }

    public String FOUND(){
        return found;
    }

    @Override
    public String toString() {
        return "We have "+found+" object with "+Integer.toString(comp)+" compares";
    }
}
