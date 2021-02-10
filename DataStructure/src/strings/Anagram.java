package strings;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Anagram {

    // Complete the anagram function below.
    static int anagram(String s) {
    	int len = s.length();
    	if (len % 2 != 0) {
    		return -1;
    	}
    	int changes = 0;
    	String s1 = s.substring(0, len/2);
    	String s2= s.substring(len/2);
    	Map<Character, Integer> s1Map = new HashMap<Character, Integer>();
    	Map<Character, Integer> s2Map = new HashMap<Character, Integer>();
    	int count;
    	for (char c : s1.toCharArray()) {
    		count = s1Map.getOrDefault(c, 0);
    		s1Map.put(c, ++count);
    	}
    	for (char c : s2.toCharArray()) {
    		if (s1Map.containsKey(c)) {
    			count = s1Map.get(c);
    			s1Map.put(c, --count);
    		} else {
    			count = s2Map.getOrDefault(c, 0);
    			s2Map.put(c, ++count);
    		}
    	}
    	Set<Character> s1Key = s1Map.keySet();
    	Set<Character> s2Key = s1Map.keySet();
    	for (char c : s1Key) {
    		count = s1Map.get(c);
    		if (count < 0) {
    			changes += Math.abs(count);
    		}
    	}
    	for (char c : s2Key) {
    		count = s1Map.get(c);
    		changes += count;
    	}
    	return changes;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            String s = scanner.nextLine();

            int result = anagram(s);

            bufferedWriter.write(String.valueOf(result));
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}

