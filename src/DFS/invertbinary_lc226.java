package DFS;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class invertbinary_lc226 {
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
        // Input tree: [4,2,7,1,3,6,9]
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(9);

        invertbinary_lc226 sol = new invertbinary_lc226();
        TreeNode inverted = sol.invertTree(root);

        // Print the entire tree after inversion
        printTree(inverted);
    }

    // Helper to print tree in level order
    static void printTree(TreeNode root) {
        if (root == null) {
            System.out.println("[]");
            return;
        }

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        List<String> res = new ArrayList<>();

        while (!q.isEmpty()) {
            TreeNode node = q.poll();
            if (node == null) {
                res.add("null");
            } else {
                res.add(String.valueOf(node.val));
                q.add(node.left);
                q.add(node.right);
            }
        }

        // remove trailing nulls
        int i = res.size() - 1;
        while (i >= 0 && res.get(i).equals("null")) {
            res.remove(i--);
        }

        System.out.println(res);
    }


    //logic
    public TreeNode invertTree(TreeNode root) {
        if (root == null) return null;

        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);

        root.left = right;
        root.right = left;

        return root;
    }

}
