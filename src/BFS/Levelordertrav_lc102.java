package BFS;

import java.util.*;
import java.util.Collections.*;

public class Levelordertrav_lc102 {
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
        // Example tree: [3,9,20,null,null,15,7]
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        Levelordertrav_lc102 sol = new Levelordertrav_lc102();
        System.out.println(sol.levelOrder(root));
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) return new ArrayList<>();
        List<List<Integer>> list = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int size = queue.size(); //to know the size of current level and only take that many itterations
            List<Integer> currlev = new ArrayList<>();

            for (int i = 0; i < size; i++) { //until the current size is itterated
                TreeNode node = queue.poll();
                if (node !=null) currlev.add(node.val); //for the current level

                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }
            list.add(currlev);
        }
        return list;
    }
}
