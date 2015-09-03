package antlen.collections.tree;

/**
 * Created by antlen on 3/9/15.
 */
public class TreeTest {

    public static void main(String args[]){
        int[] arr = {1, 3,7,9,12,15,19,22,34,45,55,56,57,58};
        BinarySearchTree tree = BinarySearchTree.toTree(arr);
        System.out.println(tree.isBalanced());
        //int[] arr =
    }


    public static void testBalanced(){
        BinarySearchTree tree = new BinarySearchTree();
        tree.add(8);
        System.out.println(tree.isBalanced());
        tree.add(20);
        System.out.println(tree.isBalanced());
        tree.add(10);
        System.out.println(tree.isBalanced());
        tree.add(15);
        System.out.println(tree.isBalanced());
        tree.add(30);
        System.out.println(tree.isBalanced());
        tree.add(17);
        System.out.println(tree.isBalanced());
        tree.add(5);

        System.out.println(tree.isBalanced());
    }
}
