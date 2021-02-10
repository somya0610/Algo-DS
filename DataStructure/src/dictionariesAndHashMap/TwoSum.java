package dictionariesAndHashMap;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class TwoSum {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int size = sc.nextInt();
		int[] nums = new int[size];
		for (int i = 0; i < size; i++) {
			nums[i] = sc.nextInt();
		}
		int target = sc.nextInt();
		int[] result = twoSum(nums, target);
		if (result != null) {
			System.out.println(result[0] + " " + result[1]);
		} else {
			System.out.println("No such numbers present");
		}

	}

	public static int[] twoSum(int[] nums, int target) {
		int size = nums.length;
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < size; i++) {
			if (map.containsKey(target - nums[i])) {
				return new int[] {target - nums[i], nums[i]};
			} else {
				map.put(nums[i], i);
			}
		}
 		return null;
	}

}
