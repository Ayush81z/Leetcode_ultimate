package Biweekly_178;

import java.util.Arrays;

public class pro2 {

        public static void main(String[] args) {

            int[] nums = {2,6,4};

            long result = gcdSum(nums);

            System.out.println("Result = " + result);
        }



    public static long gcdSum(int[] nums) {
        int max = nums[0];
        int[] prefix = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            max = Math.max(nums[i] , max);

            prefix[i] = gcd(nums[i] , max);
        }

        Arrays.sort(prefix);
        int low = 0;
        int high = prefix.length-1;
        long val = 0;
        while (low < high) {
            val += gcd(prefix[low] , prefix[high]);
            low++;
            high--;
        }
        return val;
    }

    public static int gcd(int num , int max) {
        while (max != 0) {
            int temp = num % max;
            num = max;
            max = temp;
        }
        return num;
    }


}
