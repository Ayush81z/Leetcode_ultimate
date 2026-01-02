package BinaryTree;

public class avl_main_test {
    public static void main(String[] args) {
        AVL_TREES tree = new AVL_TREES();
        for (int i = 0; i < 10000; i++) {
            tree.insert(i);
        }
        System.out.println(tree.height());
    }
}
