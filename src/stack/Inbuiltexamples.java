package stack;

import java.util.Stack;

public class Inbuiltexamples {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();

        stack.push(10); //1
        stack.push(45); //2
        stack.push(35);
        stack.push(62);
        stack.push(26);
        stack.push(46);
        stack.push(89); //last one (will be popped first)

        System.out.println(stack.pop()); //pop the last element inserted

    }
}
