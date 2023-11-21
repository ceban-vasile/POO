package Laboratory_work_3.Queue.Implementations;

import Laboratory_work_3.Queue.Interface.Queue;
import Laboratory_work_3.Node.Node;

import java.util.NoSuchElementException;

public class LinkedListQueue<T> implements Queue<T> {
    private Node<T> front;
    private Node<T> rear;
    private int size;

    public LinkedListQueue() {
        front = null;
        rear = null;
        size = 0;
    }

    @Override
    public void enqueue(T item) {
        Node<T> newNode = new Node<>(item);
        if (isEmpty()) {
            front = newNode;
            rear = newNode;
        } else {
            rear.next = newNode;
            rear = newNode;
        }
        size++;
    }

    @Override
    public T dequeue() {
        if (isEmpty()) {
            System.out.print("Queue is ");
        }else {
            T value = front.data;
            front = front.next;
            if (front == null) {
                rear = null;
            }
            size--;
            return value;
        }
        return null;
    }

    @Override
    public T peek() {
        if (isEmpty()) {
            System.out.print("Queue is ");
        }else return front.data;
        return null;
    }

    @Override
    public boolean isEmpty() {
        return front == null;
    }

    @Override
    public int size() {
        return size;
    }
}
