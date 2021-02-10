package strings;

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

public class SuperReducedString {

    // Complete the superReducedString function below.
    static String superReducedString(String s) {
    	int len = s.length();
    	if (len <= 1) {
    		return s;
    	}
    	int pntr1 = 0;
    	int pntr2 = 1;
    	for (pntr1 = 0; pntr1 < len-1; pntr1++) {
    		char c1 = s.charAt(pntr1);
    		char c2 = s.charAt(pntr2);
    		if (c1 == c2) {
    			s = s.replaceFirst(String.valueOf(c1)+String.valueOf(c2), "");
    			if (pntr1 == 0) {
    				pntr1--;
    			} else {
    				pntr1--;
        			pntr2 = pntr1 + 1;
    			}
    			len = s.length();
    		} else {
    			pntr2++;
    		}
    	}
    	System.out.println(s);
    	return s;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("D:/HackerRank/text.txt"));

        String s = bufferedReader.readLine();

        String result = superReducedString(s);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
