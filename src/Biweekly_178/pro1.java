package Biweekly_178;

public class pro1 {
    public static void main(String[] args) {
        int[] nums = {3,4,2,5,4,6};
        System.out.println(firstUniqueEven(nums));
    }

    public static int firstUniqueEven(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int count = 0;
            for (int j = 0; j < nums.length; j++) {
                if (nums[i] == nums[j]) {
                    count++;
                }
            }
            if (count == 1 && nums[i] % 2 == 0) {
                return nums[i];
            }
        }
        return -1;
    }
}
