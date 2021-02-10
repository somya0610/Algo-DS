package recursion;

import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class RecursiveDigitSum {


    // Complete the superDigit function below.
    static int superDigit(String n, int k) {
        Map<Integer, BigInteger> map = new HashMap<>();
        for (int i = 0; i < n.length(); i++) {
            Integer num = Integer.valueOf(n.substring(i, i+1));
            BigInteger sum = map.getOrDefault(num, BigInteger.valueOf(0));
            map.put(num, sum.add(BigInteger.valueOf(num)));
        }

        BigInteger sum = BigInteger.valueOf(0);
        Set<Integer> set = map.keySet();
        for (Integer i : set) {
            sum = sum.add(map.get(i));
        }

        sum = sum.multiply(BigInteger.valueOf(k));
        sum = recursiveSum(sum);
        return Integer.valueOf(sum.toString());

    }

    private static BigInteger recursiveSum(BigInteger num) {
        BigInteger sum = BigInteger.valueOf(0);
        while (!num.equals(BigInteger.valueOf(0))) {
            sum = sum.add(num.mod(BigInteger.valueOf(10)));
            num = num.divide(BigInteger.valueOf(10));
        }
        if (!sum.divide(BigInteger.valueOf(10)).equals(BigInteger.valueOf(0))) {
            sum = recursiveSum(sum);
        }
        return sum;

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        int result = superDigit("4757362", 10000);
        System.out.println(result);
    }
}

