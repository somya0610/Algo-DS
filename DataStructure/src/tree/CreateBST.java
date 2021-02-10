package tree;

public class CreateBST {

    public static TreeNode sortedArrayToBST(int[] nums) {
        int size = nums.length;
        return bst(nums, 0, size-1);
    }

    public static TreeNode bst(int[] nums, int start, int end) {
        if (start > end) {
            return null;
        }
        int mid = start + (end-start)/2;
        TreeNode node = new TreeNode(nums[mid]);
        node.left = bst(nums, start, mid-1);
        node.right = bst(nums, mid+1, end);
        return node;
    }

    public static void main(String[] args) {
        int[] nums = {-10,-3,0,5,9};
        TreeNode tree = sortedArrayToBST(nums);
        preOrder(tree);

    }

    public static void preOrder(TreeNode root ) {

        if( root == null)
            return;

        System.out.print(root.val + " ");
        preOrder(root.left);
        preOrder(root.right);

    }
}
