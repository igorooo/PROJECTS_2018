public class Stos<T> implements  IStack<T> {

    int size;
    int TOP;

    T[] tab;

    public Stos(int size){
        tab = (T[])(new Object[size] );
        this.size = size;
        TOP = 0;
    }

    private void CSize(boolean f){   // If true then make tab bigger

        if(f){
            T[] newtab =(T[])(new Object[size*2]);
            newtab = tab;
            tab = newtab;
            size *= 2;
        }

        else{
            T[] newtab = (T[])(new Object[size/2]);
            newtab = tab;
            tab = newtab;
            size /= 2;
        }
    }


    @Override
    public boolean isEmpty() {
        return TOP == 0;
    }

    @Override
    public boolean isFull() {
        return TOP == size-1;
    }

    @Override
    public T pop() {


        T obj = tab[--TOP];

        if((TOP) <= size/4){
           CSize(false);
        }

        return obj;
    }

    @Override
    public void push(T elem) {
        tab[TOP++] = elem;

        if(TOP >= 3*(size/4)){
            CSize(true);
        }
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public T top() {
        return tab[TOP];
    }
}
