package strings;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class MakingAnagrams {

    // Complete the makingAnagrams function below.
    static int makingAnagrams(String s1, String s2) {
        Map<Character, Integer> mapS1 = new HashMap<Character, Integer>();
        Map<Character, Integer> mapS2 = new HashMap<Character, Integer>();
        int count;
        int delete = 0;
        for (char c : s1.toCharArray()) {
        	count = mapS1.getOrDefault(c, 0);
        	mapS1.put(c, ++count);
        }
        for (char c : s2.toCharArray()) {
        	if (mapS1.containsKey(c)) {
        		count = mapS1.get(c);
        		mapS1.put(c, --count);
        	} else {
        		count = mapS2.getOrDefault(c, 0);
            	mapS2.put(c, ++count);
        	}
        }
       Set<Character> setS1 = mapS1.keySet();
       Set<Character> setS2 = mapS2.keySet();
       for (char c : setS1) {
    	   delete += Math.abs(mapS1.get(c));
       }
       for (char c : setS2) {
    	   delete += Math.abs(mapS2.get(c));
       }
       return delete;

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s1 = scanner.nextLine();

        String s2 = scanner.nextLine();

        int result = makingAnagrams(s1, s2);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
