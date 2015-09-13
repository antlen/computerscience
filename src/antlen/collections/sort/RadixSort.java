package antlen.collections.sort;

/**
 * Created by antlen on 15/08/2015 16:33.
 */
public class RadixSort implements Sorter {

    @Override
    public int[] sort(int[] a) {
        int[] destination = new int[a.length];

        radixsort(a, 0, a.length, 1);

        return a;
    }

    private final void radixsort(int[] source, int start, int end, int digit){
        int[] output = new int[source.length];

        int[] count = new int[10];

        for(int i=start; i < end ; i++){
            int value = source[i];
            int res = getIndex(digit, value);
            count[res]++;
        }

        int prev =0;
        for(int i=0; i < count.length ; i++){
            count[i]+=prev;
            prev=count[i];
        }

        for(int i=start; i < end ; i++){
            int value = source[i];
            int res = getIndex(digit, value);
            output[count[res]++]=value;
        }

        for(int i=start; i < end ; i++){
            source[i]=output[i];
        }

    }

    private int getIndex(int digit, int value) {
        return (int) ((Math.pow(10, digit-1) %10) / value) % 10;
    }


}
