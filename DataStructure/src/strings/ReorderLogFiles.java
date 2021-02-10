package strings;

import com.sun.deploy.util.StringUtils;

import java.util.*;

public class ReorderLogFiles {
    public static void main(String[] args) {

    }

    public String[] reorderLogFiles(String[] logs) {
        Comparator<String> cmptr = new Comparator<String>() {
            @Override
            public int compare(String log1, String log2) {
                String[] str1 = log1.split(" ", 2);
                String[] str2 = log2.split(" ", 2);

                boolean isDigit1 = Character.isDigit(str1[1].charAt(0));
                boolean isDigit2 = Character.isDigit(str2[1].charAt(0));
                if (!isDigit1 && isDigit2) {
                    return -1;
                }
                if (isDigit1 && !isDigit2) {
                    return 1;
                }
                if (isDigit1 && isDigit2)
                    return 0;
                int cmp = str1[1].compareTo(str2[1]);
                if (cmp == 0) {
                    return str1[0].compareTo(str2[0]);
                }
                return cmp;
            }
        };
        Arrays.sort(logs, cmptr);
        return logs;
    }
}
