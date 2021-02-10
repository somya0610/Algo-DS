package strings;

public class ReverseString {

    public static void main(String[] args) {
        char[] s = {'h','e','l','l','o'};
        reverseString(s);
        System.out.println(s);
    }

    public static void reverseString(char[] s) {
        int size = s.length;
        for (int i = 0; i < size/2; i++) {
            char c = s[i];
            s[i] = s[size-1-i];
            s[size-1-i] = c;
        }

    }
}
