package BinaryTree;

public class SameTree_lc100 {
    public static class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) {
          this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }

    public static void main(String[] args) {
        // Tree 1: [1,2,3]
        TreeNode p = new TreeNode(1);
        p.left = new TreeNode(2);
        p.right = new TreeNode(3);

        // Tree 2: [1,2,3]
        TreeNode q = new TreeNode(1);
        q.left = new TreeNode(2);
        q.right = new TreeNode(3);

        boolean result = isSameTree(p, q);
        System.out.println(result);
    }

    public static boolean isSameTree(TreeNode p, TreeNode q) {
        if (p== null || q==null) { //if both are null return true or if one of them is null then return false
            return p==q;
        }
        return p.val == q.val && isSameTree(p.left,q.left) && isSameTree(p.right,q.right) ;
    }
}
