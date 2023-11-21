package Laboratory_work_3.Stack.Implementation;

import Laboratory_work_3.Node.Node;
import Laboratory_work_3.Stack.Interface.Stack;

import java.util.NoSuchElementException;

public class LinkedListStack<T> implements Stack<T> {
    private Node<T> top;
    private int size;

    public LinkedListStack() {
        top = null;
        size = 0;
    }

    @Override
    public void push(T item) {
        Node<T> newNode = new Node<>(item);
        newNode.next = top;
        top = newNode;
        size++;
    }

    @Override
    public T pop() {
        if (isEmpty()) {
            System.out.println("Stack is empty");
        }else {
            T value = top.data;
            top = top.next;
            size--;
            return value;
        }
        return null;
    }

    @Override
    public T peek() {
        if (isEmpty()) {
            System.out.println("Stack is empty");
        }else return top.data;
        return null;
    }

    @Override
    public boolean isEmpty() {
        return top == null;
    }

    @Override
    public int size() {
        return size;
    }
}
