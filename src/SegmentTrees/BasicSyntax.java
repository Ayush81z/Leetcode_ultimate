package SegmentTrees;

public class BasicSyntax {
     Node root;

    private static class Node {
        int data;
        int startInterval;
        int endInterval;
        Node left;
        Node right;

        public Node (int StartInterval , int EndInterval) {
            this.startInterval = StartInterval;
            this.endInterval = EndInterval;
        }

    }



    public BasicSyntax(int[] arr) {//create a tree using this array
        this.root = constructTree(arr, 0, arr.length-1);
    }

    private Node constructTree(int[] arr,int startIndex , int endIndex) {
        //is the start == end , yes ? continue
         if (startIndex == endIndex) {
             //leaf
             Node leaf = new Node(startIndex , endIndex );
             leaf.data = arr[startIndex];
             return leaf;
         }

         //start != end , then create a new node with start and end mentioned
         Node node = new Node(startIndex, endIndex);

         int mid = (startIndex + endIndex) / 2;

         node.left = constructTree(arr , startIndex , mid);
         node.right = constructTree(arr , mid+1 , endIndex);

         node.data = node.left.data + node.right.data;
         return node;
    }

    public void display(Node node) {
        String str = "";
        if (node.left != null) {
            str = str + "Interval=["+node.startInterval + "-" + node.endInterval + "] and data : " + node.data + " ->";
        }
        else {
            str = str + "No Left Child";
        }

        if (node.right != null) {
            str = str + "Interval=["+node.right.startInterval + "-" + node.right.endInterval + "] and data : " + node.right.data + " ->";
        }
        else {
            str = str + "No Right child" ;
        }

        System.out.println(str);

        //call recursion
        if (node.left != null) {
            display(node.left);
        }

        if (node.right != null) {
            display(node.right);
        }
    }

    //query
    public int query ( int qsi , int qei) {
        return this.query(this.root , qsi , qei);
    }

    public int query( Node node , int qsi , int qei) {
        if (node.startInterval >= qsi && node.endInterval <= qei) {
            //node is completely lying inside query
            return node.data;
        }
        else if (node.startInterval > qei || node.endInterval < qsi){
            return 0;
        }
        else {
            return this.query(node.left , qsi , qei) + query(node.right , qsi , qei);
        }
    }

    //update
    public void update(int index, int value) {
        this.root.data = update(this.root, index, value);
    }

    private int update(Node node, int index, int value) {
        if (index >= node.startInterval&& index <= node.endInterval){
            if(index == node.startInterval && index == node.endInterval) {
                node.data = value;
                return node.data;
            } else {
                int leftAns = update(node.left, index, value);
                int rightAns = update(node.right, index, value);
                node.data = leftAns + rightAns;
                return node.data;
            }
        }
        return node.data;
    }

}
