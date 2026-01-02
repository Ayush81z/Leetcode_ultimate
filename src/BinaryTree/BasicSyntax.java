package BinaryTree;

import com.sun.source.tree.BinaryTree;

import java.util.Scanner;

class BasicSyntax {

    private static class Node{
        int val;
        Node left;
        Node right;

        public Node(int value) {
            this.val = value;
        }
    }

    private Node root;

    //insert elements
    public void insertRoot(Scanner scanner) {
        System.out.println("Enter the Root node value: ");
        int value = scanner.nextInt();
        root = new Node(value);
        populate(scanner , root);

    }

    //node is basically the new root
    private static void populate(Scanner scanner, Node currRoot) {
        System.out.println("Do you wanna enter the left side of : " +currRoot.val);
        boolean left = scanner.nextBoolean();
        if (left) {
            System.out.println("Enter the value of Left of :"+ currRoot.val);
            int value = scanner.nextInt();
            currRoot.left = new Node(value);
            populate(scanner , currRoot.left);
        }

        System.out.println("Do you wanna enter the Right side of : " +currRoot.val);
        boolean right = scanner.nextBoolean();
        if (right) {
            System.out.println("Enter the value of Right of :"+ currRoot.val);
            int value = scanner.nextInt();
            currRoot.right = new Node(value);
            populate(scanner , currRoot.right);
        }


    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BasicSyntax tree = new BasicSyntax();
        tree.insertRoot(scanner);
    }
}
