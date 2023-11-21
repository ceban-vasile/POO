package Laboratory_work_3.Queue.Implementations;

import Laboratory_work_3.Queue.Interface.Queue;

import java.util.NoSuchElementException;

public class ArrayQueue<T> implements Queue<T> {
    private T[] items;
    private int front;
    private int rear;
    private int size;

    public ArrayQueue(int capacity) {
        items = (T[]) new Object[capacity];
        front = 0;
        rear = -1;
        size = 0;
    }

    @Override
    public void enqueue(T element) {
        if (size == items.length) {
            System.out.println("Queue is full");
        }else {
            rear = (rear + 1) % items.length;
            items[rear] = element;
            size++;
        }
    }

    @Override
    public T dequeue() {
        if (isEmpty()) {
            System.out.print("Queue is ");
        }else {
            T value = items[front];
            front = (front + 1) % items.length;
            size--;
            return value;
        }
        return null;
    }

    @Override
    public T peek() {
        if (isEmpty()) {
            System.out.print("Queue is ");
        }else return items[front];
        return null;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int size() {
        return size;
    }
}
