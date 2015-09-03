package antlen.collections.sort;

import antlen.collections.Util;

import java.util.Arrays;

/**
 * Created by antlen on 15/08/2015 16:33.
 */
public class QuickSort implements Sorter {

    @Override
    public int[] sort(int[] a) {
         quicksort(a, 0, a.length - 1);
        return a;
    }

    private final int[] quicksort(int[] a, int low, int high){
        int lowest = low;
        int highest = high;
        int pivot = a[low+(high - low) / 2];
        while (low <= high) {
            while (a[low] < pivot) {
                low++;
            }
            while (a[high] > pivot) {
                high--;
            }
            if (low <= high) {
                Util.swap(a, low, high);
                low++;
                high--;
            }
        }
        if (lowest < highest)
            quicksort(a, lowest, high);
        if (low < highest)
            quicksort(a, low, highest);

        return a;
    }


}
