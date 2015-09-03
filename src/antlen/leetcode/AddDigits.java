package antlen.leetcode;

/**
 * Created by antlen on 16/08/2015 14:22.
 */
public class AddDigits {

        public static void main(String [] a){
            AddDigits ad = new AddDigits();
            System.out.println(ad.addDigits(38));
        }

        public int addDigits(int num) {

            while(num > 9) {
                int total = 0;
                while (num > 0) {
                    total += (num % 10);
                    num = num / 10;
                }
                num = total;
            }
            return num;
        }

}
