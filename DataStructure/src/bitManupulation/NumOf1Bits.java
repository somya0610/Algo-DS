package bitManupulation;

public class NumOf1Bits {
    public static void main(String[] args) {
        System.out.println(hammingWeight(00000000000000000000000000001011));
    }

    public static int hammingWeight(int n) {
        int count = 0;
        for(int i = 0; i < 32; i++){
            if ((n & 1) == 1) count++;
            n >>= 1;
        }
        return count;

    }
}
