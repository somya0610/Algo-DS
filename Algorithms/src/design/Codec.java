package design;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = serialize(root, new StringBuilder());
        return sb.toString();
    }

    private StringBuilder serialize(TreeNode root, StringBuilder sb) {
        if (root == null) {
            sb.append("null,");
        } else {
            sb.append(root.val).append(",");
            sb = serialize(root.left, sb);
            sb = serialize(root.right, sb);
        }
        return sb;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] values = data.split(",");
        List<String> list = new LinkedList<String>(Arrays.asList(values));
        TreeNode root = deserialize(list);
        return root;
    }

    private TreeNode deserialize(List<String> list) {
        if (list.get(0).equals("null")) {
            list.remove(0);
            return null;
        }
        TreeNode root = new TreeNode(Integer.valueOf(list.get(0)));
        list.remove(0);
        root.left = deserialize(list);
        root.right = deserialize(list);
        return root;
    }

    private TreeNode insertNode(String[] values, TreeNode root, int i) {
        if (i < values.length) {
            if (values[i].equals("null")) {
                root = null;
            } else {
                root = new TreeNode(Integer.parseInt(values[i]));
                root.left = insertNode(values, root.left, 2*i+1);
                root.right = insertNode(values, root.right, 2*i+2);
            }
        }
        return root;
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

class Test {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        /*root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(5);*/
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(5);
        root.right.left.left = new TreeNode(6);
        root.right.left.right = new TreeNode(7);
        Codec c = new Codec();
        String s = c.serialize(root);
        TreeNode node = c.deserialize(s);
        System.out.println("Hi");
    }
}

