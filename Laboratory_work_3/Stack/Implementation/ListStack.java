package Laboratory_work_3.Stack.Implementation;

import Laboratory_work_3.Stack.Interface.AbstractStack;

import java.util.ArrayList;

public class ListStack implements AbstractStack {
    private final ArrayList<String> list = new ArrayList<>();

    @Override
    public void push(String item) {
        list.add(item);
    }

    @Override
    public String pop() {
        if (!isEmpty()) {
            return list.remove(list.size() - 1);
        }
        throw new IllegalStateException("The stack is empty.");
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

    @Override
    public String peek() {
        if (!isEmpty()) {
            return list.get(list.size() - 1);
        }
        throw new IllegalStateException("The stack is empty.");
    }
}

