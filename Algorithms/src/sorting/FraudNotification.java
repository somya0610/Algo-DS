package sorting;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class FraudNotification {


        // Complete the activityNotifications function below.
        static int activityNotifications(int[] expenditure, int d) {
            int notices = 0;
            int median;
            boolean odd = d%2==0 ? false:true;
            PriorityQueue<Integer> minHeap = new PriorityQueue<>();
            PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

            for (int i = 0; i < d; i++) {
                minHeap.add(expenditure[i]);
            }
            for (int i = 0; i < d/2; i++) {
                maxHeap.add(minHeap.remove());
            }
            for (int i = d; i < expenditure.length; i++) {
                if (odd) {
                    median = minHeap.peek() * 2;
                } else {
                    median = minHeap.peek() + maxHeap.peek();
                }
                if (expenditure[i] >= median)
                    notices++;
                if (!minHeap.remove(expenditure[i-d])) {
                    maxHeap.remove(expenditure[i - d]);
                    maxHeap.add(minHeap.poll());
                }
                if (expenditure[i] > median/2) {
                    minHeap.add(expenditure[i]);
                } else {
                    minHeap.add(maxHeap.poll());
                    maxHeap.add(expenditure[i]);
                }
            }
            return notices;

        }

        private static final Scanner scanner = new Scanner(System.in);

        public static void main(String[] args) throws IOException {

            String[] nd = scanner.nextLine().split(" ");

            int n = Integer.parseInt(nd[0]);

            int d = Integer.parseInt(nd[1]);

            int[] expenditure = new int[n];

            String[] expenditureItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int i = 0; i < n; i++) {
                int expenditureItem = Integer.parseInt(expenditureItems[i]);
                expenditure[i] = expenditureItem;
            }

            int result = activityNotifications(expenditure, d);

            scanner.close();
        }
    }

