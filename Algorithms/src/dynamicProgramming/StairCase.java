package dynamicProgramming;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class StairCase {

    // Complete the stepPerms function below.
    static int stepPerms(int n) {

        if (n <=1)
            return 1;
        if (n == 2)
            return 2;

        int[] result = new int[n+1];
        result[0] = 1;
        result[1] = 1;
        result[2] = 2;

        for (int i = 3; i <=n; i++) {
            result[i] = result[i-1] + result[i-2] + result[i-3];
        }
        return result[n];

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int s = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int sItr = 0; sItr < s; sItr++) {
            int n = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int res = stepPerms(n);

            bufferedWriter.write(String.valueOf(res));
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}

