package stack;

import java.util.ArrayDeque;

//medium
public class removeKDigits_lc402 {
    public static void main(String[] args) {
        removeKDigits_lc402 sol = new removeKDigits_lc402();

        String num = "10";
        int k = 2;

        String result = sol.removeKdigits(num, k);
        System.out.println(result);  // expected output: "1219"
    }


    private String removeKdigits(String num, int k) {
        int size = num.length();
        ArrayDeque<Character> stack = new ArrayDeque<>();

        int counter = 0;
        while (counter < size) {
            while (k > 0 && !stack.isEmpty() && stack.peek() > num.charAt(counter)) {
                stack.pop();
                k--;
            }

            stack.push(num.charAt(counter));
            counter++;
        }

        //to solve the repeating digits
        while(k > 0) {
            stack.pop();
            k--;
        }

        StringBuilder sb = new StringBuilder();

        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }

        sb.reverse();

        while (sb.length() > 1 && sb.charAt(0) == '0') {
            sb.deleteCharAt(0);
        }

        return sb.toString();
    }


}

