package Laboratory_work_3.Stack.Implementation;

import Laboratory_work_3.Stack.Interface.Stack;

import java.util.NoSuchElementException;

public class ArrayStack<T> implements Stack<T> {
    private final T[] items;
    private int top;

    public ArrayStack(int capacity) {
        items = (T[]) new Object[capacity];
        top = -1;
    }

    @Override
    public void push(T item) {
        if (top == items.length - 1) {
            throw new IllegalStateException("Stack is full");
        }
        items[++top] = item;
    }

    @Override
    public T pop() {
        if (isEmpty()) {
            throw new NoSuchElementException("Stack is empty");
        }
        return items[top--];
    }

    @Override
    public T peek() {
        if (isEmpty()) {
            throw new NoSuchElementException("Stack is empty");
        }
        return items[top];
    }

    @Override
    public boolean isEmpty() {
        return top == -1;
    }

    @Override
    public int size() {
        return top + 1;
    }
}
