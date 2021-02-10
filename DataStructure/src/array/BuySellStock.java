package array;

import java.util.Scanner;

public class BuySellStock {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int size = sc.nextInt();
		int[] prices = new int[size];
		for (int i = 0; i < size; i++) {
			prices[i] = sc.nextInt();
		}
		int profit = maxProfit(prices);
		System.out.println(profit);


	}

	public static int maxProfit(int[] prices) {
		int size = prices.length;
		int maxProfit = 0;
		int buyCost = Integer.MAX_VALUE;
		int sell = Integer.MIN_VALUE;
		for (int i = 0; i < size; i++) {
			if(prices[i] < buyCost) {
				buyCost = prices[i];
			} else {
				maxProfit = Math.max(maxProfit, prices[i]-buyCost);
			}
		}
		return maxProfit;
	}

	//Leetcode
	public static int maxProfit1(int[] prices) {
		int total_profit = 0;
		int max_profit = 0;
		int min = Integer.MAX_VALUE;
		int size = prices.length;
		for(int i = 0; i < size; i++) {
			while (i < size && min > prices[i]) {
				min = prices[i++];
			}
			if (i < size) {
				int profit = prices[i] - min;
				while (profit > max_profit) {
					max_profit = profit;
					if (++i < size) {
						profit = prices[i] - min;
					}
				}
				total_profit += max_profit;
				i--;
				min = Integer.MAX_VALUE;
				max_profit = 0;
			}
		}
		return total_profit;
	}

}
