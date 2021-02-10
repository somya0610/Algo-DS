package strings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CompareVersions {
    public static void main(String[] args) {
        CompareVersions cv = new CompareVersions();
        cv.compareVersion("0.1", "1.1");
    }

    public int compareVersion(String version1, String version2) {
        String[] s1 = version1.split("\\.");
        String[] s2 = version2.split("\\.");
        List<Integer> list1 = Arrays.stream(s1).map(s -> Integer.valueOf(s)).collect(Collectors.toList());
        List<Integer> list2 = Arrays.stream(s2).map(s -> Integer.valueOf(s)).collect(Collectors.toList());
        while (list1.size() < list2.size())
            list1.add(0);
        while (list2.size() < list1.size())
            list2.add(0);
        int i = 0;
        while (i < list1.size()) {
            if (list1.get(i) < list2.get(i))
                return -1;
            if (list1.get(i) > list2.get(i))
                return 1;
            i++;
        }
        return 0;
    }
}
