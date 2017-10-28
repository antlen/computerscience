package hackerrank.algorithms.warmup;

import java.util.Scanner;

/**
 * Created by antlen on 28/10/17.
 */
public class MinMaxSum {
    public static void main(String[] args) {
        final Scanner s = new Scanner("1 2 3 4 5");
        //final Scanner s = new Scanner(System.in);


        int max =0;
        int min = Integer.MAX_VALUE;
        long sum = 0;
        StringBuffer padding = new StringBuffer(max);
        for (int i = 0; i < 5; i++){
            int next  = s.nextInt();
            sum+=next;
            if(next > max) max = next;
            if(next < min) min = next;
        }

        System.out.print((sum - max) +" " + (sum - min));
    }
}
