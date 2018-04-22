package antlen.leetcode;

import java.util.Arrays;

/**
 * Created by antlen on 16/08/2015 14:22.
 */
public class MaxWindow {



        public static void main(String [] a){

            MaxWindow ad = new MaxWindow();
            int[] res = ad.maxSlidingWindow(new int[]{7,2,4}, 2);
            System.out.println(Arrays.toString(res));

        }

        public int[] maxSlidingWindow(int[] nums, int k) {
            if(nums.length==0) return new int[0];

            int[] res = new int[nums.length - k +1];
            res[0]=Integer.MIN_VALUE;
            int maxSeenBucket=-1;
            for(int i = 0; i < nums.length; i++){
                int offset = i + k - 1;

                int maxWindow = Math.max(0, Math.min(res.length - 1, offset));
                int minWindow =Math.max(0, (i-k)+1);
                for(int x = minWindow; x <=maxWindow; x++){
                    if(x>maxSeenBucket){
                        maxSeenBucket=x;
                        res[x]=Integer.MIN_VALUE;
                    }
                    if(nums[i] > res[x]) res[x]=nums[i];
                }
            }
            return res;
        }

}
