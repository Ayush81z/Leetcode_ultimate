package BinaryTree;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePath_lc257 {
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
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(5);

        List<String> result = binaryTreePaths(root);
        System.out.println(result);
    }

    private static List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList<>();
        if (root==null) return result;
        helper(root , String.valueOf(root.val) , result);
        return result;
    }

    private static void helper(TreeNode root, String path, List<String> result) {
        if (root.left == null && root.right == null) {
            result.add(path);
            return;
        }

        if (root.left !=null) {
            helper(root.left ,path +"->"+ root.left.val ,  result );
        }

        if (root.right != null) {
            helper(root.right ,path +"->"+ root.right.val ,  result );
        }
    }

}
