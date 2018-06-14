public interface IStack<T> {

    boolean isEmpty();
    boolean isFull();
    T pop();
    void push(T elem);
    int size();
    T top();

}
