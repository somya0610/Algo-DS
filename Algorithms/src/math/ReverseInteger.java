package math;

public class ReverseInteger {
    public static void main(String[] args) {

    }

    public int reverse(int x) {
        if (x == Integer.MIN_VALUE || x == Integer.MAX_VALUE)
            return 0;
        boolean isNeg = false;
        long reverse = 0;
        if (x < 0)
            isNeg = true;
        int abs = Math.abs(x);
        do {
            reverse = (reverse * 10) + (abs % 10);
            abs = abs / 10;
        } while (abs > 0);
        if (isNeg)
            reverse = -reverse;
        if ((reverse < 0 && reverse < Integer.MIN_VALUE)
                || reverse > 0 && reverse > Integer.MAX_VALUE) {
            return 0;
        }
        return (int) reverse;
    }
}
