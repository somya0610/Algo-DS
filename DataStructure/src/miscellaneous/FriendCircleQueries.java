package miscellaneous;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class FriendCircleQueries {

    // Complete the maxCircle function below.
    static int[] maxCircle(int[][] queries) {
    	int size = queries.length;
    	int[] maxArr = new int[size];
    	int max = 2;
    	Map<Integer, Set<Integer>> map = new HashMap<Integer, Set<Integer>>();
    	for (int i = 0; i < size; i++) {
    		Set<Integer> set;
    		int num1 = queries[i][0];
    		int num2 = queries[i][1];
    		if (map.isEmpty()) {
    			set = new HashSet<Integer>();
    			set.add(num1);
    			set.add(num2);
    			map.put(num1, set);
    			map.put(num2, set);
    			maxArr[i] = max;
    			continue;
    		}
    		if (map.containsKey(num1) || map.containsKey(num2)) {
    			Set<Integer> list1 = map.get(num1);
    			Set<Integer> list2 = map.get(num2);
    			if (list1.isEmpty()) {
    				fillList(list2, num1, num2, map);
    				max = map.get(num2).size() > max ? map.get(num2).size() : max;
    				map.put(num1, map.get(num2));
    			} else if (list2.isEmpty()) {
    				fillList(list1, num1, num2, map);
    				max = map.get(num1).size() > max ? map.get(num1).size() : max;
    				map.put(num2, map.get(num1));
    			} else {
    				fillList(list1, list2, num1, num2, map);
    			}
    			Set<Integer> keys = map.keySet();
    			
    		} else {
    			set = new HashSet<Integer>();
    			set.add(num1);
    			set.add(num2);
    			map.put(num1, set);
    			map.put(num2, set);
    			max = set.size() > max ? set.size() : max;
    		}
    		maxArr[i] = max;
    	}
    	return maxArr;

    }

	private static void fillList(Set<Integer> list1, Set<Integer> list2, int num1, int num2,
			Map<Integer, Set<Integer>> map) {
		// TODO Auto-generated method stub
		
	}

	private static void fillList(Set<Integer> list, int num1, int num2, Map<Integer, Set<Integer>> map) {
		for (Integer num : list) {
			if (num != num1) {
				Set<Integer> set = map.get(num);
				set.add(num2);
				map.put(num, set);
			}
			if (num != num2) {
				Set<Integer> set = map.get(num);
				set.add(num2);
				map.put(num, set);
			}
		}
	}

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("D:/HackerRank/text.txt"));

        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[][] queries = new int[q][2];

        for (int i = 0; i < q; i++) {
            String[] queriesRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < 2; j++) {
                int queriesItem = Integer.parseInt(queriesRowItems[j]);
                queries[i][j] = queriesItem;
            }
        }

        int[] ans = maxCircle(queries);

        for (int i = 0; i < ans.length; i++) {
            bufferedWriter.write(String.valueOf(ans[i]));

            if (i != ans.length - 1) {
                bufferedWriter.write("\n");
            }
        }

        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
