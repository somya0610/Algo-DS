package array;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class MinimumSwaps2 {

    // Complete the minimumSwaps function below.
    static int minimumSwaps(int[] arr) {
    	int size = arr.length;
    	int swap = 0;
    	for (int i = 0; i < size; i++) {
    		if (i+1 != arr[i]) {
    			int t = i+1;
    			while (t < size) {
    				if (arr[t] == i+1) {
    					int temp = arr[t];
    					arr[t] = arr[i];
    					arr[i] = temp;
    					swap++;
    					break;
    				}
    				t++;
    			}
    		}
    	}
    	return swap;

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("D:/HackerRank/text.txt"));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] arr = new int[n];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }

        int res = minimumSwaps(arr);

        bufferedWriter.write(String.valueOf(res));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}

