package dictionariesAndHashMap;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public class FirstUniqChar {
    public static void main(String[] args) {

    }

    public static int firstUniqChar(String s) {
        Map<Character, Integer> map = new LinkedHashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            int count = map.getOrDefault(c, 0);
            map.put(c, count+1);
        }
        Set<Character> keys = map.keySet();
        for (char key : keys) {
            if (map.get(key) == 1)
                return s.indexOf(key);
        }
        return -1;
    }
}
