import java.util.ArrayList;

public class SetOnList<E> {

    ArrayList<Element> array;


    class Element<E>{

        private E value;
        private Element next,prev;
        public int high;

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

        public void setPrev(Element prev){
            this.prev = prev;
        }

        public Element getPrev(){
            return prev;
        }

        Element(E data){
            this.value=data;
        }
    }

    public SetOnList(){

        array = new ArrayList<>();
    }

    public void Make_Set(E val){

        Element e = new Element(val);

        array.add(e);

        e.setPrev(e);
        e.high = 0;
    }

    public Element findSet(E val){

        Element next;

        for(Element elem:array){

            next = elem;

            if(next.getValue() == val){
                return next.getPrev();
            }

            while(next.getNext() != null){

                if(next.getValue() == val){
                    return next.getPrev();
                }
                next = next.getNext();
            }
        }
        return null;
    }

    public void add_to_Set(E set, E val){

        Element elem = new Element(val);
        Element repr = findSet(set);

        if(repr != null){

            elem.setPrev(repr);
            repr.high ++;

            while(repr.getNext() != null){
                repr = repr.getNext();
            }

            repr.setNext(elem);
            return;
        }


        System.out.println("There is no such a set");
    }

    public void Union(E setA, E setB){

        Element A = findSet(setA),  B = findSet(setB),C,N,P;

        if(A.high < B.high ){

            C = B;
            B = A;
            A = C;
        }

        N = A;

        while( N.getNext() != null){
            N = N.getNext();
        }

        N.setNext(B);
        P = B;
        P.setPrev(A);



        while( P.getNext() != null){

            P = P.getNext();
            P.setPrev(A);
        }

        A.high += B.high;

        array.remove(B);

    }

    public void display(){
        Element A;

        for(Element elem: array){

            A = elem;
            System.out.print(A.value + " ");

            while( A.getNext() != null){
                A = A.getNext();
                System.out.print(A.value + " ");

            }
            System.out.println();
        }
    }







}
