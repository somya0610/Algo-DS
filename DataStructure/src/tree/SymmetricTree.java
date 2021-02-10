package tree;

import java.util.LinkedList;
import java.util.Queue;

public class SymmetricTree {
    public static void main(String[] args) {

    }

    public boolean isSymmetric(TreeNode root) {
        if (root == null)
            return true;
        Queue<TreeNode> qLeft = new LinkedList<>();
        Queue<TreeNode> qRight = new LinkedList<>();
        qLeft.add(root.left);
        qRight.add(root.right);
        return bfs(root.left, root.right, qLeft, qRight);
    }

    public boolean bfs(TreeNode left, TreeNode right, Queue<TreeNode> qLeft, Queue<TreeNode> qRight) {
        while (!qLeft.isEmpty() && !qRight.isEmpty()) {
            TreeNode leftInt = qLeft.poll();
            TreeNode rightInt = qRight.poll();

            if (leftInt == null && rightInt == null)
                continue;
            if ((leftInt != null && rightInt == null) || (leftInt == null && rightInt != null)
                    || (leftInt.val != rightInt.val))
                return false;

            qLeft.add(leftInt.left);
            qLeft.add(leftInt.right);

            qRight.add(rightInt.right);
            qRight.add(rightInt.left);
        }
        return true;
    }

}
