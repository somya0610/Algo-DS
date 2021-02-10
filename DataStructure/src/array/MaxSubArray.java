package array;

public class MaxSubArray {
    public static void main(String[] args) {
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(maxSubArray(nums));
    }

    public static int maxSubArray(int[] nums) {
        int size = nums.length;
        if (size == 0) {
            return 0;
        }
        int maxSum = Integer.MIN_VALUE;
        int sum = 0;
        for (int i = 0; i < size; i++) {
            sum += nums[i];
            sum = Math.max(sum, nums[i]);
            maxSum = Math.max(maxSum, sum);

        }
        return maxSum;

    }
}
