package BinaryTree;

import java.util.ArrayDeque;

public class symmetrictree_lc101 {
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

        // Array: [1,2,2,null,3,null,3]

        TreeNode root = new TreeNode(1);

        root.left = new TreeNode(2);
        root.right = new TreeNode(2);

        root.left.left = null;
        root.left.right = new TreeNode(3);

        root.right.left = null;
        root.right.right = new TreeNode(3);

        boolean result = isSymmetric(root);
        System.out.println(result);   // expected output: false
    }




//    public static boolean isSymmetric(TreeNode root) {
//        return ismirror(root , root);
//    }
//
//    public static boolean ismirror(TreeNode t1, TreeNode t2) {
//        if (t1 == null && t2 == null) return true;  //every comparsion happens here until one of them is  null
//        if (t1 == null || t2 == null) return false;
//
//        return t1.val == t2.val && ismirror(t1.left, t2.right) && ismirror(t1.right, t2.left );
//    }

    public static boolean isSymmetric(TreeNode root) {
        return ismirror(root.left , root.right);
    }

    private static boolean ismirror(TreeNode t1, TreeNode t2) {
        ArrayDeque<TreeNode[]> stack = new ArrayDeque<>();
        stack.push(new TreeNode[] {t1, t2});

        while (!stack.isEmpty()) {
            TreeNode[] pair = stack.pop();
            TreeNode a = pair[0];
            TreeNode b = pair[1];

            if (a == null && b == null) {
                continue;
            }

            if (a == null || b == null) {
                return false;
            }

            if (a.val != b.val) {
                return false;
            }
            stack.push(new TreeNode[]{a.left , b.right});
            stack.push(new TreeNode[]{a.right , b.left});
        }
        return true;
    }


}
