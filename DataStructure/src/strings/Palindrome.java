package strings;

public class Palindrome {
    public static void main(String[] args) {
        System.out.println(isPalindrome("A man, a plan, a canal: Panama"));
    }

    public static boolean isPalindrome(String s) {
        if (s == null || s.length() == 0)
            return true;

        int start = 0;
        int end = s.length()-1;

        while (start <= end) {
            if (!(Character.isLetterOrDigit(s.charAt(start)))){
                start++;
                continue;
            }
            if (!(Character.isLetterOrDigit(s.charAt(end)))){
                end--;
                continue;
            }

            char c1 = s.charAt(start);
            if (!Character.isLowerCase(c1))
                c1 = Character.toLowerCase(c1);
            char c2 = s.charAt(end);
            if (!Character.isLowerCase(c2))
                c2 = Character.toLowerCase(c2);

            if (c1 != c2)
                return false;

            start++;
            end--;
        }
        return true;

    }
}
