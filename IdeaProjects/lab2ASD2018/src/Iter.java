import java.util.Iterator;
import java.util.NoSuchElementException;

public class Iter<T> implements Iterator<T> {
    private T array[];
    private int pos = 0;

    public Iter(T anArray[]) {
        array = anArray;
    }
    public boolean hasNext() {
        return pos < array.length;
    }
    public T next() throws NoSuchElementException {
        if (hasNext())
            return array[pos++];
        else
            throw new NoSuchElementException();
    }

    public int currentPos(){
        return pos;
    }

    public void remove() {
        throw new UnsupportedOperationException();
    }
}