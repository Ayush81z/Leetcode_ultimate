package BinaryTree;

import java.util.LinkedList;
import java.util.*;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class BTpostorder_lc145 {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {

        }
        TreeNode(int val) {
            this.val = val;
        }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        postorder(root , list);
        return list;
    }

    private void postorder(TreeNode root, List<Integer> list) {
        if (root == null) { return;}
        postorder(root.left , list);
        postorder(root.right, list);
        list.add(root.val);
    }

}

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BTpostorder_lc145 sol = new BTpostorder_lc145();

        // Read input as a single line
        System.out.println("enter the values to create a Binary Tree: ");
        String input = sc.nextLine().trim();

        // Remove brackets if user enters: [1,2,3,null,null,4,5]
        input = input.replace("[", "").replace("]", "");

        String[] arr = input.split(",");

        if (input.equals("[]") || input.trim().length() == 0) {
            System.out.println("Tree is empty.");
            return;
        }

        BTpostorder_lc145.TreeNode root = buildTree(arr);

        System.out.println("The Preorder traversal for the Given Binary Tree is :");
        System.out.println(sol.postorderTraversal(root));
    }

    // Build tree from LeetCode-style input
    private static BTpostorder_lc145.TreeNode buildTree(String[] arr) {
        if (arr.length == 0 || arr[0].equals("null")) return null;

        BTpostorder_lc145.TreeNode root = new BTpostorder_lc145.TreeNode(Integer.parseInt(arr[0]));
        Queue<BTpostorder_lc145.TreeNode> q = new LinkedList<>();
        q.offer(root);

        int i = 1;
        while (!q.isEmpty() && i < arr.length) {
            BTpostorder_lc145.TreeNode curr = q.poll();

            // left child
            if (i < arr.length && !arr[i].equals("null")) {
                curr.left = new BTpostorder_lc145.TreeNode(Integer.parseInt(arr[i]));
                q.offer(curr.left);
            }
            i++;

            // right child
            if (i < arr.length && !arr[i].equals("null")) {
                curr.right = new BTpostorder_lc145.TreeNode(Integer.parseInt(arr[i]));
                q.offer(curr.right);
            }
            i++;
        }

        return root;
    }
}
