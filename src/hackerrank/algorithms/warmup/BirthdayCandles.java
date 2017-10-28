package hackerrank.algorithms.warmup;

import java.util.Scanner;

/**
 * Created by antlen on 28/10/17.
 */
public class BirthdayCandles {
    static int birthdayCakeCandles(int n, int[] ar) {
        int max =0;
        int maxOccurance=0;
        for(int i = 0; i < n ;i ++){
            int next = ar[i];
            if(next > max){
                max = next;
                maxOccurance =1;
            }else if(max == next){
                 maxOccurance++;
            }
        }

        return maxOccurance;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] ar = new int[n];
        for(int ar_i = 0; ar_i < n; ar_i++){
            ar[ar_i] = in.nextInt();
        }
        int result = birthdayCakeCandles(n, ar);
        System.out.println(result);
    }
}
