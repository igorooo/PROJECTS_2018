import java.util.Iterator;


public final class Filtrit<T> implements Iterator<T>{

    private Iterator<T> iterator;
    private Predicate<T> predicate;

    private T elemNext=null;
    private boolean bHasNext=true;

    public Filtrit(Iterator<T> iterator, Predicate<T> predicate) {
        super();
        this.iterator = iterator; // nie może być null
        this.predicate = predicate; //nie może być null
        findNextValid();
    }

    private void findNextValid() {
        while (iterator.hasNext()) {
            elemNext = iterator.next();

            if(elemNext!=null){
                if (predicate.accept(elemNext)) {
                    return;
                }
            }

        }
        bHasNext=false;
        elemNext=null;
    }

    @Override
    public boolean hasNext() {
        return bHasNext;
    }

    @Override
    public T next() {
        T nextValue = elemNext;
        findNextValid();
        return nextValue;
    }
}
