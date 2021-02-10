package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MissingRanges {
    public static void main(String[] args) {
        System.out.println(findMissingRanges(new int[] {0, 1, 3, 50, 75}, 0, 99));
    }

    public static List<String> findMissingRanges(int[] nums, int lower, int upper) {
        Arrays.sort(nums);
        List<String> list = new ArrayList<>();
        int n = nums.length;
        for (int i = 0; i < n-1; i++) {
            if (nums[i] == nums[i+1]-1)
                continue;
            int num1 = nums[i] + 1;
            int num2 = nums[i+1] -1;
            String s = "";
            if (num2 == nums[i+1]) {
                s = String.valueOf(num1);
            } else {
                s = num1 + "->" + num2;
            }
            list.add(s);
        }
        if (nums[n-1] != 99) {
            int num1 = nums[n-1] + 1;
            int num2 = 99;
            String s = "";
            if (num1 == 99) {
                s = String.valueOf(num1);
            } else {
                s = num1 + "->" + num2;
            }
            list.add(s);
        }
        return list;
    }
}
