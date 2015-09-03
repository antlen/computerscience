package antlen.collections.tree;

import antlen.collections.Collection;

import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.Queue;
import java.util.Stack;

/**
 * Created by antlen on 01/09/2015 22:16.
 */
public class BinarySearchTree implements Collection {

    private Node root;

    public static BinarySearchTree toTree(int[] arr){
        BinarySearchTree tree = new BinarySearchTree();

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

    @Override
    public boolean add(int i) {
        final Node newNode = new Node(i);
        if(root == null){
            root = newNode;
            return true;
        }
        else{
            insert(root, newNode);
            return true;
        }
    }

    private void insert(Node n, Node newNode){
        if(newNode == null) return;

        final int i = newNode.value;
        if((n.left!=null && n.left.value==i) || (n.right!=null && n.right.value==i)){
            return;
        }

        if(newNode.value < n.value){
            if(n.left == null){
                n.left=newNode;
            }
            else if(n.left.value < newNode.value){
                newNode.left=n.left;
                n.left=newNode;
                swapEdges(n);
            }else if(n.right== null) {
                n.right=n.left;
                n.left=newNode;
                swapEdges(n);
            }
            else{
                insert(n.left, newNode);
            }
        }else if(newNode.value > n.value){
            if(n.right == null){
                n.right=newNode;
            }
            else if(n.right.value > newNode.value){
                newNode.right=n.right;
                n.right=newNode;
                swapEdges(n);
            }else if(n.left== null) {
                n.left=n.right;
                n.right=newNode;
                swapEdges(n);
            }else{
                insert(n.right, newNode);
            }
        }
    }

    private void swapEdges(Node parent){

        Node[] nodes = new Node[4];
        if(parent.left.value > parent.right.value){
            Node tmp = parent.left;
            parent.left=parent.right;
            parent.right=tmp;
        }
        addToArrayAndClear(parent.left, nodes, 0);
        addToArrayAndClear(parent.right, nodes, 2);

        for(Node nn : nodes){
            insert(root, nn);
        }
    }

    private void addToArrayAndClear(Node n, Node[] nodes, int index) {
        if(n != null) {
            nodes[index++]=n.left;
            nodes[index++]=n.right;
            n.left = null;
            n.right = null;
        }
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
    private int checkHeight(Node n, int tolerance){
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
    public boolean remove(int t) {
        return false;
    }

    @Override
    public Iterator iterator() {
        return null;
    }


    @Override
    public String toString() {
        Queue<Node> q = new ArrayDeque<>();
        q.add(root);
        return print(q, new StringBuilder()).toString();
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

    private static class Node{
        protected int value;
        protected Node left;
        protected Node right;

        public Node() {

        }

        public Node(int value) {
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
