package antlen.collections.sort;

import antlen.collections.Util;

/**
 * Created by antlen on 15/08/2015 16:13.
 */
public class SelectionSort implements Sorter{

    @Override
    public int[] sort(int[] c) {
        int min;
        for(int j=0; j< c.length; j++){
            min = j;
            for(int i = j+1; i< c.length; i++){
                if(c[i]<c[min]){
                    min = i;
                }
            }
            if(min != j){
                Util.swap(c, j, min);
            }
        }
        return c;
    }
}
