package DFS;

import BinaryTree.AVL_TREES;

import java.util.*;

public class ArrayToBst_lc108 {
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
        ArrayToBst_lc108 sol = new ArrayToBst_lc108();

        int[] nums = {-10,-3,0,5,9};
        TreeNode root = sol.sortedArrayToBST(nums);

        // simple BFS print to verify structure
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {
            TreeNode cur = q.poll();
            if (cur == null) {
                continue;
            }
            System.out.print(cur.val + " ");
            q.add(cur.left);
            q.add(cur.right);
        }
    }

    //optimal 0(n) , no insertion , no comparison
    private TreeNode root;

    public TreeNode sortedArrayToBST(int[] nums) {
        root = generateNewMid(nums , 0 , nums.length);
        return  root;
    }

    public TreeNode generateNewMid(int[] nums , int start , int end) {
        if (start >= end) return null;

        int mid = start + (end - start) /2;
        TreeNode node = new TreeNode(nums[mid]);

        node.left = generateNewMid(nums , start , mid);
        node.right = generateNewMid(nums , mid+1 , end);
        return  node;
    }




    //method 2 : 0(n log n) non optimal
//    private TreeNode root;
//
//    public TreeNode sortedArrayToBST(int[] nums) {
//        generateNewMid(nums , 0 , nums.length);
//        return  root;
//    }
//
//    public void generateNewMid(int[] nums , int start , int end) {
//        if (start >= end ) return;
//
//        int mid = (start + end) /2;
//
//        this.insert(nums[mid]);
//        generateNewMid(nums , 0 , mid);
//        generateNewMid(nums , mid+1 , end);
//    }
//
//    public void insert(int value) {
//        root = insertTree(root , value);
//    }
//
//    public TreeNode insertTree(TreeNode root , int value) {
//        if (root == null) return new TreeNode(value);
//
//        if (value > root.val) {
//            root.right = insertTree(root.right , value);
//        }
//
//        if (value < root.val) {
//            root.left = insertTree(root.left , value);
//        }
//        return root;
//    }


}
