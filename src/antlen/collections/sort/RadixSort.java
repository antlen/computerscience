package antlen.collections.sort;

import antlen.collections.Util;

import java.util.*;

/**
 * Created by antlen on 15/08/2015 16:33.
 */
public class RadixSort implements Sorter {

    @Override
    public int[] sort(int[] a) {

        radixsort(a);

        return a;
    }


    public void radixsort(int[] input) {
        final int RADIX = 10;
        // declare and initialize bucket[]
        List<Integer>[] bucket = new ArrayList[RADIX];
        for (int i = 0; i < bucket.length; i++) {
            bucket[i] = new ArrayList<Integer>();
        }

        // sort
        boolean maxLength = false;
        int tmp = -1, placement = 1;
        while (!maxLength) {
            maxLength = true;
            // split input between lists
            for (Integer i : input) {
                tmp = i / placement;
                bucket[tmp % RADIX].add(i);
                if (maxLength && tmp > 0) {
                    maxLength = false;
                }
            }
            // empty lists into input array
            int a = 0;
            for (int b = 0; b < RADIX; b++) {
                for (Integer i : bucket[b]) {
                    input[a++] = i;
                }
                bucket[b].clear();
            }
            // move to next digit
            placement *= RADIX;
        }
    }

    private int getIndex(int digit, int value) {
        return ((int)(value / Math.pow(10, digit)) % 10);
    }


}
