package Leetcode_mix;

public class powerofFour {
    public static void main(String[] args) {
        int[] testCases = {1, 4, 16, 5, 0, -4, 64};
        for (int n : testCases) {
            System.out.println(isPowerOfFour(n));
        }
    }

    public static boolean isPowerOfFour(int n) {
        if (n<=0) return false;
        while (n%4 == 0) {
            n = n/4;
        }
        if (n==1) return true;
        return false;
    }
    //return (n & (n - 1)) == 0 && n % 3 == 1; also works perfectly
}
