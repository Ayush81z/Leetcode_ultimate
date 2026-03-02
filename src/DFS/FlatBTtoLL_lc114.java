package DFS;


public class FlatBTtoLL_lc114 {
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


    //check book
    public void flatten(TreeNode root) { //void so return null codn
        TreeNode current = root; //cant change the main root
        while (current != null) {

            if (current.left != null) {  //we check  in left first in terms of the right most node being empty , if it is then insert the whole current.right thing on the right most of current.left

                TreeNode temp = current.left; // creating this to have a track of elements beyond the root value
                while (temp.right != null){ //until we find the right most
                    temp = temp.right; //keeps on going right
                }
                temp.right = current.right; // assigning the values of the whole right tree to the left side's right most
                current.right = current.left; //bringing the left tree to write as the right has been copied to the left before
                current.left = null; //need to make the left null
            }
            current = current.right; //moves to each value to check for left's right most value then replaces the right value to that position happpens until all the left is null
        }
    }
}
