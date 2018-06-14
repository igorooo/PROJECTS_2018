
public class LinkStack<E>  {
    private class Element{

        private E value;
        private Element next;

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



        Element(E data){
            this.value=data;
        }
    }

    Element head=null;

    public LinkStack(){}



    public boolean isEmpty(){
        return head==null;
    }


    public int size() {
        int pos=0;
        Element actElem=head;
        while(actElem!=null)
        {
            pos++;
            actElem=actElem.getNext();
        }
        return pos;
    }

    /** Funkcja TOP dla stosu */
    private Element TOP(int index){
        Element actElem=head;
        while(actElem.getNext() != null){
            actElem = actElem.getNext();
        }
        return actElem;
    }

    /** Funkcja PUSH dla stosu */

    public boolean push(E e) {
        Element newElem=new Element(e);
        if(head==null){
            head=newElem;
            return true;
        }
        Element tail=head;
        while(tail.getNext()!=null)
            tail=tail.getNext();
        tail.setNext(newElem);
        return true;
    }


    /** Funckaj POP dla stosu */

    public E pop() {

        Element actElem;
        E helpVal;

        if(head==null)
            return null;

        actElem = head;


        while(actElem.getNext().getNext() != null){
            actElem = actElem.getNext();
        }

        helpVal = actElem.getNext().value;

        actElem.setNext(null);

        return helpVal;
    }

}
