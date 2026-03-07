package DFS;

import com.sun.source.tree.Tree;

import java.nio.file.ClosedWatchServiceException;
import java.util.*;

public class PathfromSourcetodestination {
    public static class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }

    public static void main(String[] args) {

        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(5);
        root.right = new TreeNode(1);

        root.left.left = new TreeNode(6);
        root.left.right = new TreeNode(2);

        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(8);

        root.left.right.left = new TreeNode(7);
        root.left.right.right = new TreeNode(4);

        TreeNode p = root.left;        // 5
        TreeNode q = root.left.right.right; // 4

        PathfromSourcetodestination obj = new PathfromSourcetodestination();
        TreeNode ans = obj.lowestCommonAncestor(root, p, q);

        System.out.println(ans.val);
    }


    //optimal solution
    public static TreeNode lowestCommonAncestor (TreeNode root , TreeNode p , TreeNode q) {
        if (root  == null) return null;

        //if atleast one of them matches then return, that means just to have a consideration of one existing node
        //potential lca
        if (p == root || q == root) {
            return root;
        }

        TreeNode left = lowestCommonAncestor(root.left , p , q);
        TreeNode right = lowestCommonAncestor(root.right , p ,q);

        //if both are not null that means that both the values are found in left and right subtree respectively
        if (left != null && right != null) {
            return root;
        }

        //if one of them is not null but the other one is null , then that means it is in left or right subtree
        return (left != null) ? left : right;
     }


    //o(n) , this checks everything in a single traversal
//    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q){
//        List<TreeNode> path1 = new ArrayList<>();
//        List<TreeNode> path2 = new ArrayList<>();
//
//        if ( !findpath(root , p ,path1) || !findpath(root ,q , path2) ) {
//            return null;
//        }
//
//        int i = 0;
//        for (i = 0; i < path1.size() && i < path2.size() ; i++) {
//            if (path1.get(i) != path2.get(i)) {
//                return path1.get(i-1);
//            }
//        }
//
//        return path1.get(i-1);
//    }
//
//    public static boolean findpath(TreeNode root ,TreeNode ele ,List<TreeNode> path) {
//
//        if (root == null) return false;
//
//        path.add(root);
//
//        if (root == ele || findpath(root.left , ele , path) || findpath(root.right , ele , path )) {
//            return true;
//        }
//
//        path.remove(path.size()-1);
//
//        return false;
//    }


}
