package recursion;

import java.util.*;

public class GenerateParentheses {
    public static List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<String>();
        if (n == 0) {
            ans.add("");
        } else {
            for (int c = 0; c < n; ++c)
                for (String left: generateParenthesis(c))
                    for (String right: generateParenthesis(n-1-c))
                        ans.add("(" + left + ")" + right);
        }
        return ans;
    }

    public static void main(String[] args) {
        generateParenthesis(3);
    }
}
