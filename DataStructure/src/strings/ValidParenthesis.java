package strings;

import java.util.Stack;

public class ValidParenthesis {
    public static void main(String[] args) {

    }

    public boolean isValid(String s) {
        int size = s.length();
        Stack<String> stack = new Stack<String>();
        boolean isMatch = true;
        if (size % 2 == 1)
            isMatch = false;
        for(int i = 0; i < size; i++) {
            String str = "" + s.charAt(i);
            if (str.equals("(") || str.equals("[") || str.equals("{")) {
                stack.push(str);
            } else {
                if(stack.isEmpty()){
                    isMatch = false;
                    break;
                }
                if (!stack.isEmpty()) {
                    String pop = stack.pop();
                    if (!((pop.equals("(") && str.equals(")"))
                            || (pop.equals("[") && str.equals("]"))
                            || (pop.equals("{") && str.equals("}")))) {
                        isMatch = false;
                        break;
                    }
                }
            }
        }
        if (!stack.isEmpty()) {
            isMatch = false;
        }
        return isMatch;
    }
}
