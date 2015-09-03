package antlen.collections;

import java.util.Random;

/**
 * Created by antlen on 15/08/2015 15:45.
 */
public class Util {

    public static final void swap(int[] a, int index, int index2){
        if(index == index2) return;
        //int tmp = a[index];
        //a[index]=a[index2];
        //a[index2]=tmp;
        a[index2] ^= a[index];
        a[index] ^= a[index2];
        a[index2] ^= a[index];
    }

    public static final ArrayFactory SORTED = new ArrayFactory(){
        @Override
        public int[] build(int size) {
            final int[] arr = new int[size];
            for(int i = 0; i < size; i++)
            {
                arr[i]=i;
            }
            return arr;
        }
    };

    public static final ArrayFactory REVERSE = new ArrayFactory(){
        @Override
        public int[] build(int size) {
            int[]  a = SORTED.build(size);
            for(int i =0; i < a.length /2; i++){
                Util.swap(a, a.length-i-1, i);
            }
            return a;
        }
    };

    public static final ArrayFactory SHUFFLE = new ArrayFactory(){
        private final Random random = new Random();
        @Override
        public int[] build(int size) {
            int[]  a = SORTED.build(size);
            for(int i=0; i < a.length; i++){
                int index = random.nextInt(i +1);
                if(1 !=index) {
                    Util.swap(a, i, index);
                }
            }
            return a;
        }
    };




}
