package strings;

public class ImplementSubstring {
    public static void main(String[] args) {

    }

    public int strStr(String haystack, String needle) {
        if (needle.isEmpty())
            return 0;
        int len1 = haystack.length();
        int len2 = needle.length();
        int i = 0, j = 0;
        int length = 0;
        int index = -1;
        if (len1 >= len2) {
            while (i < len1 && j < len2) {
                if (haystack.charAt(i) == needle.charAt(j)) {
                    length++;
                    i++;
                    j++;
                } else {
                    if (length > 0) {
                        i = i - j + 1;
                        j = 0;
                        length = 0;
                    } else {
                        i++;
                    }
                }
                if (length == len2) {
                    index = i - len2;
                    break;
                }
            }
        }
        return index;
    }
}
