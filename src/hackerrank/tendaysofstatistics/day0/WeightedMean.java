package hackerrank.tendaysofstatistics.day0;

import java.util.Scanner;

/**
 * Created by antlen on 28/10/17.
 */
public class WeightedMean {
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
        final Scanner s = new Scanner("5 10 40 30 50 20 1 2 3 4 5");
        final int e = s.nextInt();
        final int[] ints = buildArray(e, s);
        final int[] weights = buildArray(e, s);

        double sum = 0;
        int divisor = 0;
        for(int i =0; i < e; i++){
            sum += (ints[i] * weights[i]);
            divisor += weights[i];
        }

        final double weightedMean = sum / divisor;
        System.out.printf("%.1f", weightedMean);
    }
}
