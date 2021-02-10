package strings;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class SpecialString {

    // Complete the substrCount function below.
    static long substrCount(int n, String s) {
        int count = s.length();

        for (int i = 0; i < s.length()-1; i++) {
            char c = s.charAt(i);
            int mid = -1;
            for (int j = i+1; j < s.length(); j++) {
                char temp = s.charAt(j);
                int len = 1;
                while (temp == c && j < s.length()) {
                    len++;
                    j++;
                    if (j < s.length())
                        temp = s.charAt(j);
                }
                count += (len-1);
                boolean exit = false;
                if (temp != c) {
                    mid = j;
                    if (s.length() - mid >= len) {
                        int tempLen = 0;
                        for (int k = mid + 1; k < s.length(); k++) {
                            if (s.charAt(k) == c) {
                                tempLen++;
                                if (tempLen == len) {
                                    count++;
                                    mid = -1;
                                    exit = true;
                                    break;
                                }
                            } else {
                                mid = -1;
                                exit = true;
                                break;
                            }
                        }
                        if (exit)
                            break;;
                    }
                }
            }
        }
        return count;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        String s = scanner.nextLine();

        long result = substrCount(n, s);

        scanner.close();
    }
}

