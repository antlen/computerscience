package crackingthecodinginteview.section4;

import antlen.collections.tree.BinarySearchTree;
import antlen.collections.tree.BinaryTree;

import java.io.*;
import java.util.Arrays;
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
        test_4_7();


        testSerialize();

        test_4_5();

        test_4_4();

        test_4_1();
        test_4_3();
    }

    public static void testSerialize(){
        System.out.println("------------------------SERIALIZE------------------------");
        int[] arr = {3,4,5,7,8,9,10,15,16,17,20,25,30};
        BinarySearchTree tree = new BinarySearchTree(arr);
        tree.add(12);
        print(tree);

        System.out.println(Arrays.toString(arr));
        System.out.println(Arrays.toString(tree.createOrderedArray()));


        System.out.println("serializing..........");
        byte[] treeAsBytes = null;
        try (ByteArrayOutputStream bos = new ByteArrayOutputStream();
             ObjectOutput out = new ObjectOutputStream(bos)) {

            out.writeObject(tree);
            treeAsBytes = bos.toByteArray();
        }
        catch (IOException ex) {
           ex.printStackTrace();
        }

        try (ByteArrayInputStream bin = new ByteArrayInputStream(treeAsBytes);
             ObjectInput in = new ObjectInputStream(bin)) {

            BinaryTree deserializedTree = (BinaryTree)in.readObject();

            print(deserializedTree);
            System.out.println(Arrays.toString(deserializedTree.createOrderedArray()));
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }

        System.out.println("--------------------------------------------------");

    }

    public static void test_4_7(){
        System.out.println("------------------------4.5------------------------");
        int[] arr = {3,4,5,7,8,9,10,15,16,17,20,25,30, 40, 33, 37, 55, 49, 52, 60, 67};
        BinarySearchTree tree = new BinarySearchTree(arr);
        print(tree);

        BinaryTree.Node n1 = tree.findNodeForValue(67);
        BinaryTree.Node n2 = tree.findNodeForValue(30);


        BinaryTree.Node common = tree.findCommonAncestor(n1, n2);

        System.out.println("common = " + common);

        System.out.println("--------------------------------------------------");
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
        int[] arr = {3,4,5,7,8,9,10,15,16,17,20,25,30};
        BinaryTree tree = new BinarySearchTree(arr);
        System.out.println(tree.isBinarySearchTree());
    }

    public static void test_4_5(){
        System.out.println("------------------------4.5------------------------");
        int[] arr = {3,4,5,7,8,9,10,15,16,17,20,25,30};
        BinaryTree tree = new BinarySearchTree(arr);
        System.out.println(tree.isBinarySearchTree());

        print(tree);
        System.out.println("--------------------------------------------------");
    }

    public static void test_4_4(){
        BinarySearchTree tree = buildTree(new int[]{12, 15, 13, 8, 20, 30, 17, 5, 9, 10, 3, 7, 4, 16});
        print(tree);
    }

    private static void print(BinaryTree tree) {
        for(LinkedList<BinaryTree.Node> l : tree.getLevelLinkedLists()){
            System.out.println();
            System.out.println("--");
            for(BinarySearchTree.Node n : l){
                System.out.print(n + "\t");
            }
        }
        System.out.println("\n--");
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
