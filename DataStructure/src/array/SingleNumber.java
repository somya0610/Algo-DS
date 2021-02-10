package array;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class SingleNumber {

    public static void main(String[] args) {
        int[] nums = {2,2,1};
        System.out.println(singleNumber(nums));
    }

    public static int singleNumber(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int count = map.getOrDefault(nums[i], 0);
            map.put(nums[i], count+1);
        }
        Set<Integer> keys = map.keySet();
        for (Integer x : keys) {
            if (map.get(x) == 1) {
                return x;
            }
        }
        return -1;
    }
}
