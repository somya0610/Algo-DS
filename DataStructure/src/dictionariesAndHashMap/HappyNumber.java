package dictionariesAndHashMap;

import java.util.HashSet;
import java.util.Set;

public class HappyNumber {
    public static void main(String[] args) {
        System.out.println(isHappy(1111111));
    }

    public static boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();
        int mod;
        int sum;
        while (n != 1) {
            sum = 0;
            while (n != 0) {
                mod = n % 10;
                sum += (mod*mod);
                n = n/10;
            }
            n = sum;
            if (set.contains(n))
                return false;
            set.add(n);
        }
        return true;
    }
}
