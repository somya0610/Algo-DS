package bitManupulation;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class MaximunXor {

    // Complete the maxXor function below.
    static int[] maxXor(int[] arr, int[] queries) {
        // solve here
        int[] result = new int[queries.length];
        Map<Integer, Integer> mapQ = new HashMap<>();
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < arr.length; i++) {
            set.add(arr[i]);
        }

        for(int i = 0; i < queries.length; i++) {
            int max = Integer.MIN_VALUE;
            if (!mapQ.containsKey(queries[i])) {
                Iterator<Integer> itr = set.iterator();
                while (itr.hasNext()) {
                    max = Math.max(max, queries[i] ^ itr.next());
                }
                result[i] = max;
                mapQ.put(queries[i], max);
            } else {
                result[i] = mapQ.get(queries[i]);
            }

        }
        return result;

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] arr = new int[n];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }

        int m = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] queries = new int[m];

        for (int i = 0; i < m; i++) {
            int queriesItem = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
            queries[i] = queriesItem;
        }

        int[] result = maxXor(arr, queries);

        for (int i = 0; i < result.length; i++) {
            bufferedWriter.write(String.valueOf(result[i]));

            if (i != result.length - 1) {
                bufferedWriter.write("\n");
            }
        }

        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }

}
