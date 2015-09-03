package crackingthecodinginteview.section4;

import antlen.collections.tree.BinarySearchTree;

/**
 * Created by antlen on 3/9/15.
 */
public class TreesAndGraphsSoltions {

    public static void main(String args[]){
        test_4_1();
        test_4_3();
    }


    public static void test_4_3(){
        int[] arr = {3,4,5,7,8,9,10,15,16,17,20,25,30,};
        BinarySearchTree tree = BinarySearchTree.toTree(arr);
        System.out.println(tree);
    }

    public static void test_4_1(){
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
