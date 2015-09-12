package antlen.collections.list;

import antlen.collections.Collection;

import java.util.HashSet;
import java.util.Iterator;

/**
 * Created by antlen on 12/9/15.
 */
public class SingleLinkedList implements Collection {
    protected Node head, tail;

    public SingleLinkedList(){
    }

    public SingleLinkedList(int[] arr){
        for(int i=0; i<arr.length; i++){
            add(arr[i]);
        }
    }

    @Override
    public boolean add(int t) {
        if(head == null){
            head = new Node(t);
            head.next=tail;
            tail = head;
        }else{
            tail.next=new Node(t);
            tail = tail.next;
        }
        return true;
    }

    @Override
    public boolean remove(int t) {
        Node n = head;
        Node previous = null;
        do{
            if(n.value==t){
               if(previous == null){
                   n.next=head;
                   return true;
               }else{
                    previous.next=n.next;
                    return true;
               }
            }
            previous = n;
        }while((n = n.next) !=null);

        return false;
    }

    @Override
    public Iterator iterator() {
        return new Iterator() {
            Node next = head;
            @Override
            public boolean hasNext() {
                return next.next != null;
            }

            @Override
            public Object next() {
                Node value = next;
                next=next.next;
                return value;
            }
        };
    }

    @Override
    public String toString() {
        StringBuilder b = new StringBuilder("[");
        Node n = head;
        do{
            b.append(n.value);
            if(n.next !=null)b.append(",");
        }while((n = n.next) !=null);
        b.append("]");

        return b.toString();
    }

    public int getKFromLast(int k){

        Node n = head;
        Node nn = null;
        int index=0;
        do{
            if(index>=k){
                if(nn==null){
                    nn= head;
                }else {
                    nn = nn.next;
                }
            }
            index++;
        }while((n = n.next) !=null);

        if(nn == null){
            throw new IllegalArgumentException("The list is has less than " + k + " elements");
        }

        return nn.value;
    }

    public void removeDuplicates(){
        HashSet<Integer> dups = new HashSet<>();
        Node n = head;
        Node previous = null;
        do{
            if(dups.contains(n.value)){
                previous.next=n.next;
            }else {
                dups.add(n.value);
                previous = n;
            }
        }while((n = n.next) !=null);
    }

    protected class Node{
        private final int value;
        protected Node next;

        protected Node(int value) {
            this.value = value;
        }
    }
}
