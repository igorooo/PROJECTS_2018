
public interface IQueue {
    boolean isEmpty();
    boolean isFull();
    int dequeue() throws EmptyQueueException;
    void enqueue(int elem) throws FullQueueException;
    int size();  // zwraca liczb� element�w w kolejce
    int first() throws EmptyQueueException;
}