package stack;

import java.util.ArrayDeque;

public class reverseprefix_lc2000 {
    public static void main(String[] args) {
        reverseprefix_lc2000 sol = new reverseprefix_lc2000();

        String word = "abcd";
        char ch = 'c';

        String result = sol.reversePrefix(word, ch);
        System.out.println(result);  // expected output: "dcbaefd"
    }


    public String reversePrefix(String word, char ch) {
        ArrayDeque<Character> stack = new ArrayDeque();
        StringBuilder str = new StringBuilder();

        int i = 0;
        boolean rem = false;
        while(i < word.length()) {
            stack.push(word.charAt(i));
            if (ch == word.charAt(i)) {
                rem = true;
                break;
            }
            i++;
        }

        if (!rem) return word;

        while(!stack.isEmpty()) {
            str.append(stack.pop()); //append the reversed ones
        }

        if (i+1 < word.length()) {
            str.append(word.substring(i+1)); //then append rest of them
        }

        return str.toString();
    }
}
