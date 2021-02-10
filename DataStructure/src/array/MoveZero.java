package array;

public class MoveZero {

    public static void main(String[] args) {
        int[] nums = {0,1,0,3,12};
        System.out.println(nums);
    }

    public static void moveZeroes(int[] nums) {
        int size = nums.length;
        int i = 0;
        for (int j = 0; j < size; j++) {
            if (nums[j] != 0) {
                nums[i++] = nums[j];
            }
        }
        for (int j = i; j < size; j++) {
            nums[j] = 0;
        }
    }
}
