package BFS;

import com.sun.source.tree.Tree;

public class Iscousin_lc993 {
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
        // Tree: [1,2,3,4]
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.right = new TreeNode(5);

        int x = 5;
        int y = 4;

        Iscousin_lc993 sol = new Iscousin_lc993();
        System.out.println(sol.isCousins(root, x, y));
    }

    public boolean isCousins(TreeNode root, int x, int y) {
        TreeNode xval = findnode(root , x); //to check if the nodes are present or not
        TreeNode yval = findnode(root , y);

        //two checks :
        //1) the level of nodes
        //2) and if nodes are siblings , if they are then not a cousin
        return (level(root , xval ,0) == level(root ,  yval , 0)) && !issiblings(root , xval , yval);
    }

    public TreeNode findnode(TreeNode node, int val) {
        if (node == null) return null; //return null if not present

        if (node.val == val) {
            return node;  //return if the target is present in the tree
        }

        TreeNode n = findnode(node.left , val);
        if (n != null) return n;  //actual return

        return findnode(node.right , val);
    }

    public boolean issiblings(TreeNode node , TreeNode x , TreeNode y) {
        if (node == null) return false;


        /* to check all parameters
       1) check if they are matching the target at sibling position ot not  and also to check for other values like left = x and then for left = y also.
       2) do recursion to check all nodes.
         */
        return (node.left == x && node.right == y) || (node.left == y && node.right == x) ||issiblings(node.left , x ,y ) || issiblings(node.right , x, y);
    }

    public int level (TreeNode node , TreeNode x , int lvl) {
        if (node == null) return 0;

        if (node == x) {
            return lvl;  //recursion return
        }

        int l = level(node.left , x , lvl+1);
        if ( l != 0) {
            return l; //actual return
        }
        return level(node.right ,x , lvl+1);
    }


}
