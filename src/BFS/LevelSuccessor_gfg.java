package BFS;

//https://www.geeksforgeeks.org/dsa/level-order-successor-of-a-node-in-binary-tree/

import java.util.LinkedList;
import java.util.Queue;

public class LevelSuccessor_gfg {
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
        // Tree: [3,9,20,null,null,15,7]
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        int key = 20; // find level order successor of 9

        LevelSuccessor_gfg sol = new LevelSuccessor_gfg();
        TreeNode successor = sol.levelOrderSuccessor(root, key);

        System.out.println(successor != null ? successor.val : "null");
    }

    public TreeNode levelOrderSuccessor(TreeNode root , int key) {
        if (root == null) return null;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()){
            TreeNode node = queue.poll(); //remove the current (maybe key elem)
            if (node.left != null) queue.add(node.left);
            if (node.right != null) queue.add(node.right);
            if (key == node.val) break; //break if it is a key element so that the next element can be returned via "queue.peek"
        }
        return queue.peek();
    }
}
