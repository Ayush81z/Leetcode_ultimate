package stack;

import java.util.ArrayDeque;
import java.util.Stack;

public class makeStringgreat_lc1544 {
    public static void main(String[] args) {
        // Predefined test case
        String s = "s";

        // Create object of your solution class
        makeStringgreat_lc1544 sol = new makeStringgreat_lc1544();

        // Call the method
        String result = sol.makeGood(s);

        // Print the result
        System.out.println("Final string after making it good: " + result);
    }

    public String makeGood(String s) {
        ArrayDeque<Character> stack = new ArrayDeque<>();

        int i = 0;
        while(i < s.length()) {
            if (stack.isEmpty() || Math.abs(s.charAt(i) - stack.peek()) != 32 ) {
                stack.push(s.charAt(i));
            }

            else {
                stack.pop();
            }
            i++;
        }

        StringBuilder str = new StringBuilder();

        for (char ch : stack) {
            str.append(ch);
        }

        return str.toString();
    }
}
