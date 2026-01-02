package stack;

import java.util.Stack;

public class baseballgame_lc682 {
    public static void main(String[] args) {
        // Predefined test case
        String[] ops = {"1","C"};

        // Create object of your solution class
        baseballgame_lc682 sol = new baseballgame_lc682();

        // Call the method
        int result = sol.calPoints(ops);

        // Print the result
        System.out.println("Total points: " + result);
    }


    public int calPoints(String[] ops) {
        Stack<Integer> stack = new Stack<>();
        String curr = "";
        int val1 = 0;
        int val2 = 0;
        int temp = 0;
        for (int i = 0; i < ops.length; i++) {
            curr = ops[i];

            if (curr.equals("D")) {
                val1 = stack.peek() * 2;
                stack.push(val1);
            }
            else if (curr.equals("C")) {
                stack.pop();
            }
            else if (curr.equals("+")) {
                val1 = stack.peek();
                temp = stack.pop();
                val2 = stack.peek();
                stack.push(temp);
                temp = val1 + val2;
                stack.push(temp);
            }
            else {
                int num = Integer.parseInt(curr);
                stack.push(num);
            }
        }
        int total=0;
        while(!stack.isEmpty()) {
            total += stack.pop();
        }

        return total;
    }
}

