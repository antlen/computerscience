package antlen.collections;

import antlen.collections.sort.*;

import java.util.Arrays;

/**
 * Created by antlen on 15/08/2015 15:16.
 */
public class TestHarness {



    public static void main(String [] arg){
        int maxIteration = 100;
        Sorter[] sorters = {new BubbleSort(),new OptmizedBubbleSort(), new SelectionSort(), new QuickSort(), new InsertionSort(), new MergeSort()};
       // Sorter[] sorters = {new MergeSort()};

      //  int[] arr = Util.SHUFFLE.build(20);
       // System.out.println("raw  = " + Arrays.toString(arr));
    //    new MergeSort().sort(arr);
     //   System.exit(0);

        for(Sorter sorter : sorters) {
            print("Shuffled", sorter, maxIteration, Util.SHUFFLE);
        }
        for(Sorter sorter : sorters) {
            print("Reverse", sorter, maxIteration, Util.REVERSE);
        }
        for(Sorter sorter : sorters) {
            print("Sorted ", sorter, maxIteration, Util.SORTED);
        }
    }


    public static void print(String info, Sorter sorter, int iterations, ArrayFactory fac){
        Result total = time(sorter, iterations, fac);
        System.out.println("----------------------");
        System.out.println("[" + sorter.getClass().getSimpleName() +"]"+info + " took " + Arrays.toString(total.time));
        System.out.println(Arrays.toString(Arrays.copyOfRange(total.array, 0, 20))+"..." + Arrays.toString(Arrays.copyOfRange(total.array, total.array.length-20, total.array.length)));
    }


    public static Result time(Sorter sorter, int iterations, ArrayFactory fac){

        final int testSize = 10;
        final Result r = new Result(testSize);
        final int inc = 100;

        for(int size=inc; size<=testSize*inc; size+= inc) {
            long total = 0;
            for (int i = 0; i < iterations; i++) {
                r.array = fac.build(size);
                total += time(r.array, sorter);
            }
            r.time[(size/inc)-1]= total / iterations;
            r.size[(size/inc)-1]=size;
        }
        return r;

    }

    public static long time(int[] i, Sorter sorter){

        long start = System.nanoTime();
        sorter.sort(i);
        long end = System.nanoTime();
        return end - start;
    }

    private static class Result{
        private Result(int size){

            time = new long[size];
            this.size = new long[size];
        }
        public int[] array;
        public long[] time;
        public long[] size;

    }
}
