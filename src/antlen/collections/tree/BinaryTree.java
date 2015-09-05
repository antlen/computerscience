package antlen.collections.tree;

import antlen.collections.Collection;

import java.util.*;

/**
 * Created by antlen on 01/09/2015 22:16.
 */
public class BinaryTree {

    protected Node root;

    public static BinaryTree toTree(int[] arr){
        BinaryTree tree = new BinaryTree();

        tree.root= createMinimalBST(arr, 0, arr.length - 1);

        return tree;
    }


    private static Node createMinimalBST(int arr[], int start, int end){
        if (end < start) {
            return null;
        }
        int mid = (start + end) / 2;
        Node n = new Node(arr[mid]);
        n.left=createMinimalBST(arr, start, mid - 1);
        n.right=createMinimalBST(arr, mid + 1, end);
        return n;
    }

    public boolean isBinarySearchTree() {
        return isBinarySearchTree(root);
    }

    private boolean isBinarySearchTree(Node n){
        return validateLt(n.left, n.value) && validateGt(n.right, n.value);
    }

    private boolean validateLt(Node n, int value){
         if(n==null) return true;


        boolean v = n.value <= value;
        System.out.println(n.value + " is " + (v ? "less than " : "more than ") + value);
        return v && isBinarySearchTree(n);
    }

    private boolean validateGt(Node n, int value){
        if(n==null) return true;


        boolean v = n.value >= value;
        System.out.println(n.value + " is " + (!v ? "less than " : "more than ") + value);
        return v && isBinarySearchTree(n);

    }

    public boolean isBalanced(){
        int balance =  checkHeight(root, 1);

        System.out.println(balance);
        return balance != -1;
    }

    /**
     * DFS check height.
     * @param n
     * @param tolerance
     * @return
     */
    protected int checkHeight(Node n, int tolerance){
        if(n == null) return 0;

        int left = checkHeight(n.left, tolerance);
        if(left == -1){
            return -1;
        }
        int right = checkHeight(n.right, tolerance);
        if(right == -1 || Math.abs(left -right) > tolerance){
            return -1;
        }

        int value =  Math.max(left, right) +1;

        return value;
    }


    @Override
    public String toString() {
        Queue<Node> q = new ArrayDeque<>();
        q.add(root);
        return print(q, new StringBuilder()).toString();
    }

    public List<LinkedList<Node>> getLevelLinkedLists(){
        ArrayList<LinkedList<Node>> linkedLists = new ArrayList<>();
        index(root, linkedLists, 0);

        return linkedLists;
    }


    private void index(Node n, ArrayList<LinkedList<Node>> elements, int index){
        if(n == null) return;

        index(n.left, elements, index+1);
        index(n.right, elements, index+1);

        while(elements.size() <= index){
            elements.add(new LinkedList<>());
        }
        LinkedList<Node> ll = elements.get(index);
        ll.add(n);

    }
    /**
     * BFS toString
     * @param queue
     * @param builder
     * @return
     */
    private StringBuilder print(Queue<Node> queue, StringBuilder builder){

        Node n = null;
        while(( n = queue.poll()) !=null ){

            builder.append(n.value).append(" ,");


            if(n.left !=null) queue.add(n.left);
            if(n.right !=null) queue.add(n.right);
        }
        builder.deleteCharAt(builder.length()-1);
        return builder;
    }

    public static class Node{
        protected int value;
        protected Node left;
        protected Node right;

        protected Node(int value) {
            this.value = value;
        }
        @Override
        public String toString() {
            return Integer.toString(value);
        }

        public boolean hasChildren(){
            return left  != null || right !=null;
        }
    }
}
