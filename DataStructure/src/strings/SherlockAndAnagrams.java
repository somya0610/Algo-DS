package strings;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class SherlockAndAnagrams {

    // Complete the sherlockAndAnagrams function below.
    static int sherlockAndAnagrams(String s) {
    	int anagrams = 0;
    	int count;
    	int len = s.length();
    	for (int i = 0; i < len; i++) {
    		Map<List<Integer>, Integer> map = new HashMap<List<Integer>, Integer>();
    		String sub;
    		for (int j = i+1; j < len; j++) {
    			sub = s.substring(i, j);
    			List<Integer> list = new ArrayList<Integer>(Collections.nCopies(123, 0));
    			Collections.fill(list, 0);
    			for (int k = 0; k < (j-i); k++) {
    				int c = sub.charAt(k);
    				list.set(c, (list.get(c))+1);
    			}
    			map.put(list, 0);
    		}
    		for (int j = i+1; j < len; j++) {
    			for (int k = j+1; k <= len; k++) {
    				sub = s.substring(j, k);
        			List<Integer> list = new ArrayList<Integer>(Collections.nCopies(123, 0));
        			Collections.fill(list, 0);
        			for (int x = 0; x < (k-j); x++) {
        				int c = sub.charAt(x);
        				list.set(c, list.get(c)+1);
        			}
        			if (map.containsKey(list)) {
        				anagrams++;
        			}
    			}
    		}
    	}
    	return anagrams;

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("D:/HackerRank/text.txt"));

        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            String s = scanner.nextLine();

            int result = sherlockAndAnagrams(s);

            bufferedWriter.write(String.valueOf(result));
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
