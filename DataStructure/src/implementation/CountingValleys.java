package implementation;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class CountingValleys {

    // Complete the countingValleys function below.
    static int countingValleys(int n, String s) {
    	int count = 0;
    	int sum = 0;
    	boolean valley = false;
    	int len = s.length();
    	for (int i = 0 ; i < len; i++) {
    		char c = s.charAt(i);
    		if (c == 'U') {
    			sum++;
    		} else {
    			sum--;
    		}
    		if (sum < 0 && !valley) {
    			count++;
    			valley = true;
    		} else if (sum == 0) {
    			valley = false;
    		}
    	}
    	return count;

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("D:/HackerRank/text.txt"));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        String s = scanner.nextLine();

        int result = countingValleys(n, s);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}

