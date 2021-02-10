package math;

import java.util.HashMap;
import java.util.Map;

public class RomanToInt {
    public static void main(String[] args) {

    }

    public int romanToInt(String s) {
        Map<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
        int num = 0;
        int len = s.length();
        for (int i = 0; i < len; i++) {
            if (i+1 < len && (map.get(s.charAt(i)) > map.get(s.charAt(i+1)))) {
                num += map.get(s.charAt(i));
            } else if (i+1 < len && (map.get(s.charAt(i)) < map.get(s.charAt(i+1)))){
                num += map.get(s.charAt(i+1)) - map.get(s.charAt(i));
                i++;
            } else {
                num += map.get(s.charAt(i));
            }
        }
        return num;
    }
}
