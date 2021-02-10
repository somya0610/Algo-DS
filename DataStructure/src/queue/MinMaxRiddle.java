package queue;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class MinMaxRiddle {

    // Complete the riddle function below.
    static long[] riddle(long[] arr) {
        int n=arr.length;
        Stack<Integer> st=new Stack<>();
        int[] left=new int[n+1];
        int[] right=new int[n+1];
        for(int i=0;i<n;i++){
            left[i]=-1;
            right[i]=n;
        }
        for(int i=0;i<n;i++){
            while(!st.isEmpty() && arr[st.peek()]>=arr[i])
                st.pop();

            if(!st.isEmpty())
                left[i]=st.peek();

            st.push(i);
        }
        while(!st.isEmpty()){
            st.pop();
        }

        for(int i=n-1;i>=0;i--){
            while(!st.isEmpty() && arr[st.peek()]>=arr[i])
                st.pop();

            if(!st.isEmpty())
                right[i]=st.peek();

            st.push(i);
        }
        long ans[] = new long[n+1];
        for (int i=0; i<=n; i++) {
            ans[i] = 0;
        }
        for (int i=0; i<n; i++)
        {
            int len = right[i] - left[i] - 1;
            ans[len] = Math.max(ans[len], arr[i]);
        }
        for (int i=n-1; i>=1; i--) {
            ans[i] = Math.max(ans[i], ans[i+1]);
        }
        long[] res=new long[n];
        for (int i=1; i<=n; i++) {
            res[i-1]=ans[i];
        }
        return res;


        // complete this function
        /*long[] result = new long[arr.length];
        PriorityQueue<Long> minHeap = new PriorityQueue<>();
        PriorityQueue<Long> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
        long windowSize = 1;
        int x = 0;
        while (windowSize <= arr.length) {
            for (int i = 0; i < arr.length-windowSize+1; i++) {
                if (i == 0) {
                    int temp = 0;
                    while (temp < windowSize)
                        minHeap.add(arr[temp++]);
                } else {
                    int j = (int) (i+windowSize-1);
                    minHeap.add(arr[j]);
                }

                maxHeap.add(minHeap.peek());
                minHeap.remove(arr[i]);
            }
            result[x++] = maxHeap.peek();
            minHeap.clear();
            maxHeap.clear();
            windowSize++;
        }
        return result;*/
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        long[] arr = new long[n];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            long arrItem = Long.parseLong(arrItems[i]);
            arr[i] = arrItem;
        }

        long[] res = riddle(arr);

        scanner.close();
    }
}

