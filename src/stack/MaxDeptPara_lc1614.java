package stack;

public class MaxDeptPara_lc1614 {
    public static void main(String[] args) {
        MaxDeptPara_lc1614 sol = new MaxDeptPara_lc1614();

        String s1 = "(1+(2*3)+((8)/4))+1";
        String s2 = "(1)+((2))+(((3)))";
        String s3 = "()(())((()))";

        System.out.println(sol.maxDepth(s1)); // Expected: 3
        System.out.println(sol.maxDepth(s2)); // Expected: 3
        System.out.println(sol.maxDepth(s3)); // Expected: 3
    }

    public int maxDepth(String s) {
        int depth = 0; int maxdepth = 0;
        for( char ch : s.toCharArray()) {
            if (ch == '(') {
                depth++;
                maxdepth = Math.max(depth, maxdepth);
            }
            else if (ch == ')'){
                depth--;
            }
        }
        return maxdepth;
    }

}
