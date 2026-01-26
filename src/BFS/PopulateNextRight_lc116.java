package BFS;

import java.util.*;

public class PopulateNextRight_lc116 {
    public static class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }

    public static void main(String[] args) {
        // Perfect binary tree: [1,2,3,4,5,6,7]
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        PopulateNextRight_lc116 sol = new PopulateNextRight_lc116();
        root = sol.connect(root);

        // Print next pointers level-wise
        Node level = root;
        while (level != null) {
            Node curr = level;
            while (curr != null) {
                System.out.print(curr.val + " -> ");
                curr = curr.next;
            }
            System.out.println("null");
            level = level.left;
        }
    }

    public Node connect(Node root) {
       if (root == null) return null;
       Node leftnode = root;

       while (leftnode.left != null) {
           Node current = leftnode; //current level

           while (current != null) { //until there is no node in current level
               current.left.next = current.right; //linking within a node
               if (current.next != null) {
                   current.right.next = current.next.left; //linking in between nodes
               }
               current = current.next; //same level next node
           }
           leftnode = leftnode.left; //go left everytime
       }
        return root;
    }
}
