package graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CourseSchedule {

    public static void main(String[] args) {
        TreeNode root1 = new TreeNode(3);
        TreeNode root2 = new TreeNode(1);
        TreeNode root3 = new TreeNode(3, root1, root2);
        TreeNode root4 = new TreeNode(1);
        //TreeNode root5 = new TreeNode(1);
        TreeNode root6 = new TreeNode(1, null, root4);
        TreeNode root7 = new TreeNode(2, root3, root6);
        /*TreeNode root8 = new TreeNode(5, root7, null);

        TreeNode root9 = new TreeNode(4);
        TreeNode root10 = new TreeNode(8, null, root9);

        TreeNode root11 = new TreeNode(5);
        TreeNode root12 = new TreeNode(4);
        TreeNode root13 = new TreeNode(3, root11, root12);
        TreeNode root14 = new TreeNode(2);
        TreeNode root15 = new TreeNode(2);
        TreeNode root16 = new TreeNode(9, root14, root15);
        TreeNode root17 = new TreeNode(6, root13, root16);
        TreeNode root18 = new TreeNode(2, null, root10);
        TreeNode root19 = new TreeNode(4, root18, root17);
        TreeNode root20 = new TreeNode(9, root8, root19);*/
        Solution s = new Solution();
        s.pseudoPalindromicPaths(root7);
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

class Solution {
    int count = 0;
    public int pseudoPalindromicPaths (TreeNode root) {
        if (root == null) {
            return count;
        }
        int arr[]  = new int[10];
        pseudoPalindromicPaths(root, arr);
        return count;
    }

    public void pseudoPalindromicPaths(TreeNode root, int[] arr) {
        if (root == null) {
            return;
        }
        arr[root.val] = arr[root.val] + 1;
        pseudoPalindromicPaths(root.left, arr);
        //isPalindrome(root, arr);
        pseudoPalindromicPaths(root.right, arr);
        if (root.left == null && root.right == null) {
            isPalindrome(root, arr);
        } else {
            arr[root.val] = arr[root.val]-1;
        }
    }

    public void isPalindrome(TreeNode root, int[] arr) {
        int odd = 0;
        for (int i = 0; i < 10; i++) {
            if (arr[i] % 2 == 1) {
                odd++;
            }
        }
        if (odd <= 1) {
            count++;
        }
        arr[root.val] = arr[root.val]-1;
    }
}