public class Main {

    public static void main(String[] args) throws FullQueueException,EmptyQueueException {

        PriorityQueue pqueue = new PriorityQueue(15);

        pqueue.enqueue(10);
        pqueue.enqueue(5);
        pqueue.enqueue(6);
        pqueue.enqueue(0);
        pqueue.enqueue(20);
        pqueue.enqueue(12);
        pqueue.enqueue(3);
        pqueue.enqueue(2);
        pqueue.enqueue(7);
        pqueue.enqueue(16);
        pqueue.ShowTime();
        pqueue.dequeue();
        pqueue.ShowTime();
        pqueue.dequeue();
        pqueue.ShowTime();
        pqueue.dequeue();
        pqueue.ShowTime();
        pqueue.dequeue();
        pqueue.ShowTime();


        pqueue.delete(2);
        pqueue.ShowTime();

        pqueue.delete(0);
        pqueue.ShowTime();

        pqueue.ChangeVal(0,1);
        pqueue.ShowTime();

        pqueue.ClearQueue();

        pqueue.enqueue(10);
        pqueue.enqueue(5);
        pqueue.enqueue(6);
        pqueue.enqueue(0);
        pqueue.enqueue(20);
        pqueue.enqueue(12);
        pqueue.enqueue(3);
        pqueue.enqueue(2);
        pqueue.enqueue(7);
        pqueue.enqueue(16);
        pqueue.ShowTime();

        pqueue.HeapSort();





    }

}
