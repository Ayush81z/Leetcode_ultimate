package DFS;

import com.sun.source.tree.Tree;

import java.util.*;

public class SerializeAndDeserialize_lc297 {
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

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(5);

        SerializeAndDeserialize_lc297 codec = new SerializeAndDeserialize_lc297();

        String serialized = codec.serialize(root);
        System.out.println("Serialized: " + serialized);

        TreeNode deserialized = codec.deserialize(serialized);

        String check = codec.serialize(deserialized);
        System.out.println("After Deserialize -> Serialize: " + check);
    }

    public static String serialize(TreeNode root) {
        StringBuilder ser = new StringBuilder();
        convertroottostring(root , ser);
        return ser.toString();
    }

    public static void convertroottostring(TreeNode root , StringBuilder ser) {
        if (root == null){
            ser.append("null,");  //need a way to differentiate between data
            return;
        }

        ser.append(String.valueOf(root.val)).append(","); //data needs to be seperated

        convertroottostring(root.left , ser);
        convertroottostring(root.right , ser);
    }


    // Decodes your encoded data to tree.
    public static TreeNode deserialize(String data) {
        String[] token = data.split(",");    //splitting the data
        Queue<String> queue = new LinkedList<>(Arrays.asList(token)); //converts the array into a list
        return convertStringtoTree(queue);
    }

    public static TreeNode convertStringtoTree ( Queue<String> queue){
        String val = queue.poll();
        if (val.equals("null")) {
            return null;
        }
        TreeNode node = new TreeNode(Integer.parseInt(val));

        node.left = convertStringtoTree(queue);
        node.right = convertStringtoTree(queue);

        return node;
    }
}
