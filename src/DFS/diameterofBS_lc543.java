package DFS;

public class diameterofBS_lc543 {
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
        // Tree: [1,2,null,3,4]
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);

        diameterofBS_lc543 sol = new diameterofBS_lc543();
        System.out.println(sol.diameterOfBinaryTree(root)); // expected: 2
    }


    int diameter = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        height(root);
        return diameter-1;
    }

    int height(TreeNode root) {
        if (root == null) return 0;

        int leftheight= height(root.left);
        int rightheight = height(root.right);

        int dia = leftheight + rightheight + 1;
        diameter = Math.max(dia , diameter);  //update diameter every call if max

        return Math.max(leftheight , rightheight) +1;  //calculate childs height
    }

}


