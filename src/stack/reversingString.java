package stack;

import java.util.Stack;

public class reversingString {
    public static void main(String[] args) {
        Stack<Character> stack = new Stack<>();

        String str = "MISSISIPI";

        for(char c : str.toCharArray()) {
            stack.push(c);
        }

        String reversed = "";
        while(!stack.isEmpty()) {
            reversed += stack.pop();
        }

        System.out.println("The Reversed String is : " +reversed);
    }
}
