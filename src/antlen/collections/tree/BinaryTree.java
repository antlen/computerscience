package antlen.collections.tree;

import antlen.collections.Collection;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.util.*;

/**
 * Created by antlen on 01/09/2015 22:16.
 */
public class BinaryTree implements Externalizable {

    protected Node root;
    private int size =0;

    protected BinaryTree(){
    }

    public BinaryTree(int[] arr){
        root= createMinimalBST(arr, 0, arr.length - 1);
    }

    private Node createMinimalBST(int arr[], int start, int end){
        if (end < start) {
            return null;
        }
        int mid = (start + end) / 2;
        Node n = create(arr[mid]);
        n.left=createMinimalBST(arr, start, mid - 1);
        n.right=createMinimalBST(arr, mid + 1, end);
        if(n.left!=null) n.left.parent=n;
        if(n.right!=null) n.right.parent=n;
        return n;
    }

    public int[] createOrderedArray(){
        int[] arr = new int[size];
        createOrderedArray(root, arr, 0, size-1);
        return arr;
    }

    private void createOrderedArray(Node n, int arr[], int start, int end){
        if (start > end) {
            return;
        }
        int index = (start + end) / 2;
        arr[index]=n.value;
        createOrderedArray(n.left, arr, start, index - 1);
        createOrderedArray(n.right, arr, index + 1, end);

    }

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        int[] arr = createOrderedArray();
        for(int i =0; i < arr.length; i ++){
            out.writeInt(arr[i]);
        }
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        int[] arr = new int[in.available()/4];
        int index = 0;
        while(in.available()>=4){
            arr[index++]=in.readInt();
        }
        root= createMinimalBST(arr, 0, arr.length - 1);
    }

    public boolean isBinarySearchTree() {
        return isBinarySearchTree(root);
    }

    private boolean isBinarySearchTree(Node n){
        return validateLt(n.left, n.value) && validateGt(n.right, n.value);
    }

    private boolean validateLt(Node n, int value){
         if(n==null) return true;

        return n.value <= value && isBinarySearchTree(n);
    }

    private boolean validateGt(Node n, int value){
        if(n==null) return true;

        return n.value >= value && isBinarySearchTree(n);

    }

    protected Node findNodeForValue(Node n, int i){
        if(n == null) return null;
        if(n.value == i) return n;
        Node nn = findNodeForValue(n.left,i);
        if(nn!=null) return nn;

        return findNodeForValue(n.right,i);
    }

    public boolean isSubTree(Node n){
        return isIdenticle(n, findNodeForValue(root, n.value));

    }

    public boolean isIdenticle(Node n, Node nn){
        if(n == null && nn == null) return true;

        if(n==null || nn==null || n.value != nn.value) return false;

        return isIdenticle(n.left, nn.left) && isIdenticle(n.right, nn.right);
    }

    public boolean isBalanced(){
        int balance =  checkHeight(root, 1);

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
        builder.deleteCharAt(builder.length() - 1);
        return builder;
    }

    protected Node create(int i){
        size++;
        return new Node(i);
    }

    protected Node create(Node parent, int i){
        size++;
        return new Node(parent, i);
    }

    public Node findCommonAncestor(Node n1, Node n2){

        Node n = n1;
        while(n!=null && !isOnBranch(n, n2)){
            n =n.parent;
        }

        return n;
    }

    public boolean isOnBranch(Node branchParent, Node n){
        if(branchParent==null) return false;
        if(branchParent==n) return true;

        return isOnBranch(branchParent.left, n) || isOnBranch(branchParent.right, n);
    }

    public class Node{
        protected final int value;
        protected Node parent;
        protected Node left;
        protected Node right;

        private Node(int value) {
            this.value = value;
        }

        private Node(Node parent, int value) {
            this.parent=parent;
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
