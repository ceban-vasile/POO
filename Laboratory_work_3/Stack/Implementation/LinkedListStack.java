package Laboratory_work_3.Stack.Implementation;

import Laboratory_work_3.Stack.Interface.AbstractStack;

public class LinkedListStack implements AbstractStack {
    private Node top;

    @Override
    public void push(String item) {
        Node node = new Node(item);
        node.next = top;
        top = node;
    }

    @Override
    public String pop() {
        if (!isEmpty()) {
            String value = top.value;
            top = top.next;
            return value;
        }
        throw new IllegalStateException("The stack is empty.");
    }

    @Override
    public boolean isEmpty() {
        return top == null;
    }

    @Override
    public String peek() {
        if (!isEmpty()) {
            return top.value;
        }
        throw new IllegalStateException("The stack is empty.");
    }
}
