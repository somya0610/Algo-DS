package com.apex.aug27;

import java.util.Scanner;

public class MaximumSubarray {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int size = sc.nextInt();
		int[] nums = new int[size];
		for (int i = 0; i < size; i++) {
			nums[i] = sc.nextInt();
		}
		System.out.println(-2 > -2147483648);
		int sum = maxSubArray(nums);
		System.out.println(sum);

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
