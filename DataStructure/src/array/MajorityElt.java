package array;

public class MajorityElt {

    public static void main(String[] args) {
        int[] num = {2,2,1,1,1,2,2};
        System.out.println(majorityElement(num));
    }

    public static int majorityElement(int[] nums) {
        int max_index = 0, count = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[max_index]) {
                count++;
            } else {
                count--;
                if (count == 0) {
                    max_index = i;
                    count++;
                }
            }
        }
        return nums[max_index];
    }
}
