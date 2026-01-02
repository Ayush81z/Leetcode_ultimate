package stack;

import java.util.ArrayDeque;

public class removeOuterPara_lc1021 {
    public static void main(String[] args) {
            // Predefined test case (you can change this)
            String s = "(()())(())(()(()))";

            // Create object of your solution class
            removeOuterPara_lc1021 sol = new removeOuterPara_lc1021();

            // Call the method
            String result = sol.removeOuterParentheses(s);

            // Print result
            System.out.println("Result: " + result);
    }

    public String removeOuterParentheses(String s) {

        StringBuilder str = new StringBuilder();
        int depth = 0;
        for (char ch : s.toCharArray()) {
            if (ch == '(') {
                if (depth > 0) str.append(ch);
                depth++;
            }

            else if (ch == ')') {
                depth--;
                if (depth > 0) str.append(ch);
            }
        }
        return str.toString();
    }
}
