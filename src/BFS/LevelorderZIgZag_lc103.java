package BFS;

import java.util.*;

public class LevelorderZIgZag_lc103 {
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
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(2);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        LevelorderZIgZag_lc103 sol = new LevelorderZIgZag_lc103();
        System.out.println(sol.zigzagLevelOrder(root));
    }

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if (root == null) return new ArrayList<>();
        List<List<Integer>> list = new ArrayList<>();
        Deque<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        Boolean reverse = false;

        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> currlev = new ArrayList<>();

            for (int i = 0; i < size; i++) {
                TreeNode node = reverse ? queue.pollLast() : queue.pollFirst();
                if (node == null) continue;

                currlev.add(node.val);

                if (reverse) {
                    if (node.right != null) queue.addFirst(node.right);
                    if (node.left != null) queue.addFirst(node.left);
                } else {
                    if (node.left != null) queue.addLast(node.left);
                    if (node.right != null) queue.addLast(node.right);
                }

            }
            reverse = !reverse; //toggles every time it is hit
            list.add(currlev);
        }
        return list;

        //method 2 , but clingy
//        while (!queue.isEmpty()) {
//            int size = queue.size();
//            List<Integer> currlev = new ArrayList<>();
//
//            for (int i = 0; i < size; i++) {
//                if (reverse) {
//                    TreeNode node = queue.pollLast();
//                    if (node != null) currlev.add(node.val);
//                    if (node.right != null) queue.addFirst(node.right);
//                    if (node.left != null) queue.addFirst(node.left);
//
//                } else {
//                    TreeNode node = queue.pollFirst();
//                    if (node != null) currlev.add(node.val);
//                    if (node.left != null) queue.addLast(node.left);
//                    if (node.right != null) queue.addLast(node.right);
//                }
//            }
//
//            reverse = !reverse;
//            list.add(currlev);
//        }

    }
}
