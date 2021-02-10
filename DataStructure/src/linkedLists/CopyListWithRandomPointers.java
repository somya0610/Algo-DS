package linkedLists;

import java.util.HashMap;

public class CopyListWithRandomPointers {
    public static void main(String[] args) {

    }

    HashMap<Node, Node> visited = new HashMap<Node, Node>();

    public Node getClonedNode(Node node) {
        // If the node exists then
        if (node != null) {
            if (this.visited.containsKey(node)) {
                return this.visited.get(node);
            } else {
                this.visited.put(node, new Node(node.val));
                return this.visited.get(node);
            }
        }
        return null;
    }

    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }

        Node oldNode = head;

        Node newNode = new Node(oldNode.val);
        this.visited.put(oldNode, newNode);

        while (oldNode != null) {
            newNode.random = this.getClonedNode(oldNode.random);
            newNode.next = this.getClonedNode(oldNode.next);

            // Move one step ahead in the linked list.
            oldNode = oldNode.next;
            newNode = newNode.next;
        }
        return this.visited.get(head);
    }
}

class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
