package antlen.collections.tree;

import antlen.collections.Collection;

import java.util.Iterator;

/**
 * Created by antlen on 01/09/2015 22:16.
 */
public class BinarySearchTree implements Collection {

    private Node root;

    public static BinarySearchTree toTree(int[] arr){
       // int[] arr = {1, 3,7,9,12,15,19, 25};
        BinarySearchTree tree = new BinarySearchTree();
        tree.root = new Node(arr[0]);
        addToTree(arr, tree.root, 1, arr.length);
        return tree;
    }

    private static void addToTree(int[] arr, Node n, int start, int end){
        if(start == end || start > end){
            return;
        }

        n.left=new Node(arr[start]);

        if(start+1==end && end >= arr.length) return;

        int length = end - start;
        if(length == 1){
            n.right=new Node(arr[(end)]);
            return;
        }

        int half = start + (int)Math.floor(length/ 2);
        n.right=new Node(arr[(half)]);
        addToTree(arr, n.left, start +1, half-1);
        addToTree(arr, n.right, half+1, end);

    }

    @Override
    public boolean add(int i) {
        final Node newNode = new Node(i);
        if(root == null){
            root = newNode;
            return true;
        }else if(i < root.value){
            newNode.left=root;
            root=newNode;
            return true;
        }
        else{
            return insert(root, newNode);
        }
    }

    private boolean insert(Node n, Node newNode){
        final int i = newNode.value;
        if((n.left!=null && n.left.value==i) || (n.right!=null && n.right.value==i)){
            return false;
        }
        if(n.left == null){
            n.left=newNode;
            return true;
        }else if(n.right==null){
            if(i > n.left.value) {
                n.right = newNode;
            }else{
                n.right=n.left;
                n.left=newNode;
            }
            return true;
        }else if(i < n.left.value){
            newNode.left=n.left;
            n.left=newNode;
            return true;
        }else if(i < n.right.value){
            newNode.right=n.right;
            n.right=newNode;
            return true;
        }else if(i > n.right.value){
            return insert(n.right, newNode);
        }else if(i > n.left.value){
            return insert(n.left, newNode);
        }

        return false;
    }

    public boolean isBalanced(){
        int balance =  checkHeight(root, 1);

        System.out.println(balance);
        return balance != -1;
    }

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

        System.out.println(value +"\t "+ n.value);
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
    }
}
