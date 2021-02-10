package strings;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class SherlockValidString {

    // Complete the isValid function below.
    static String isValid(String s) {
        int[] numbers = new int[s.length()+1];
        Map<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            int count = map.getOrDefault(c, 0);
            map.put(c, count+1);
        }
        Set<Character> keySet = map.keySet();
        int max = 0;
        int index = 0;
        for (char c : keySet) {
            numbers[map.get(c)] = numbers[map.get(c)]+1;
            if (max < numbers[map.get(c)]) {
                max = numbers[map.get(c)];
                index = map.get(c);
            }
        }
        int remaining = map.size() - max;
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] > 0 && i != index) {
                if ((remaining == 1 && i - index > 1) || remaining > 1)
                    return "NO";
            }
        }
        return "YES";
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        String s = scanner.nextLine();

        String result = isValid(s);

        scanner.close();
    }
}

