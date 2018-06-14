import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class CompoundComparator<T> implements Comparator<T> {


    private final List<Object> comparators = new ArrayList<Object>();

    public void addComparator(Comparator<T> comparator){

        comparators.add(comparator);
    }


    @Override
    public int compare(T t1, T t2) throws ClassCastException {

        int result = 0;

        for(Object obj: comparators){
            Comparator<T> comp = (Comparator<T>)obj;
            result = comp.compare(t1,t2);

            if(result != 0){
                return result;
            }
        }
        return result;
    }
}
