package BinaryTree;
//
//import java.util.LinkedList;
//import java.util.*;
//import java.util.List;
//import java.util.Queue;
//import java.util.Scanner;
//
public class BTpreorder_lc144 {
//    public static class TreeNode {
//      int val;
//      TreeNode left;
//      TreeNode right;
//      TreeNode() {
//
//      }
//     TreeNode(int val) {
//          this.val = val;
//      }
//      TreeNode(int val, TreeNode left, TreeNode right) {
//        this.val = val;
//          this.left = left;
//          this.right = right;
//      }
// }
//
//    public List<Integer> preorderTraversal(TreeNode root) {
//        if (root == null) {
//            return new ArrayList<>();
//        }
//
//        List<Integer> list = new ArrayList<>();
//        list.add(root.val);
//
//        List<Integer> left = preorderTraversal(root.left);
//        List<Integer> right = preorderTraversal(root.right);
//
//        list.addAll(left);
//        list.addAll(right);
//
//        return list;
//    }
//
}
//
// class Main {
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        BTpreorder_lc144 sol = new BTpreorder_lc144();
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
//        BTpreorder_lc144.TreeNode root = buildTree(arr);
//
//        System.out.println("The Preorder traversal for the Given Binary Tree is :");
//        System.out.println(sol.preorderTraversal(root));
//    }
//
//    // Build tree from LeetCode-style input
//    private static BTpreorder_lc144.TreeNode buildTree(String[] arr) {
//        if (arr.length == 0 || arr[0].equals("null")) return null;
//
//        BTpreorder_lc144.TreeNode root = new BTpreorder_lc144.TreeNode(Integer.parseInt(arr[0]));
//        Queue<BTpreorder_lc144.TreeNode> q = new LinkedList<>();
//        q.offer(root);
//
//        int i = 1;
//        while (!q.isEmpty() && i < arr.length) {
//            BTpreorder_lc144.TreeNode curr = q.poll();
//
//            // left child
//            if (i < arr.length && !arr[i].equals("null")) {
//                curr.left = new BTpreorder_lc144.TreeNode(Integer.parseInt(arr[i]));
//                q.offer(curr.left);
//            }
//            i++;
//
//            // right child
//            if (i < arr.length && !arr[i].equals("null")) {
//                curr.right = new BTpreorder_lc144.TreeNode(Integer.parseInt(arr[i]));
//                q.offer(curr.right);
//            }
//            i++;
//        }
//
//        return root;
//    }
//}
