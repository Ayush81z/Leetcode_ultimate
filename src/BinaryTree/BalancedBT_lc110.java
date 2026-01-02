package BinaryTree;

import static java.lang.Math.abs;
import static java.lang.Math.max;

public class BalancedBT_lc110 {
    public static class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }

    public static void main(String[] args) {

        // Tree: [1,2,2,3,3,null,null,4,4]

        TreeNode root = new TreeNode(1);

        root.left = new TreeNode(2);
        root.right = new TreeNode(2);

        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(3);

        root.left.left.left = new TreeNode(4);
        root.left.left.right = new TreeNode(4);

        boolean result = isBalanced(root);
        System.out.println(result);  // Expected: false
    }

    //non - optimised
//    private static boolean isBalanced(TreeNode root) {
//        if (root == null) return true;
//        int  left = heightbal(root.left);
//        int right = heightbal(root.right);
//        if (abs(left - right) > 1)  return false;
//
//        return isBalanced(root.left) && isBalanced(root.right);
//    }
//
//    private static int heightbal(TreeNode root) {
//        if (root == null) return 0;
//        int left = heightbal(root.left);
//        int right = heightbal(root.right);
//        return Math.max(left , right) + 1;
//    }

    //optimised

        public static boolean isBalanced(TreeNode root) {
            return dfsHeight(root) != -1;
        }
        static int dfsHeight(TreeNode root) {
            if (root == null) return 0;

            int leftHeight = dfsHeight(root.left);
            if (leftHeight == -1) return -1;
            int rightHeight = dfsHeight(root.right);
            if (rightHeight == -1) return -1;

            if (Math.abs(leftHeight - rightHeight) > 1) return -1;
            return Math.max(leftHeight, rightHeight) + 1;
        }



}
