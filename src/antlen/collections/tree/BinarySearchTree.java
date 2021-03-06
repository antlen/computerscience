package antlen.collections.tree;

import antlen.collections.Collection;

import java.util.*;

/**
 * Created by antlen on 01/09/2015 22:16.
 */
public class BinarySearchTree extends BinaryTree implements Collection {

    public BinarySearchTree() {
        super();
    }

    public BinarySearchTree(int[] arr) {
        super(arr);
    }

    public Node findNodeForValue(int i){
        return findNodeForValue(root, i);
    }

    @Override
    protected Node findNodeForValue(Node n, int i){
        if(n == null) return null;
        if(n.value == i) return n;
        if(n.value > i)
            return findNodeForValue(n.left,i);
        else
            return findNodeForValue(n.right,i);
    }

    @Override
    public boolean add(int i) {
        final Node newNode = create(i);
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
                newNode.parent=n;
            }
            else{
                insert(n.left, newNode);
            }
        }else if(newNode.value > n.value){
            if(n.right == null){
                n.right=newNode;
                newNode.parent=n;
            }
            else{
                insert(n.right, newNode);
            }
        }
    }

    /*private void swapEdges(Node parent){

        Node[] nodes = new Node[4];
        if(parent.left != null && parent.right != null && parent.left.value > parent.right.value){
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
        if (n != null) {
            nodes[index++] = n.left;
            nodes[index++] = n.right;
            n.left = null;
            n.right = null;
        }
    }
*/

    @Override
    public boolean remove(int t) {
        return false;
    }

    @Override
    public Iterator iterator() {
        return null;
    }


}
