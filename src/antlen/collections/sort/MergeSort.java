package antlen.collections.sort;

import antlen.collections.Util;

import java.util.Arrays;

/**
 * Created by antlen on 15/08/2015 16:33.
 */
public class MergeSort implements Sorter {

    @Override
    public int[] sort(int[] a) {
        int[] destination = new int[a.length];

        mergesort(a, destination, 0, a.length );

        return destination;
    }

    private final void mergesort(int[] source, int[] destination, int start, int end){
        if(end - start < 2) return;

        int middle = (end + start) / 2;

        mergesort(source, destination, start, middle);
        mergesort(source, destination, middle, end);

        int index0 = start;
        int index1 = middle;

     //   System.out.println(start+" - "+end+"  destination(before)= " + Arrays.toString(destination));
        for(int i= start; i < end; i++){
            if(index0 < middle && (index1 >=end || source[index0] <= source[index1])){
                destination[i]= source[index0++];
            }else{
                destination[i]=source[index1++];
            }
        }
  //      System.out.println("destination(after)= " + Arrays.toString(destination));
  //      System.out.println("source (before) = " + Arrays.toString(source));
        for(int i= start; i < end; i++){
            source[i]=destination[i];
        }
  //      System.out.println("source (after) = " + Arrays.toString(source));
    }


}
