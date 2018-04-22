package hackerrank.algorithms.warmup;

import java.util.Scanner;

/**
 * Created by antlen on 28/10/17.
 */
public class Staircase {
    public static void main(String[] args) {
        final Scanner s = new Scanner("6");
        //final Scanner s = new Scanner(System.in);

        int max = s.nextInt();

        StringBuffer padding = new StringBuffer(max);
        for (int i = 0; i < max; i++){
            padding.append(" ");
        }

        for(int i=0; i<max; i++){
            padding.deleteCharAt(0);
            padding.append("#");
            System.out.println(padding.toString());
        }
    }
}
