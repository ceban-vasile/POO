package Laboratory_work_3.Queue.Interface;

public interface AbstractQueue {
    void enqueue(int item);
    int dequeue();
    boolean isEmpty();
    int front();
}
