package Laboratory_work_3;

import Laboratory_work_3.Queue.Implementations.ArrayQueue;
import Laboratory_work_3.Queue.Implementations.LinkedListQueue;
import Laboratory_work_3.Queue.Implementations.ListQueue;
import Laboratory_work_3.Queue.Interface.Queue;
import Laboratory_work_3.Stack.Implementation.ArrayStack;
import Laboratory_work_3.Stack.Implementation.LinkedListStack;
import Laboratory_work_3.Stack.Implementation.ListStack;
import Laboratory_work_3.Stack.Interface.Stack;

public class Main {
    public static void main(String[] args){
        Queue<Integer> stack = new ListQueue<>();

        stack.enqueue(10);
        stack.enqueue(20);
        stack.enqueue(30);

        System.out.println(stack.dequeue());
        System.out.println(stack.peek());
        System.out.println(stack.size());
    }
}
