package sorting;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class CountInversions {


    private static int count;
    // Complete the countInversions function below.
    static long countInversions(int[] arr) {
        count = 0;
        mergeSort(arr,0, arr.length-1);
        return count;
    }

    private static void mergeSort(int[] arr, int start, int end) {
        if (start >= end) {
            return;
        }
        int mid = start + (end - start) / 2;
        mergeSort(arr, start, mid);
        mergeSort(arr, mid+1, end);
        merge(arr, start, mid, end);
    }

    private static void merge(int[] arr, int start, int mid, int end) {
        int left = start;
        int right = mid+1;
        int temp[] = new int[arr.length];
        int i = 0;

        while (left <= mid && right <= end) {
            if (arr[left] <= arr[right]) {
                temp[i++] = arr[left++];
            } else {
                count += mid+1 - left;
                temp[i++] = arr[right++];
            }
        }
        while (left <= mid) {
            temp[i++] = arr[left++];
        }
        while (right <= end) {
            temp[i++] = arr[right++];
        }

        int x = 0;
        for (i = start; i <= end; i++) {
            arr[i] = temp[x++];
        }

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            int n = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int[] arr = new int[n];

            String[] arrItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int i = 0; i < n; i++) {
                int arrItem = Integer.parseInt(arrItems[i]);
                arr[i] = arrItem;
            }

            long result = countInversions(arr);

        }


        scanner.close();
    }
}

