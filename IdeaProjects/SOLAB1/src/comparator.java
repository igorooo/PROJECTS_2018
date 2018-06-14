import java.util.Comparator;

public class comparator implements Comparator<Proces>{


    @Override
    public int compare(Proces o1, Proces o2) {

        if(o1.getFazaProc()<o2.getFazaProc()){
            return 1;
        }

        if(o1.getFazaProc()>o2.getFazaProc()){
            return -1;
        }

        if(o1.getFazaProc() == o2.getFazaProc()){

            if(o1.getId() < o2.getId()){
                return 1;
            }

            else{
                return -1;
            }
        }

        return 0;
    }
}
