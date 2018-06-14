import java.util.ArrayList;

public class IQueue {

    ArrayList<Proces> queue = new ArrayList<Proces>();

    public void addProces(Proces arg){
        queue.add(arg);
    }

    public void removeProces(int index){
        queue.remove(index);
    }

    public Proces getProces(int index){
        return queue.get(index);
    }

    public int size(){
        return queue.size();
    }



}
