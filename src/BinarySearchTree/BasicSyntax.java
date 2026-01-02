package BinarySearchTree;

import java.util.PrimitiveIterator;

class BasicSyntax {
    private class Node {
        int val;
        Node left;
        Node right;

        public Node(int value) {
            this.val = value;
        }
    }

    private Node root;

    //insertion
    public Node insert( Node root , int value) {
        if (root == null) {
            return new Node(value);
        }

        if (value < root.val) {
            root.left = insert(root.left , value);
        }
        else {
            root.right = insert(root.right , value);
        }

        return root;
    }


    //search
    boolean search(Node root , int key ) {
        while (root != null) {
            if (root.val == key) {
                return true;
            }
            root = key < root.val ? root.left : root.right;
        }
        return false;
    }

    //min and max
    int min(Node root) {
        while (root.left != null) root = root.left;
        return root.val;
    }

    int max(Node root) {
        while (root.right != null) root = root.right;
        return root.val;
    }


    //inorder
    void inorder(Node root) {
        if (root == null) return;
        inorder(root.left);
        System.out.print(root.val + " ");
        inorder(root.right);
    }

    //preorder
    void preorder(Node root) {
        if (root == null) return;
        System.out.print(root.val + " ");
        preorder(root.left);
        preorder(root.right);
    }


    //postorder
    void postorder(Node root) {
        if (root == null) return;
        postorder(root.left);
        postorder(root.right);
        System.out.print(root.val + " ");
    }


    //Successor = smallest value > key
    //Predecessor = largest value < key
    //(Same logic for predecessor; reverse comparisons.)
    Node successor(Node root, int key) {
        Node succ = null;
        while (root != null) {
            if (key < root.val) {
                succ = root;
                root = root.left;
            } else {
                root = root.right;
            }
        }
        return succ;
    }




}
