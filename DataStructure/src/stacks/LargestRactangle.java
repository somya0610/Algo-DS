package stacks;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class LargestRactangle {

    // Complete the largestRectangle function below.
    static long largestRectangle(int[] h) {
        int maxArea = 0;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < h.length; i++) {
            stack.push(h[i]);
            int left = i;
            int right = i + 1;
            int width = 0;
            while (left >= 0 && h[left] >= stack.peek()) {
                width++;
                left--;
            }
            while (right < h.length && h[right] >= stack.peek()) {
                width++;
                right++;
            }
            maxArea = Math.max(maxArea, width * stack.peek());
        }
        return maxArea;

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] h = new int[n];

        String[] hItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int hItem = Integer.parseInt(hItems[i]);
            h[i] = hItem;
        }

        long result = largestRectangle(h);

        scanner.close();
    }
}

