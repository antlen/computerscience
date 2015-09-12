package crackingthecodinginteview.section2;

import antlen.collections.list.SingleLinkedList;

/**
 * Created by antlen on 12/9/15.
 */
public class LinkedLists {

    public static void main (String [] args){
        test_1_2();
    }

    public static void test_1_1(){
        SingleLinkedList ll = new SingleLinkedList(new int[]{1,3,5,3,1,6,7,6,5,5,4,3,9});

        System.out.println(ll);
        ll.removeDuplicates();;
        System.out.println(ll);
    }


    public static void test_1_2(){
        SingleLinkedList ll = new SingleLinkedList(new int[]{1,3,5,3,1,6,7,6,5,5,4,3,9});

        System.out.println(ll);
        int i = ll.getKFromLast(3);
        System.out.println(i);

         i = ll.getKFromLast(6);
        System.out.println(i);
        i = ll.getKFromLast(8);
        System.out.println(i);

        i = ll.getKFromLast(9);
        System.out.println(i);

        i = ll.getKFromLast(13);
        System.out.println(i);

        try {
            i = ll.getKFromLast(14);
            System.out.println(i);
        }catch(Exception e){
            e.printStackTrace();;
        }
    }
}
