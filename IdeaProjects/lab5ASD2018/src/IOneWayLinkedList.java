


public class IOneWayLinkedList<E> {

    private class Element {

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
    }

        private Element head = null;

        public IOneWayLinkedList(){}

        void clear(){
            head = null;
        }



        public int size(){

            Element actElem = head;
            int pos = 0;

            while(actElem != null){
                pos++;
                actElem = actElem.getNext();
            }
            return pos;
        }

        private Element getElem(int index){

            Element actElem = head;

            while(index > 0 && actElem != null){

                index--;
                actElem = actElem.getNext();

            }

            return actElem;

        }

        public E get(int index){
            return getElem(index).getValue();
        }


        public boolean insert(int index, E elem){

            int i;

            Element newElem = new Element();
            newElem.setValue(elem);

            if(index == 0){

                newElem.setNext(head);
                head = newElem;
                return true;
            }

            Element actElem = getElem(index-1);

            if(actElem == null)
                return false;

            newElem.setNext(actElem.getNext());
            actElem.setNext(newElem);
            return true;

        }

        void wyswietlListe(){

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



    }



