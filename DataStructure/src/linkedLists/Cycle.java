package linkedLists;

public class Cycle {
    public static void main(String[] args) {

    }

    public boolean hasCycle(ListNode head) {
        ListNode oneJump = head;
        ListNode twoJump = head;

        while (oneJump != null && twoJump != null && twoJump.next != null) {
            oneJump = oneJump.next;
            twoJump = twoJump.next.next;

            if (oneJump == twoJump)
                return true;
        }
        return false;
    }
}
