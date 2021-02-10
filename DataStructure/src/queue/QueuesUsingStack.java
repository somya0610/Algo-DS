package queue;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

class MyQueue<T> {
    Stack<T> stack = new Stack<>();
    Stack<T> temp = new Stack<>();

    public void enqueue(T num) {
        stack.push(num);
    }

    public void dequeue() {
        if (temp.size() == 0) {
            while (!stack.isEmpty()) {
                temp.push(stack.pop());
            }
        }
        if (!temp.isEmpty()) {
            temp.pop();
        }
    }

    public T peek() {
        if (temp.size() == 0) {
            while (!stack.isEmpty()) {
                temp.push(stack.pop());
            }
        }
        return temp.peek();
    }
}

public class QueuesUsingStack {
    public static void main(String[] args) {
        MyQueue<Integer> queue = new MyQueue<Integer>();

        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();

        for (int i = 0; i < n; i++) {
            int operation = scan.nextInt();
            if (operation == 1) { // enqueue
                queue.enqueue(scan.nextInt());
            } else if (operation == 2) { // dequeue
                queue.dequeue();
            } else if (operation == 3) { // print/peek
                System.out.println(queue.peek());
            }
        }
        scan.close();
    }
}
