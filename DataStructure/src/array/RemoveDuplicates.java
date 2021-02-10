package array;

import java.util.Arrays;
import java.util.Scanner;

public class RemoveDuplicates {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int size = sc.nextInt();
		int[] nums = new int[size];
		for (int i = 0; i < size; i++) {
			nums[i] = sc.nextInt();
		}
		int len = removeDuplicates(nums);
		int[] result = new int[len];
		for (int i = 0; i < len; i++) {
			result[i] = nums[i];
		}
		System.out.println(Arrays.toString(result));


	}
	
	public static int removeDuplicates(int[] nums) {
		int size = nums.length;
		if (size == 0) {
			return 0;
		}
		int i = 0;
        for (int j = 1; j < size; j++) {
        	if (nums[i] != nums[j]) {
        		nums[++i] =  nums[j];
        	}
        }
        return i+1;
    }

}
