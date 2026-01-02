package stack;

import java.util.Arrays;
import java.util.Stack;

public class nextgreatele2_lc503 {
    public static void main(String[] args) {
        nextgreatele2_lc503 sol = new nextgreatele2_lc503();

        int[] nums = {1, 2, 1}; // Example input
        int[] result = sol.nextGreaterElements(nums);

        System.out.println("Next Greater Elements:");
        for (int r : result) {
            System.out.print(r + " ");
        }
    }


    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        Arrays.fill(result, -1);

        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n*2 ; i++) {
            while (!stack.isEmpty() && nums[stack.peek()] < nums[i%n]) {
                result[stack.pop()] = nums[i%n];
            }

            if (i < n) {
                stack.push(i);
            }
        }

        return result;
    }

//    public int[] nextGreaterElements(int[] nums) {
//        Stack<Integer> stack = new Stack<>();
//        int n = nums.length;
//        int[] res = new int[n];
//
//        Arrays.fill(res, -1);
//
//        for (int i = 2*n-1 ; i >= 0 ; i--) { //traverse it twice
//
//            while (!stack.isEmpty() && stack.peek() <= nums[i%n]) {
//                stack.pop();
//            }
//
//            if (i < n) {   //only fill in the first pass
//                if (!stack.isEmpty()) {
//                    res[i] = stack.peek();
//                }
//            }
//            stack.push(nums[i%n]);
//        }
//        return res;
//    }
}
