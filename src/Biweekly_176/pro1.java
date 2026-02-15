package Biweekly_176;

import java.util.HashMap;
import java.util.Map;

public class pro1 {
    public static void main(String[] args) {

        String[] words = {"abcd", "def", "xyz"};

        int[] weights = {
                5,3,12,14,1,2,3,2,10,6,6,9,7,8,7,10,8,9,6,9,9,8,3,7,7,2
        };

        String result = mapWordWeights(words, weights);

        System.out.println("Output: " + result);
    }

    public static char getCharFromValue(int value) {
        return (char) ('z' - value);
    }

    public static String mapWordWeights(String[] words, int[] weights) {
        StringBuilder str = new StringBuilder();
        for (String word : words) {
            int total = 0;
            for (char ch : word.toCharArray()) {
                total += weights[ch - 'a'];
            }
            total = total % 26;
            char result = getCharFromValue(total);
            str.append(result);
        }
        return str.toString();
    }
}
