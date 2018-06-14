public class PriorityQueue implements IQueue {

    int array[];

    private int FREE_SPOT,size;
    boolean IS_FULL;

    public PriorityQueue(int size){
        array = new int[size];
        this.size = size;
        FREE_SPOT = 0;
        IS_FULL = false;
    }

    @Override
    public boolean isEmpty() {
        return (FREE_SPOT == 0);
    }

    @Override
    public boolean isFull() {
        return IS_FULL;
    }

    @Override
    public int dequeue() throws EmptyQueueException {
        int ret = array[0];

        array[0] = array[FREE_SPOT-1];
        sink(0);
        FREE_SPOT--;

        return ret;
    }

    @Override
    public void enqueue(int elem) throws FullQueueException {
        array[FREE_SPOT++] = elem;

        if(FREE_SPOT >= size){
            IS_FULL = true;
            System.out.println("Queue Is Full");
        }

        swim(FREE_SPOT-1);
    }

    @Override
    public int size() {
        return FREE_SPOT;
    }

    @Override
    public int first() throws EmptyQueueException {
        return array[0];
    }

    private void swim(int index){
        int parent,swap;
        parent = (index-1)/2;

        while(index > 0 && (array[index] > array[parent])){
            swap = array[index];
            array[index] = array[parent];
            array[parent] = swap;
            index = parent;
            parent = (index-1)/2;
        }
    }

    private void sink(int index){

        int child,swap;
        boolean isDone = false;

        while(!isDone && (child= 2*index +1) < size()){

            if(array[child] < array[child+1] && child < size()-1){
                child++;
            }

            if(array[index] < array[child]){
                swap = array[index];
                array[index] = array[child];
                array[child] = swap;
                index = child;
            }

            else{
                isDone = true;
            }

        }

    }

    public void ShowTime(){
        for(int i = 0; i < size(); i++){
            System.out.print(array[i]+" ");
        }
        System.out.println();
    }

    public void delete(int index)  {

        if(index >= size()){
            System.out.println("Index out of bounds");
            return;
        }


        array[index] = array[--FREE_SPOT];

        if(index > 0){
            int parent = (index - 1)/2;

            if(array[parent] < array[index]){
                swim(index);
            }

            else{
                sink(index);
            }
        }

        else{
            sink(index);
        }


    }

    public void ChangeVal(int index,int value){

        if(index >= size()){
            System.out.println("Index out of bounds");
            return;
        }


        array[index] = value;

        if(index > 0){
            int parent = (index - 1)/2;

            if(array[parent] < array[index]){
                swim(index);
            }

            else{
                sink(index);
            }
        }

        else{
            sink(index);
        }


    }

    public void ClearQueue(){
        FREE_SPOT = 0;
    }

    public void HeapSort(){

        int CurrentSize = FREE_SPOT,swap;
        FREE_SPOT--;

        while(FREE_SPOT > 0){

            swap = array[0];
            array[0] = array[FREE_SPOT];
            array[FREE_SPOT] = swap;
            FREE_SPOT--;
            sink(0);

        }

        FREE_SPOT = CurrentSize;

        ShowTime();

    }
}
