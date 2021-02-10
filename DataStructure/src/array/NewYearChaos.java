package array;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class NewYearChaos {

    // Complete the minimumBribes function below.
    static void minimumBribes(int[] q) {
    	int size = q.length;
    	int bribes = 0;
    	for (int i = size-1; i >= 0; i--) {
    		if (q[i] != i+1) {
    			if (q[i-1] == i+1) {
    				bribes++;
    				swap(q, i-1, i);
    			} else if (q[i-2] == i+1) {
    				bribes = bribes + 2;
    				swap(q, i-2, i-1);
    				swap(q, i-1, i);
    			} else {
    				System.out.println("Too chaotic");
    				return;
    			}
    		}
    	}
    	System.out.println(bribes);

    }

	private static void swap(int[] q, int i, int j) {
		int temp = q[j];
		q[j] = q[i];
		q[i] = temp;
	}

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            int n = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int[] q = new int[n];

            String[] qItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int i = 0; i < n; i++) {
                int qItem = Integer.parseInt(qItems[i]);
                q[i] = qItem;
            }

            minimumBribes(q);
        }

        scanner.close();
    }
}
