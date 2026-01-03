package Leetcode_mix;

public class leetcode_961 {
    public static void main(String[] args) {
        int[] nums = {4,1,2,3,4,4};


        leetcode_961 sol = new leetcode_961();
        int result = sol.repeatedNTimes(nums);

        System.out.println(result);
    }

    public int repeatedNTimes(int[] nums) {
        for (int i = 0; i < nums.length-1; i++) {
            if (nums[i] == nums[i+1])  return nums[i];
            if (i+2 < nums.length && nums[i] == nums[i+2]) return nums[i];
            if (i+3 < nums.length && nums[i] == nums[i+3]) return nums[i];

        }
        return 0;
    }


}
