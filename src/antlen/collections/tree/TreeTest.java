package antlen.collections.tree;

/**
 * Created by antlen on 3/9/15.
 */
public class TreeTest {

    public static void main(String args[]){
        int[] arr = {3,4,5,7,8,9,10,15,16,17,20,25,30,};
        BinarySearchTree tree = BinarySearchTree.toTree(arr);
        System.out.println(tree);
        //int[] arr =
       // testBalanced();
    }


    public static void testBalanced(){
        BinarySearchTree tree = new BinarySearchTree();

        tree.add(10);
        System.out.println(tree.isBalanced());
        tree.add(15);
        System.out.println(tree.isBalanced());
        tree.add(8);
        System.out.println(tree.isBalanced());
        tree.add(20);
        System.out.println(tree.isBalanced());

        tree.add(30);
        System.out.println(tree.isBalanced());
        tree.add(17);
        System.out.println(tree.isBalanced());
        tree.add(5);
        System.out.println(tree.isBalanced());

        tree.add(9);
        System.out.println(tree.isBalanced());
        tree.add(3);
        System.out.println(tree.isBalanced());
        tree.add(7);
        System.out.println(tree.isBalanced());
        tree.add(4);
        System.out.println(tree.isBalanced());
        tree.add(16);
        System.out.println(tree.isBalanced());

        System.out.println(tree);
    }
}
