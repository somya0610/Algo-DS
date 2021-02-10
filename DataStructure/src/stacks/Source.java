import java.util.*;
public class Source{

    public static class Node
    {
        int data;
        Node left, right;

        Node(int item)
        {
            data = item;
            left = right = null;
        }
    }

    public static class BinaryTree
    {
        Node root;
        BinaryTree() {
            root = null;
        }

        public Node constructBST(int[] elementsArr, int n) {
            if (n == 0) {
                return  null;
            }
            Node root = null;
            for (int i = 0; i < n; i++) {
                root = levelOrder(root, elementsArr[i]);
            }
            return root;
        }

        // Method to construct a binary tree from the given array (Do not edit the code given below)
        public Node levelOrder(Node root, int data){
            if (root == null) {
                root = new Node(data);
                return root;
            }
            if (data < root.data) {
                root.left = levelOrder(root.left, data);
            } else {
                root.right = levelOrder(root.right, data);
            }
            return root;
        }

        public void inOrderTraversal(Node node) {
            if (node == null) {
                return;
            }
            inOrderTraversal(node.left);
            System.out.print(node.data + " ");
            inOrderTraversal(node.right);
        }
    }
    public static void main(String args[])
    {
        BinaryTree tree = new BinaryTree();

        Scanner sc = new Scanner(System.in);
        int size = 15;
        //size = sc.nextInt();

        if(size<= 0){
            System.out.println("Size should be a positive integer");
        }

        else{
            /*int[] elementsArr = new int[size];
            for(int i = 0; i < size; i++){
                elementsArr[i] = sc.nextInt();
            }*/
            int values[] = { 1, 20, 15, 7, 5, 10, 3 };
            int levels[] = { 4, 1, 0, 3, 2, 1, 3 };

            Map<Integer, List<Integer>> map = new HashMap<>();
            for (int i = 0; i < 7; i++) {
                List<Integer> list;
                if (map.containsKey(levels[i])) {
                    list = map.get(levels[i]);
                    list.add(values[i]);
                    map.put(levels[i], list);
                } else {
                    list = new ArrayList<>();
                    list.add(values[i]);
                    map.put(levels[i], list);
                }
            }
            int[] elementsArr = new int[7];
            int x = 0;
            for (int i = 0; i < map.size(); i++) {
                List<Integer> list = map.get(i);
                for (int j = 0; j < list.size(); j++) {
                    elementsArr[x] = list.get(j);
                    x++;
                }
            }
            tree.root = tree.constructBST(elementsArr, 7);
            tree.inOrderTraversal(tree.root);
        }


    }
}