package dictionariesAndHashMap;

public class SingleNumber {
    public static void main(String[] args) {

    }

    public int singleNumber(int[] nums) {
        int a = 0;
        for (int i = 0; i < nums.length; i++) {
            a ^= nums[i];
        }
        return a;
    }
}
