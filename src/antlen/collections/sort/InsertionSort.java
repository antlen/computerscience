package antlen.collections.sort;

import antlen.collections.Util;

import java.util.Arrays;

/**
 * Created by antlen on 15/08/2015 16:33.
 */
public class InsertionSort implements Sorter {

    @Override
    public int[] sort(int[] c) {
        for(int i=0; i < c.length; i++){
            int j = i;
            while(j >0 && c[j] < c[j-1]){
                Util.swap(c, j, j-1);
                j--;
            }
        }
        return c;
    }
}
