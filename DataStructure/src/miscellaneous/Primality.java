package miscellaneous;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Primality {

    // Complete the primality function below.
    static String primality(int n) {
    	if (n == 1) {
    		System.out.println("Not prime");
    		return "Not prime";
    	}
    	for (int i = 2; i <= n/2; i++) {
    		if (n % i == 0) {
    			System.out.println("Not prime");
    			return "Not prime";
    		}
    	}
    	System.out.println("Prime");
    	return "Prime";

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("D:/HackerRank/text.txt"));

        int p = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int pItr = 0; pItr < p; pItr++) {
            int n = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            String result = primality(n);

            bufferedWriter.write(result);
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
