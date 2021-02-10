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

public class FrequencyQueries {

    // Complete the freqQuery function below.
    static List<Integer> freqQuery(List<List<Integer>> queries) {
    	List<Integer> list = new ArrayList<Integer>();
    	int[] frequency = new int[queries.size()+1];
    	int count;
    	Map<Integer, Integer> map = new HashMap<Integer, Integer>();
    	for (List<Integer> q : queries) {
    		int opr = q.get(0);
    		int data = q.get(1);
    		switch (opr) {
    			case 1:
    				count = map.getOrDefault(data, 0);
        			map.put(data, ++count);
					if (frequency[count - 1] != 0) {
						frequency[count - 1] = frequency[count - 1] - 1;
					}
        			//frequency[count-1] = frequency[count-1] - 1;
        			frequency[count] = frequency[count] + 1;
        			break;
    			case 2:
    				count = map.getOrDefault(data, 0);
        			if (count == 0)
        				break;
        			if (count == 1) {
        				map.remove(data);
        				--count;
        			} else {
        				map.put(data, --count);
        			}
					/*
					 * if (frequency[count+1] != 0) { frequency[count+1] = frequency[count+1] - 1; }
					 */
        			frequency[count+1] = frequency[count+1] - 1;
        			frequency[count] = frequency[count] + 1;
        			break;
    			case 3:
    				if (data > frequency.length) {
    					list.add(0);
    				} else {
    					list.add(frequency[data] > 0 ? 1 : 0);
    					break;
    				}
    		}
    	}
    	return list;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("D:/HackerRank/text.txt"));

        int q = Integer.parseInt(bufferedReader.readLine().trim());

        List<List<Integer>> queries = new ArrayList<>();

        IntStream.range(0, q).forEach(i -> {
            try {
                queries.add(
                    Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                        .map(Integer::parseInt)
                        .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        List<Integer> ans = freqQuery(queries);

        bufferedWriter.write(
            ans.stream()
                .map(Object::toString)
                .collect(joining("\n"))
            + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }
}
