package Laboratory_work_3.Queue.Implementations;

import Laboratory_work_3.Queue.Interface.Queue;

import java.util.ArrayList;
import java.util.NoSuchElementException;

public class ListQueue<T> implements Queue<T> {
    private final ArrayList<T> items;
    private int front;

    public ListQueue() {
        items = new ArrayList<>();
        front = 0;
    }

    @Override
    public void enqueue(T item) {
        items.add(item);
    }

    @Override
    public T dequeue() {
        if (isEmpty()) {
            System.out.print("Queue is ");
        } else return items.remove(front);
        return null;
    }

    @Override
    public T peek() {
        if (isEmpty()) {
            System.out.print("Queue is ");
        } else return items.get(front);
        return null;
    }

    @Override
    public boolean isEmpty() {
        return front == items.size();
    }

    @Override
    public int size() {
        return items.size() - front;
    }
}

