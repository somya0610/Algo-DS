package design;

import java.util.PriorityQueue;
import java.util.Stack;

class MinStack {

    /** initialize your data structure here. */
    Stack<Integer> stack;
    PriorityQueue<Integer> pq;

    public MinStack() {
        stack = new Stack<>();
        pq = new PriorityQueue<>();
    }

    public void push(int x) {
        stack.push(x);
        pq.add(x);
    }

    public void pop() {
        pq.remove(stack.pop());
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return pq.peek();
    }
}
