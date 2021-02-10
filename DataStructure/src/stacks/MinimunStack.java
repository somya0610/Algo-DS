package stacks;

import java.util.Deque;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class MinimunStack {
    public static void main(String[] args) {

    }
}

class MinStack {

    /** initialize your data structure here. */
    PriorityQueue<Integer> pq;
    Deque<Integer> dq;

    public MinStack() {
        pq = new PriorityQueue<>();
        dq = new LinkedList<>();
    }

    public void push(int x) {
        pq.add(x);
        dq.add(x);
    }

    public void pop() {
        pq.remove(dq.pollLast());
    }

    public int top() {
        return dq.peekLast();
    }

    public int getMin() {
        return pq.peek();
    }
}
