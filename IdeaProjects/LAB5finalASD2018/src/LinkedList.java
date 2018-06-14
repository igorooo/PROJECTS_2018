import java.util.Iterator;

public class LinkedList<E> implements IList<E> {


    private class Element {

        private E value;
        private Element next;

        public Element(E value){
            this.value = value;
        }

        public E getValue() {
            return value;
        }

        public void setValue(E value) {
            this.value = value;
        }

        public Element getNext() {
            return next;
        }

        public void setNext(Element next) {
            this.next = next;
        }
    }

    private Element head = null;

    public LinkedList(){
    }

    @Override
    public void insert(int index, E value) throws IndexOutOfBoundsException {

        if(index < 0 || index > size()) throw new IndexOutOfBoundsException();

        Element newElem = new Element(value);
        Element actElem = head;
        Element previous = head;
        int i = index;

        if(head == null){
            head = newElem;
            return;
        }

        if(index == 0){

            newElem.setNext(head);
            head = newElem;
            return;
        }

        while(i > 0){
            i--;
            actElem = actElem.getNext();
        }

        newElem.setNext(actElem);

        for(int j=0; j < index-1; j++){
            previous = previous.getNext();
        }

        previous.setNext(newElem);


    }

    @Override
    public E delete(int index) throws IndexOutOfBoundsException {

        Element actElem = head;
        Element helpElem;
        int i = index;

        if(index == 0){
            head = head.getNext();
            return actElem.getValue();
        }

        if(index >= size() || index < 0){
            throw new IndexOutOfBoundsException();
        }

        while(i > 1){
            i--;
            actElem = actElem.getNext();
        }

        helpElem = actElem.getNext().getNext();
        actElem.setNext(helpElem);

        return helpElem.getValue();
    }

    @Override
    public E get(int index) throws IndexOutOfBoundsException {

        Element actElem = head;
        int i = index;

        if(index == 0){
            return head.getValue();
        }

        if(index >= size() || index < 0){
            throw new IndexOutOfBoundsException();
        }

        while(i > 0){
            i--;
            actElem = actElem.getNext();
        }

        return actElem.getValue();
    }

    @Override
    public int size() {

        int pos = 0;
        Element actElem = head;

        while(actElem != null){
            pos++;
            actElem = actElem.getNext();
        }

        return pos;
    }

    @Override
    public void clear() {
        head = null;
    }

    @Override
    public void wyswietlListe() {

        if(head == null){
            System.out.println("Lista pusta");
            return;
        }

        Element actElem = head;

        while(actElem != null){

            System.out.println(actElem.getValue());
            actElem = actElem.getNext();

        }
    }

    public void PrintWithIter(){

        ITERATOR iter = new ITERATOR();

        while(iter.hasNext()){
            System.out.println(iter.next());
        }

    }




    @Override
    public boolean delete(E value) {

        Element actElem;
        int index = indexOf(value);

        if(index == -1){
            return false;
        }

        actElem = head;
        Element helpElem;
        int i = index;

        if(index == 0){
            head = head.getNext();
            return true;
        }

        if(index >= size() || index < 0){
            throw new IndexOutOfBoundsException();
        }

        while(i > 1){
            i--;
            actElem = actElem.getNext();
        }

        helpElem = actElem.getNext().getNext();
        actElem.setNext(helpElem);

        return true;

    }

    @Override
    public void set(int index, E value) throws IndexOutOfBoundsException {

        Element actElem = head;
        int i = index;

        if(index == 0){
            head.setValue(value);
        }

        if(index >= size() || index < 0){
            throw new IndexOutOfBoundsException();
        }

        while(i > 0){
            i--;
            actElem = actElem.getNext();
        }

        actElem.setValue(value);
    }

    @Override
    public int indexOf(E value) {

        Element actElem = head;
        int i=0;

        while(actElem.getValue() != value){
            if(actElem == null){
                return -1;
            }
            actElem = actElem.getNext();
            i++;
        }

        return i;
    }

    @Override
    public boolean contains(E value) {

        Element actElem = head;

        while(actElem != null){

            if(actElem.getValue() == value){
                return true;
            }

            actElem = actElem.getNext();
        }

        return false;
    }



    private class ITERATOR implements Iterator<E>{

        private Element current;
        E value;

        public ITERATOR(){
            current = head;
        }

        @Override
        public boolean hasNext() {
            return (current != null);
        }

        @Override
        public E next() {

            value = current.getValue();
            current = current.getNext();

            return value;
        }
    }
}
