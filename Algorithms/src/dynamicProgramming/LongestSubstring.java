package dynamicProgramming;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class LongestSubstring {

	public static void main(String[] args) {
		Scanner sc  = new Scanner(System.in);
		String s = sc.nextLine();
		int len = lengthOfLongestSubstring(s);
		System.out.println(len);

	}
	
	public static int lengthOfLongestSubstring(String s) {
		int maxLen = 0;
		int sLen = s.length();
		if (sLen == 0) {
			return 0;
		}
		int start = 0;
		int end = 1;
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		map.put(s.charAt(start), 0);
		while (end < sLen) {
			char c = s.charAt(end);
			if(map.containsKey(c)) {
				start = Math.max(map.get(c)+1, start);
			}
			map.put(c, end++);
			maxLen = Math.max(maxLen, end-start);
		}
		return maxLen;
        
    }

}
