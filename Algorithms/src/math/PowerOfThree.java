package math;

public class PowerOfThree {
    public static void main(String[] args) {

    }

    public boolean isPowerOfThree(int n) {
        if (n == 0)
            return false;
        while (n != 1) {
            if (n != 1 && n % 3 != 0)
                return false;
            n = n/3;
        }
        return true;
    }
}
