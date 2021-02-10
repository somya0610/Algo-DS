package tree;

public class MaxDepth {

    public static void main(String[] args) {
        TreeNode tree = new TreeNode();
        int[] elementsArr = {3,9,20,0,0,15,7};
        tree = insertNode(elementsArr, tree, 0);
        System.out.println(maxDepth(tree));

    }

    public static int maxDepth(TreeNode root) {
        return dfs(root);
    }

    public static int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = dfs(root.left);
        int right = dfs(root.right);
        return 1 + Math.max(left, right);
    }

    public static TreeNode insertNode(int[] elementsArr, TreeNode node, int i) {
        if(i < elementsArr.length){
            if (elementsArr[i] == 0) {
                node = null;
            } else {
                node = new TreeNode(elementsArr[i]);
                node.left = insertNode(elementsArr, node.left, 2 * i + 1);
                node.right = insertNode(elementsArr, node.right, 2 * i + 2);
            }
        }
        return node;
    }
}

 class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode() {}
     TreeNode(int val) { this.val = val; }
     TreeNode(int val, TreeNode left, TreeNode right) {
         this.val = val;
         this.left = left;
         this.right = right;
     }
 }
