package linkedLists;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class DetectACycle {
	static class Node {
        public int data;
        public Node next;

        public Node(int nodeData) {
            this.data = nodeData;
            this.next = null;
        }
    }

    static class SinglyLinkedList {
        public Node head;
        public Node tail;

        public SinglyLinkedList() {
            this.head = null;
            this.tail = null;
        }

        public void insertNode(int nodeData) {
            Node node = new Node(nodeData);

            if (this.head == null) {
                this.head = node;
            } else {
                this.tail.next = node;
            }

            this.tail = node;
        }
    }

    public static void printSinglyLinkedList(boolean cycle, String sep, BufferedWriter bufferedWriter) throws IOException {
        bufferedWriter.write(String.valueOf(cycle));
    }

    // Complete the insertNodeAtPosition function below.

    /*
     * For your reference:
     *
     * Node {
     *     int data;
     *     Node next;
     * }
     *
     */
    static boolean hasCycle(Node head) {
    	if (head == null)
    		return false;
    	Node pntr1 = head;
    	Node pntr2 = head.next;
    	while (pntr1 != null && pntr2 != null && pntr2.next != null) {
    		if (pntr1 == pntr2) {
    			return true;
    		}
    		pntr1 = pntr1.next;
    		pntr2 = pntr2.next.next;
    		
    	}
    	return false;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("D:/HackerRank/text.txt"));

        SinglyLinkedList llist = new SinglyLinkedList();

        int llistCount = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < llistCount; i++) {
            int llistItem = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            llist.insertNode(llistItem);
        }

        int data = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int position = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        boolean cycle = hasCycle(llist.head);

        printSinglyLinkedList(cycle, " ", bufferedWriter);
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
