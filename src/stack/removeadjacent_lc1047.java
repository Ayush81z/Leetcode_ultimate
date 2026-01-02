package stack;

import java.util.Stack;

public class removeadjacent_lc1047 {
    public static void main(String[] args) {
        // Predefined test case
        String s = "abbaca";

        // Create object of your solution class
        removeadjacent_lc1047 sol = new removeadjacent_lc1047();

        // Call the method
        String result = sol.removeDuplicates(s);

        // Print result
        System.out.println("Final string after removing duplicates: " + result);
    }


    public String removeDuplicates(String s) {
        Stack<Character> stack = new Stack<>();
        int i = 0;

        while (i < s.length()) {
            if (stack.isEmpty() || s.charAt(i) != stack.peek()) {
                stack.push(s.charAt(i));
            }

            else {
                stack.pop();
            }
            i++;
        }

        StringBuilder str = new StringBuilder();

        for (char c : stack) {
            str.append(c);
        }

        return str.toString();
    }
}

