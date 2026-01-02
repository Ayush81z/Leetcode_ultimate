package stack;

import java.util.Stack;

public class BalancedExpr {

    public static Boolean checker(String str) {
        Stack<Character> stack = new Stack<>();
        for (char ch : str.toCharArray()) {
            if (ch == '{' || ch == '[' || ch == '(' ) {
                stack.push(ch);
            }
            else if (ch == '}' || ch == ']' || ch == ')') {
                if (stack.isEmpty()) return false;
                char top = stack.pop();
                if (ch == '}' &&  top != '{'
                    || ch == ']' && top != '['
                    || ch == ')' && top != '(') {
                    return false;
                }

            }

        }
        return stack.isEmpty(); // if balanced then stack would be empty because all the like ones would be popped out
    }

    public static void main(String[] args) {
        String str = "()[]{}";
        System.out.println("is balanced: " + checker(str));

    }
}
