package Laboratory_work_3.Stack.Implementation;

import Laboratory_work_3.Stack.Interface.Stack;

import java.util.ArrayList;
import java.util.NoSuchElementException;

public class ListStack<T> implements Stack<T> {
    private final ArrayList<T> items = new ArrayList<>();

    @Override
    public void push(T item) {
        items.add(item);
    }

    @Override
    public T pop() {
        if (isEmpty()) {
            System.out.println("Stack is empty");
        }else return items.remove(items.size() - 1);
        return null;
    }

    @Override
    public T peek() {
        if (isEmpty()) {
            System.out.println("Stack is empty");
        }else return items.get(items.size() - 1);
        return null;
    }

    @Override
    public boolean isEmpty() {
        return items.isEmpty();
    }

    @Override
    public int size() {
        return items.size();
    }
}

