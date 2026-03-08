package weekly_492;
import java.util.*;

public class pro2 {
    public static void main(String[] args) {
        int[] arr = {999, 818, 984, 995, 841, 822, 984, 978, 960, 997, 896, 926, 759, 961, 1000, 562, 1, 1, 1, 87, 4, 1, 40};
        System.out.println(smallestBalancedIndex(arr));
    }


//    public static int smallestBalancedIndex(int[] nums) {
//        for (int i = 0; i < nums.length; i++) {
//            int sum = 0;
//            long pro = 1;
//
//            for (int j = 0; j < i; j++) {
//                    sum += nums[j];
//            }
//            for (int k = i+1; k < nums.length; k++) {
//                pro *= nums[k];
//            }
//
//            if (sum == pro) {
//                return i;
//            }
//        }
//        return -1;
//    }
//
//
//}

//import java.math.BigInteger;
//class Solution {
//
//
//    public static int smallestBalancedIndex(int[] nums) {
//        int n = nums.length;
//        long[] prefixSum = new long[n + 1];
//        for (int i = 0; i < n; i++) {
//            prefixSum[i + 1] = prefixSum[i] + nums[i];
//        }
//
//        BigInteger[] suffixProduct = new BigInteger[n + 1];
//        suffixProduct[n] = BigInteger.ONE;
//        for (int i = n - 1; i >= 0; i--) {
//            suffixProduct[i] = suffixProduct[i + 1].multiply(BigInteger.valueOf(nums[i]));
//        }
//
//        for (int i = 0; i < n; i++) {
//            if (prefixSum[i] == suffixProduct[i + 1].longValue() &&
//                    suffixProduct[i + 1].equals(BigInteger.valueOf(prefixSum[i]))) {
//                return i;
//            }
//        }
//        return -1;
//    }
//
//}


    public static int smallestBalancedIndex(int[] nums) {
        int n = nums.length;
        if (n == 0) return -1;  // Edge case, if applicable

        // Precompute prefix sums (sum from 0 to i-1)
        long[] prefix = new long[n + 1];
        for (int i = 1; i <= n; i++) {
            prefix[i] = prefix[i - 1] + nums[i - 1];
        }

        // Precompute suffix products (prod from i to n-1), with overflow flag
        long[] suffixProd = new long[n + 1];
        boolean[] isInfinite = new boolean[n + 1];
        suffixProd[n] = 1L;
        isInfinite[n] = false;

        for (int i = n - 1; i >= 0; i--) {
            if (nums[i] == 0) {
                suffixProd[i] = 0L;
                isInfinite[i] = false;
            } else {
                if (isInfinite[i + 1] ||
                        (suffixProd[i + 1] != 0 && suffixProd[i + 1] > Long.MAX_VALUE / nums[i])) {
                    suffixProd[i] = 0L;
                    isInfinite[i] = true;
                } else {
                    suffixProd[i] = suffixProd[i + 1] * (long) nums[i];
                    isInfinite[i] = false;
                }
            }
        }

        // Check each mid from left to right
        for (int mid = 0; mid < n; mid++) {
            long leftSum = prefix[mid];
            int start = mid + 1;
            if (isInfinite[start]) {
                continue;
            }
            if (leftSum == suffixProd[start]) {
                return mid;
            }
        }
        return -1;
    }

}

