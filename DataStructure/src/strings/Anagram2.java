package strings;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Anagram2 {


    // Complete the makeAnagram function below.
    static int makeAnagram(String a, String b) {
        Map<Character, Integer> map = new HashMap<>();
        int count;
        for (int i = 0; i < a.length(); i++) {
            char c = a.charAt(i);
            count = map.getOrDefault(c, 0);
            map.put(c, count+1);
        }
        int changes = 0;
        for (int i = 0; i < b.length(); i++) {
            char c = b.charAt(i);
            if (map.containsKey(c)) {
                count = map.get(c);
                count--;
                if (count == 0) {
                    map.remove(c);
                } else {
                    map.put(c, count);
                }
            } else {
                changes++;
            }
        }
        Set<Character> keySet = map.keySet();

        for (Character c : keySet) {
            changes += map.get(c);
        }
        return changes;

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        String a = scanner.nextLine();

        String b = scanner.nextLine();

        int res = makeAnagram(a, b);

        scanner.close();
    }
}

