package stack;

import java.util.Stack;
//could be improved by using a single function and passing them  individually

public class backspaceString_lc844 {
        public static void main(String[] args) {
            // Predefined test cases
            String s = "y#fo##f";
            String t = "y#f#o##f";

            // Create object of your solution class
            backspaceString_lc844 sol = new backspaceString_lc844();

            // Call the method
            boolean result = sol.backspaceCompare(s, t);

            // Print result
            System.out.println("Are the two strings equal? " + result);
        }

        public boolean backspaceCompare(String s, String t) {
            Stack<Character> stack_s = new Stack<>();
            Stack<Character> stack_t = new Stack<>();


            Character curr = 0;
            Character curr2 = 0;

            for (int i = 0 ; i < s.length() ; i++) {
                curr = s.charAt(i);

                if (curr.equals('#')) {
                    if (!stack_s.isEmpty()) {
                        stack_s.pop();
                    }
                }
                else {
                    stack_s .push(curr);
                }
            }

            for (int i = 0 ; i < t.length() ; i++) {
                curr2 = t.charAt(i);

                if (curr2.equals('#')) {
                    if (!stack_t.isEmpty()) {
                        stack_t.pop();
                    }
                }
                else {
                    stack_t.push(curr2);
                }
            }

            StringBuffer str = new StringBuffer();

            for (Character ch : stack_s) {
                str.append(ch);
            }
            String finals = str.toString();

            StringBuffer str2 = new StringBuffer();

            for (Character ch : stack_t) {
                str2.append(ch);
            }
            String finalt = str2.toString();

            return finals.equals(finalt);
        }

    }


