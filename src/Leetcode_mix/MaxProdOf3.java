package Leetcode_mix;

import java.util.Arrays;

public class MaxProdOf3 {
    public static void main(String[] args) {
        int[] nums = {1,2,3,4};

        MaxProdOf3 sol = new MaxProdOf3();
        int result = sol.maximumProduct(nums);

        System.out.println(result);
    }

    public int maximumProduct(int[] nums) {
        Arrays.sort(nums);
        return Math.max(nums[0]*nums[1]*nums[nums.length-1] , nums[nums.length-3]* nums[nums.length-2]*nums[nums.length-1]);
        //two smallest negatives × largest positive , to make the final answer positive ....
    }
}
