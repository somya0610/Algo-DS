package tree;

import java.util.Scanner;
import java.util.Stack;

public class IsBST {

    static  boolean checkBST(Node root) {

        return dfs(root, null, null);
    }

    private static boolean dfs(Node root, Integer max, Integer min) {
        if (root == null)
            return true;
        if ((max != null && root.data > max) || min != null && root.data < min)
            return false;
        return dfs(root.left, root.data, min) && dfs(root.right, max, root.data);

    }


    public static Node insert(Node root, int data) {
        if(root == null) {
            return new Node(data);
        } else {
            Node cur;
            if(data <= root.data) {
                cur = insert(root.left, data);
                root.left = cur;
            } else {
                cur = insert(root.right, data);
                root.right = cur;
            }
            return root;
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        Node root = null;
        while(t-- > 0) {
            int data = scan.nextInt();
            root = insert(root, data);
        }
        boolean ans = checkBST(root);
        System.out.println(ans);
    }
}
