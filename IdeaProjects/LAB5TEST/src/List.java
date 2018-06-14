public interface List {
    void insert(int index, Object value) throws IndexOutOfBoundsException;
    Object delete(int index) throws IndexOutOfBoundsException;
    Object get(int index) throws IndexOutOfBoundsException;
    int size();
    void clear();

    void wyswietlListe();

    void add(Object value);
    boolean delete(Object value);
    Object set(int index, Object value) throws IndexOutOfBoundsException;
    int indexOf(Object value);
    boolean contains(Object value);
}
