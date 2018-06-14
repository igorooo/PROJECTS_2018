
public class LinkedList implements List {

    private final Element head = new Element(null);
    private int size = 0;

    public LinkedList()
    { clear();}


    @Override
    public void insert(int index, Object value) throws IndexOutOfBoundsException {
        if(index < 0 || index > size) throw new IndexOutOfBoundsException();
        Element element = new Element(value);

        element.setNext(getElement(index));

        Element previous = getElement(index-1);

        previous.setNext(element);

        ++size;
    }

    private Element getElement(int index){
        Element find = head.getNext();
        for(int i=0; i < index; i++) {
            find = find.getNext();
        }
        return find;
    }

    @Override
    public Object delete(int index) throws IndexOutOfBoundsException {

        if (index < 0 || index >= size) throw new IndexOutOfBoundsException();
        Element element = getElement(index);
        Element previous = getElement(index-1);

        previous.setNext(element.getNext());
        --size;
        return element.getValue();
    }

    @Override
    public Object get(int index) throws IndexOutOfBoundsException {
        if(index<0 || index > size) throw new IndexOutOfBoundsException();
        return getElement(index).getValue();

    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void clear() {
        head.setNext(head);
        size = 0;
    }

    @Override
    public void wyswietlListe(){
        for(int i=0; i<size(); i++){
            System.out.println(getElement(i).getValue());
        }
    }

    @Override
    public void add(Object value) {
        insert(size, value);
    }

    @Override
    public boolean delete(Object value) {
        if(head.getNext() == null) return false;
        if(head.getNext().getValue().equals(value)){
            head.setNext(head.getNext().getNext());
            size--;
            return true;
        }

        Element delete = head.getNext();
        while(delete != null && delete.getNext() != null){
            if(delete.getNext().getValue().equals(value)){
                delete.setNext(delete.getNext().getNext());
                size--;
                return true;
            }
            delete = delete.getNext();
        }
        return false;
    }

    @Override
    public Object set(int index, Object value) throws IndexOutOfBoundsException {
        if(index<0 || index>size) throw new IndexOutOfBoundsException();
        getElement(index).setValue(value);
        return value;
    }

    @Override
    public int indexOf(Object value) {
        int index = 0;
        Element e = head.getNext();
        while( e != head && ! value.equals(e.getValue()))
        { e = e.getNext(); ++index; }
        return e!=head ? index : -1;

    }

    @Override
    public boolean contains(Object value) {
        return indexOf(value) != -1;
    }

    public Iterator iterator(){
        return new ValueIterator();
    }




    private static class Element{
        Object value;
        Element next;

        public Element(Object value){
            this.value = value;
        }

        public void setValue(Object value) {
            this.value = value;
        }

        public Object getValue() {
            return value;
        }

        public void setNext(Element next){
            this.next = next;
        }

        public Element getNext() {
            return next;
        }
    }

    private final class ValueIterator implements Iterator {
        private Element current = head;
        public void first(){
            current = head.getNext();
        }
        public void last(){
            current = getElement(size);
        }
        public boolean isDone(){
            return current == head;
        }
        public void next(){
            current = current.getNext();
        }
        public Object current() throws IndexOutOfBoundsException {
            if (isDone())
                throw new IndexOutOfBoundsException();
            return current.getValue();
        }
    }

}
