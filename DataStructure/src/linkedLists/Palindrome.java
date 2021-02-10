package linkedLists;

import java.awt.peer.ListPeer;

public class Palindrome {
    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        node.next = new ListNode(2);
        System.out.println(isPalindrome(node));
    }

    public static boolean isPalindrome(ListNode head) {
        int n = getLength(head);
        if (n == 0)
            return false;
        if (n == 1)
            return true;
        int mid = n/2;
        ListNode tempLeft = head;
        ListNode tempRight = head;
        int i = 1;
        while(i++ < mid) {
            tempLeft = tempLeft.next;
        }
        if (n%2 == 0) {
            tempRight = tempLeft.next;
        } else {
            tempRight = tempLeft.next.next;
        }
        tempLeft = reverse(head, tempLeft);
        while (tempLeft != null && tempRight != null) {
            if (tempLeft.val != tempRight.val)
                return false;
            tempLeft = tempLeft.next;
            tempRight = tempRight.next;
        }
        return true;
    }

    public static ListNode reverse(ListNode head, ListNode node) {
        ListNode prev = null;
        ListNode curr = head;
        ListNode next = head;
        while (next != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
            if (prev == node)
                break;
        }

        return prev;
    }

    public static int getLength(ListNode head) {
        ListNode temp = head;
        int size = 0;
        while (temp != null) {
            size++;
            temp = temp.next;
        }
        return size;
    }
}
