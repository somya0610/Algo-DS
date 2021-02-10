package dictionariesAndHashMap;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class CountTriplets {

    // Complete the countTriplets function below.
    static long countTriplets(List<Long> arr, long r) {
    	int size = arr.size();
    	long count =0;
    	long triplet = 0;
    	Map<Long, Long> rightMap = new HashMap<Long, Long>();
    	Map<Long, Long> leftMap = new HashMap<Long, Long>();
    	for (int i = 0; i < size; i++) {
    		count = rightMap.getOrDefault(arr.get(i), 0l);
    		rightMap.put(arr.get(i), ++count);
    	}
    	long num;
    	long num0;
		long num2;
    	for (int i = 0; i < size; i++) {
    		num = arr.get(i);
    		count = rightMap.get(num);
    		rightMap.put(num, --count);
    		if (!(leftMap.isEmpty() && rightMap.isEmpty())) {
    			num0 = num/r;
    			num2 = num *r;
    			if (num % r == 0 && leftMap.containsKey(num0) && rightMap.containsKey(num2)) {
    				triplet += (leftMap.get(num0) * rightMap.get(num2));
    			}
    		}
    		count = leftMap.getOrDefault(num, 0l);
    		leftMap.put(num, ++count);
    	}
    	return triplet;

    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nr = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(nr[0]);

        long r = Long.parseLong(nr[1]);

        List<Long> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Long::parseLong)
            .collect(toList());

        long ans = countTriplets(arr, r);

        bufferedWriter.write(String.valueOf(ans));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
