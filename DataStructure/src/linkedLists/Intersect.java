package linkedLists;

public class Intersect {
    public static void main(String[] args) {

    }

    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int sizeA = getLength(headA);
        int sizeB = getLength(headB);
        if (sizeA == 0 || sizeB == 0)
            return null;
        if (sizeA > sizeB) {
            return getIntersectionNode(headA, sizeA, headB, sizeB);
        } else {
            return getIntersectionNode(headB, sizeB, headA, sizeA);
        }
    }

    public static ListNode getIntersectionNode(ListNode headA, int sizeA, ListNode headB, int sizeB) {
        int i = 0;
        while (i < (sizeA - sizeB)) {
            headA = headA.next;
            i++;
        }
        while (headA != null && headB != null) {
            if (headA == headB) {
                return headA;
            }
            headA = headA.next;
            headB = headB.next;
        }
        return null;
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

class ListNode {
      int val;
      ListNode next;
      ListNode(int x) {
          val = x;
          next = null;
      }
  }
