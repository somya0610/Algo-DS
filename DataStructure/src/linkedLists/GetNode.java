package linkedLists;

import java.util.*;

public class GetNode {
    static Node head;

    static class Node {
        int data;
        Node next;

        Node(int n) {
            data = n;
            next = null;
        }
    }

    public static void main(String args[]) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        head = null;
        if (n > 0) {
            head = new Node(s.nextInt());
            Node temp = head;
            for (int i = 1; i < n; i++) {
                temp.next = new Node(s.nextInt());
                temp = temp.next;
            }
        }
        int k = s.nextInt();
        boolean result = getNode(k);
        System.out.println(result);
    }

    static boolean getNode(int k) {
        while (head != null) {
            if (head.data == k) {
            	return true;
            }
            head = head.next;
        }
        return false;
    }
}
