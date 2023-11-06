package Laboratory_work_3.Queue.Interface;

public interface Queue<T> {
    void enqueue(T item);
    T dequeue();
    T peek();
    boolean isEmpty();
    int size();
}
