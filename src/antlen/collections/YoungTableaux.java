package antlen.collections;

import java.util.Arrays;

/**
 * Created by antlen on 5/9/15.
 */
public class YoungTableaux {

    private final int[][] data;
    private final boolean strict;

    public YoungTableaux(int[][] data, boolean strict) {
        this.data = data;
        this.strict=strict;
        validate();
    }

    private void validate(){
        if(! strict) return;

        int index =0;
        boolean stillChecking = true;
        while(stillChecking) {
            stillChecking=false;
            for (int i = 0; i < data.length; i++) {
                if(index < data[i].length) {
                    int current = data[i][index];
                    if(index+1 < data[i].length) {
                        stillChecking=true;
                        validate(current, data[i][index + 1]);
                    }
                    if(i+1 < data.length && index < data[i + 1].length) {
                        stillChecking=true;
                        validate(current, data[i + 1][index]);
                    }
                }
            }
            index ++;
        }
    }

    private void validate(int i, int next) {
        if(i > next){
            throw new IllegalArgumentException(i +" is gt than " + next);
        }
    }

    public int[] ordered(){
        int size = 0;
        int index =0;
        long result = 0;
        boolean stillChecking = true;
        while(stillChecking) {
            stillChecking=false;
            for (int i = 0; i < data.length; i++) {
                if(index < data[i].length) {
                    stillChecking=true;
                    result = 1L << data[i][index] | result;
                    size++;
                }
            }
            index ++;
        }
        int[] arr = new int[size];
        index =0;
        System.out.println(Long.toBinaryString(result));
        while(result > 0){
            long highest = Long.lowestOneBit(result);
            result = result ^ highest;

            int base_10 = (int)(Math.log(highest)/Math.log(2));
            arr[index++]=base_10;
        }
        return arr;
    }

    @Override
    public String toString() {
        final StringBuilder b = new StringBuilder();

        int index =0;
        boolean stillChecking = true;
        while(stillChecking) {
            stillChecking=false;
            for (int i = 0; i < data.length; i++) {
                if(index < data[i].length) {
                    stillChecking=true;
                    int current = data[i][index];
                    b.append(current).append(" | ");
                }
            }
            b.append("\n-------------------------------\n");
            index ++;
        }

        return b.toString();
    }


    public static void main(String [] args){
        YoungTableaux yt = new YoungTableaux(new int[][]{new int[]{1,3,62}, new int[]{2,5},
                new int[]{4,6}, new int[]{7, 9}, new int[]{8}}, true);

        System.out.println(yt);
        System.out.println(Arrays.toString(yt.ordered()));
    }
}
