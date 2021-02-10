package dynamicProgramming;

import java.util.*;

public class LongestContinuousSubarrayWithAbsoluteDiff {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int limit = 5;
		int[] nums = {10,1,2,4,7,2};//{1,5,6,7,8,10,6,5,6};

		int len = longestSubarray(nums, limit);
		System.out.println(len);
	}

	public static int longestSubarray(int[] nums, int limit) {
		int size = nums.length;
		if (size <= 1) {
			return size;
		}
		int max = nums[0];
		int min = nums[0];
		int start = 0;
		int end = 0;
		int maxLen = 0;
		int absDiff = 0;

		while (start <= end && end < size) {
			if (maxLen > (size-start)) {
				break;
			}
			min = Math.min(min, nums[end]);
			max = Math.max(max, nums[end]);
			absDiff = max - min;
			if (absDiff <= limit) {
				maxLen = Math.max(maxLen, (end-start+1));
				end++;
			} else if (end != size){
				start++;
				int k = end;
				min = nums[end];
				max = nums[end];
				if (start != end) {
					int minTemp = min;
					int maxTemp = max;
					while (k >= start && (max - min) <= limit) {
						minTemp = min;
						maxTemp = max;
						min = Math.min(min, nums[k]);
						max = Math.max(max, nums[k]);
						k--;
					}
					if (k != start - 1) {
						start = k + 2;
						min = minTemp;
						max = maxTemp;
					}
				}
				end++;
			}
		}
		return maxLen;
	}

}
