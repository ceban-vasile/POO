package Laboratory_work_3.Stack.Implementation;

import Laboratory_work_3.Stack.Interface.AbstractStack;

public class ArrayStack implements AbstractStack {
    private final String[] array = new String[100];

    private int top = -1;

    @Override
    public void push(String item) {
        if (top < array.length - 1) {
            array[++top] = item;
        } else {
            throw new IllegalStateException("The stack is full.");
        }
    }

    @Override
    public String pop() {
        if (!isEmpty()) {
            return array[top--];
        }
        throw new IllegalStateException("The stack is empty.");
    }

    @Override
    public boolean isEmpty() {
        return top == -1;
    }

    @Override
    public String peek() {
        if (!isEmpty()) {
            return array[top];
        }
        throw new IllegalStateException("The stack is empty.");
    }
}
