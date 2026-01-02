package BinaryTree;

import java.util.ArrayDeque;

public class pathsum_lc112 {
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

        // Tree: [1,2,3]
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        int targetSum = 5;

        pathsum_lc112 sol = new pathsum_lc112();
        boolean result = sol.hasPathSum(root, targetSum);

        System.out.println(result);  // Expected: false
    }


    private boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) return false;
        ArrayDeque<TreeNode> node_stack = new ArrayDeque<>();
        ArrayDeque<Integer> sum_stack = new ArrayDeque<>();

        node_stack.add(root);
        sum_stack.add(targetSum - root.val);

        while (!node_stack.isEmpty()) {
            TreeNode current_node =  node_stack.pop();
            int current_sum = sum_stack.pop();

            if (current_node.left == null && current_node.right == null && current_sum == 0) {
                return true;
            }

            if (current_node.left != null) {
                node_stack.add(current_node.left);
                sum_stack.add(current_sum - current_node.left.val);
            }

            if (current_node.right != null) {
                node_stack.add(current_node.right);
                sum_stack.add(current_sum - current_node.right.val);
            }
        }
        return false;
    }


}
