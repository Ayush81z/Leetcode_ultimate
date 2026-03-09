package DFS;

import java.util.*;

public class ConstructBTPreIn_lc105 {
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

            int[] preorder = {3, 9, 20, 15, 7};
            int[] inorder  = {9, 3, 15, 20, 7};

            ConstructBTPreIn_lc105 sol = new ConstructBTPreIn_lc105();

            TreeNode root = sol.buildTree(preorder, inorder);

            System.out.println("Tree constructed. Root value: " + root.val);
    }


    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0) return null;
        int root = preorder[0];
        int rootindex = 0;
        for (int i = 0; i < inorder.length; i++) {
            if (root == inorder[i]) {
                rootindex = i;
            }
        }
        TreeNode node = new TreeNode(root);

        //Note : here arrays.copyofrange is exclusive for the end hence the +1
        node.left = buildTree(Arrays.copyOfRange(preorder ,1,  rootindex+1), Arrays.copyOfRange(inorder, 0 , rootindex));
        //index = size of left subtree (for the current subtree)

        node.right = buildTree(Arrays.copyOfRange(preorder,rootindex+1,preorder.length) , Arrays.copyOfRange(inorder,rootindex+1 , inorder.length));

        return node;
    }
}
