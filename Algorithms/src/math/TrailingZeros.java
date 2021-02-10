package math;

import java.math.BigInteger;

public class TrailingZeros {
    public static void main(String[] args) {
        System.out.println(trailingZeroes(13));
    }

    public static int trailingZeroes(int n) {
        int count = 0;
        /*if (n == 0)
            return count;
        BigInteger fact = BigInteger.ONE;
        for (int i = 2; i <= n; i++) {
            fact = fact.multiply(BigInteger.valueOf(i));
        }
        BigInteger mod = BigInteger.ZERO;
        while (mod.equals(0)) {
            mod = fact.mod(BigInteger.valueOf(10));
            if (mod.equals(0))
                count++;
            else
                break;
            fact = fact.divide(BigInteger.valueOf(10));
        }*/
        if (n < 5)
            return count;
        int i = 5;
        while (i <= n) {
            count += n/i;
            i *= 5;
        }
        return count;
    }
}
