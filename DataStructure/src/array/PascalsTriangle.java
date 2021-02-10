package array;

import java.util.ArrayList;
import java.util.List;

public class PascalsTriangle {

    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        if (numRows == 0)
            return result;

        for (int i = 0 ; i < numRows; i++) {
            List<Integer> list = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i) {
                    list.add(1);
                } else {
                    List<Integer> prev = result.get(i-1);
                    list.add(prev.get(j-1) + prev.get(j));
                }
            }
            result.add(list);
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(generate(5));
    }
}
