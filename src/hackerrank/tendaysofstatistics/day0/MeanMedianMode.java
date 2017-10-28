package hackerrank.tendaysofstatistics.day0;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by antlen on 28/10/17.
 */
public class MeanMedianMode {


    private static final int[] buildArray(int e, Scanner s){
        final int[] ints = new int[e];

        for(int i = 0; i < e; i++){
            final int n = s.nextInt();
            ints[i]=n;
        }

        return ints;
    }

    public static void main(String[] args) {
        //final Scanner s = new Scanner(System.in);
        final Scanner s = new Scanner("10 64630 14216 99233 14470 4978 73429 11735 38120 51135 67060");
        final int e = s.nextInt();
        final int[] ints = buildArray(e, s);

        Arrays.sort(ints);
        s.close();

        int maxOccurance =0;
        int mode =0;
        int sum =0;
        for(int i = e-1; i>=0; i--){
            int lastOccurance =1;
            int x = ints[i];

            while((i-lastOccurance) >= 0 && ints[i-lastOccurance] == x){
                lastOccurance++;
            }
            i = i - (lastOccurance-1);
            if(lastOccurance > maxOccurance || (lastOccurance == maxOccurance && x < mode)){
                maxOccurance = lastOccurance;
                mode = x;
            }

            sum +=(x * lastOccurance);
        }
        final double mean = sum/e;
        System.out.println(mean);

        final int middle = (int)Math.floor( e /2);
        final double middleElements = ints[middle-1]+ ints[middle];
        final double median = middleElements / 2;
        System.out.println(median);

        System.out.println(mode);
    }


}
