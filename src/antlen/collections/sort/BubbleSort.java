package antlen.collections.sort;

import antlen.collections.Util;

/**
 * Created by antlen on 15/08/2015 15:11.
 */
public class BubbleSort implements Sorter {

    @Override
    public int[] sort(int[] c) {
        boolean sorted = false;
        while(!sorted){
            sorted = true;
            for(int i=0; i < c.length - 1; i++){
                if(c[i]>c[i+1]) {
                    sorted=false;
                    Util.swap(c, i + 1, i);
                }
            }
        }
        return c;
    }
}
