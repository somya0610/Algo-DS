package com.apex.aug27;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class LongestConsecutiveSequence {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int size = sc.nextInt();
		int[] nums = new int[size];
		for (int i = 0; i < size; i++) {
			nums[i] = sc.nextInt();
		}
		int len = longestConsecutive(nums);
		System.out.println(len);
	}

	static int longestConsecutive(int[] nums) {
		int size = nums.length;
		if (size == 0) {
			return 0;
		}
		Map<Integer, Boolean> map = new HashMap<Integer, Boolean>();
		for (int i = 0; i < size; i++) {
			map.put(nums[i], false);
		}
		int maxLen = Integer.MIN_VALUE;
		for (int i = 0; i < size; i++) {
			if (map.get(nums[i])) {
				continue;
			}
			map.put(nums[i], true);
			int seqLen = 1;
			int currElt = nums[i]-1;
			while (map.containsKey(currElt)) {
				map.put(currElt, true);
				currElt--;
				seqLen++;
			}
			currElt = nums[i]+1;
			while (map.containsKey(currElt)) {
				map.put(currElt, true);
				currElt++;
				seqLen++;
			}
			maxLen = Math.max(maxLen, seqLen);
		}
		return maxLen;
	}

}
