package strings;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class CommonChild {

    // Complete the commonChild function below.
    static int commonChild(String s1, String s2) {
        int[][] lca = new int[2][s1.length()+1];
        for (int i = 1 ; i <= s2.length(); i++) {
            for (int j = 1; j <= s1.length(); j++) {
                if (s2.charAt(i-1) == s1.charAt(j-1))
                    lca[1][j] = 1 + lca[0][j-1];
                else
                    lca[1][j] = Math.max(lca[1][j-1], lca[0][j]);
            }
            lca[0] = Arrays.copyOf(lca[1], s1.length()+1);
        }
        return lca[1][s1.length()];

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        String s1 = scanner.nextLine();

        String s2 = scanner.nextLine();

        int result = commonChild(s1, s2);

        scanner.close();
    }
}

