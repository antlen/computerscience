package antlen.collections.sort;

import antlen.collections.Util;

/**
 * Created by antlen on 15/08/2015 15:11.
 */
public class OptmizedBubbleSort implements Sorter {

    @Override
    public int[] sort(int[] c) {

        int n = c.length - 1;
        while(n != 0){
            int newn = 0;
            for(int i=0; i < n; i++){
                if(c[i]>c[i+1]) {
                    newn=i;
                    Util.swap(c, i + 1, i);
                }
            }
            n = newn;
        }
        return c;
    }
}
