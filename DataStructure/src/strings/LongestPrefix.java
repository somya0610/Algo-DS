package strings;

public class LongestPrefix {
    public static void main(String[] args) {
        String[] strs = {"flower","flow","flight"};
        System.out.println(longestCommonPrefix(strs));
    }

    public static String longestCommonPrefix(String[] strs) {
        StringBuilder sb = new StringBuilder();
        int n = strs.length;
        if (n == 0) {
            return sb.toString();
        }
        if (n == 1)
            return strs[0];
        String s1 = strs[0];
        for (int i = 1; i < n; i++) {
            String s2 = strs[i];
            int x = 0, y = 0;
            while (x < s1.length() && y < s2.length()) {
                if (s1.charAt(x) == s2.charAt(y)) {
                    sb.append(s1.charAt(x));
                } else {
                    break;
                }
                x++;
                y++;
            }
            if (sb.length() == 0)
                break;
            s1 = sb.toString();

        }
        return sb.toString();
    }
}
