package crackingthecodinginteview.section4;

import antlen.collections.tree.BinarySearchTree;
import antlen.collections.tree.BinaryTree;

import java.util.LinkedList;

/**
 * Created by antlen on 3/9/15.
 */
public class TreesAndGraphsSoltions {

    private static final PostAction NOTHING = new PostAction() {
        @Override
        public void doAction(BinarySearchTree tree) {
        }
    };
    public static final int[] DEFAULT_ARR = new int[]{10, 15, 8, 20, 30, 17, 5, 9, 3, 7, 4, 16};

    public static void main(String args[]){
        test_4_5();

        test_4_4();

        test_4_1();
        test_4_3();
    }

    public static void test_4_1(){
        BinarySearchTree tree = buildTree(new PostAction() {
            @Override
            public void doAction(BinarySearchTree tree) {
                System.out.println(tree.isBalanced());
            }
        });
    }

    public static void test_4_3(){
        int[] arr = {3,4,5,7,8,9,10,15,16,17,20,25,30,};
        BinaryTree tree = BinaryTree.toTree(arr);
        System.out.println(tree.isBinarySearchTree());
    }

    public static void test_4_5(){
        int[] arr = {3,4,5,7,8,9,10,15,16,17,20,25,30,};
        BinaryTree tree = BinaryTree.toTree(arr);
        System.out.println(tree.isBinarySearchTree());

        System.out.println(buildTree().isBinarySearchTree());
    }

    public static void test_4_4(){
        BinarySearchTree tree = buildTree(new int[]{12, 15, 13, 8, 20, 30, 17, 5, 9, 10, 3, 7, 4, 16});
        for(LinkedList<BinarySearchTree.Node>  l : tree.getLevelLinkedLists()){
            System.out.println();
            System.out.println("--");
            for(BinarySearchTree.Node n : l){
                System.out.print(n + "\t");
            }
        }
    }

    private static BinarySearchTree buildTree() {
        return buildTree(NOTHING);
    }

    private static BinarySearchTree buildTree(int[] arr) {
        return buildTree(arr, NOTHING);
    }

    private static BinarySearchTree buildTree(PostAction action) {
        return buildTree(DEFAULT_ARR, action);
    }

    private static BinarySearchTree buildTree(int[] arr, PostAction action) {
        BinarySearchTree tree = new BinarySearchTree();
        for(int i : arr){
            tree.add(i);
            action.doAction(tree);
        }

        return tree;
    }

    private interface PostAction{
        void doAction(BinarySearchTree tree);
    }
}
