package SegmentTrees;
public class main {
    public static void main(String[] args) {
        int[] arr = {3, 8, 6, 7, -2, -8, 4, 9};
        BasicSyntax segmentTree = new BasicSyntax(arr);

        System.out.println(segmentTree.query(1,6));
    }
}
