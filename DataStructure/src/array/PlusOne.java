package array;

public class PlusOne {
    public static void main(String[] args) {
        int[] digits = {1,2,3};
        digits = plusOne(digits);
    }

    public static int[] plusOne(int[] digits) {
        int n = digits.length;
        int[] result = new int[n+1];
        int carry = 1;
        int sum;
        int mod;
        for (int i = n-1; i >= 0; i--) {
            sum = digits[i] + carry;
            mod = sum % 10;
            if (mod != 0) {
                digits[i] = sum;
                return digits;
            }
            digits[i] = 0;
            if (i == 0) {
                result[i] = carry;
                for (int j = 0; j < n; j++) {
                    result[j+1] = digits[j];
                }
                digits = result;
            }
        }
        return digits;
    }
}
