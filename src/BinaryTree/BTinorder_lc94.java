package BinaryTree;
//
//import java.util.LinkedList;
//import java.util.*;
//import java.util.List;
//import java.util.Queue;
//import java.util.Scanner;
//
public class BTinorder_lc94 {
//    public static class TreeNode {
//        int val;
//        TreeNode left;
//        TreeNode right;
//        TreeNode() {
//
//        }
//        TreeNode(int val) {
//            this.val = val;
//        }
//        TreeNode(int val, TreeNode left, TreeNode right) {
//            this.val = val;
//            this.left = left;
//            this.right = right;
//        }
//    }
//
//    public List<Integer> inorderTraversal(TreeNode root) {
//        if (root == null) { return new ArrayList<>(); }
//
//        List<Integer> list = new ArrayList<>();
//
//        List<Integer> left = inorderTraversal(root.left);
//        List<Integer> right = inorderTraversal(root.right);
//
//        list.addAll(left);
//        list.add(root.val);
//        list.addAll(right);
//
//        return list;
//    }
//
//    //more optimal
////    public List<Integer> inorderTraversal(TreeNode root) {
////        List<Integer> list = new ArrayList<>();
////        inorderhelper(root , list);
////        return list;
////    }
////
////
////
////    private void inorderhelper (TreeNode root, List<Integer> list) {
////        if (root == null) { return; }
////        inorderhelper(root.left , list);
////        list.add(root.val);
////        inorderhelper(root.right , list);
////    }
//
}
//
//class Main {
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        BTinorder_lc94 sol = new BTinorder_lc94();
//
//        // Read input as a single line
//        System.out.println("enter the values to create a Binary Tree: ");
//        String input = sc.nextLine().trim();
//
//        // Remove brackets if user enters: [1,2,3,null,null,4,5]
//        input = input.replace("[", "").replace("]", "");
//
//        String[] arr = input.split(",");
//
//        if (input.equals("[]") || input.trim().length() == 0) {
//            System.out.println("Tree is empty.");
//            return;
//        }
//
//        BTinorder_lc94.TreeNode root = buildTree(arr);
//
//        System.out.println("The Preorder traversal for the Given Binary Tree is :");
//        System.out.println(sol.inorderTraversal(root));
//    }
//
//    // Build tree from LeetCode-style input
//    private static BTinorder_lc94.TreeNode buildTree(String[] arr) {
//        if (arr.length == 0 || arr[0].equals("null")) return null;
//
//        BTinorder_lc94.TreeNode root = new BTinorder_lc94.TreeNode(Integer.parseInt(arr[0]));
//        Queue<BTinorder_lc94.TreeNode> q = new LinkedList<>();
//        q.offer(root);
//
//        int i = 1;
//        while (!q.isEmpty() && i < arr.length) {
//            BTinorder_lc94.TreeNode curr = q.poll();
//
//            // left child
//            if (i < arr.length && !arr[i].equals("null")) {
//                curr.left = new BTinorder_lc94.TreeNode(Integer.parseInt(arr[i]));
//                q.offer(curr.left);
//            }
//            i++;
//
//            // right child
//            if (i < arr.length && !arr[i].equals("null")) {
//                curr.right = new BTinorder_lc94.TreeNode(Integer.parseInt(arr[i]));
//                q.offer(curr.right);
//            }
//            i++;
//        }
//
//        return root;
//    }
//}
