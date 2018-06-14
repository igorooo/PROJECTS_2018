public interface IList<E> {

    void insert(int index,E value) throws IndexOutOfBoundsException;
    E delete(int index) throws IndexOutOfBoundsException;
    E get(int index) throws IndexOutOfBoundsException;
    int size();
    void clear();
    void wyswietlListe();
    boolean delete(E value);
    void set(int index, E value) throws IndexOutOfBoundsException;
    int indexOf(E value);
    boolean contains(E value);
}

