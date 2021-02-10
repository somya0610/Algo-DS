package dictionariesAndHashMap;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class RansomNote {

    // Complete the checkMagazine function below.
    static void checkMagazine(String[] magazine, String[] note) {
    	Map<String, Integer> magMap =  new HashMap<String, Integer>();
    	int count = 0;
    	boolean contains = true;
    	for (String s: magazine) {
    		count = magMap.getOrDefault(s, 0);
    		magMap.put(s, ++count);
    	}
    	for (String s: note) {
    		if (magMap.containsKey(s)) {
    			count = magMap.get(s);
    			if (count == 0) {
        			contains = false;
        			break;
        		}
    			magMap.put(s, --count);
    		} else {
    			contains = false;
    			break;
    		}
    	}
    	if (contains) {
    		System.out.println("Yes");
    	} else {
    		System.out.println("No");
    	}

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        String[] mn = scanner.nextLine().split(" ");

        int m = Integer.parseInt(mn[0]);

        int n = Integer.parseInt(mn[1]);

        String[] magazine = new String[m];

        String[] magazineItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < m; i++) {
            String magazineItem = magazineItems[i];
            magazine[i] = magazineItem;
        }

        String[] note = new String[n];

        String[] noteItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            String noteItem = noteItems[i];
            note[i] = noteItem;
        }

        checkMagazine(magazine, note);

        scanner.close();
    }
}
