package crackingthecodinginteview.section1;

import antlen.collections.Util;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by antlen on 12/9/15.
 */
public class ArraysAndStrings {

    public static void main(String [] a){
        test_1_5();
    }


    public static void test_1_1(){
        String noDups = "abcdefghijklmnopqrstuvwxyz";
        String dups = noDups+noDups;

        System.out.println(noDups +" : " + test_1_1_with_hashset(noDups));
        System.out.println(dups + " : " + test_1_1_with_hashset(dups));

    }

    public static void test_1_5() {
        int len = 35;
        String[] vals = {"abcdefghijklmnopqrstuvwxyz",
                "abcdefghijklmnopqqrstuvwxyz",
                "abcdefghijklmmmnopqqrstuvwxyz",
                "aaaaaaaabbbbbbcccccccdefghijklmmmnopqqrstuvwxyz"};

        for(String s : vals) {
            char[] chars = s.toCharArray();
            int resIndex=0;
            char c = chars[0];
            char charCount=1;
            for(int i =1; i < chars.length; i++){
                if(chars[i]==c){
                    charCount++;
                    continue;
                }
                if(charCount>2){
                    chars[resIndex++]=c;
                    chars[resIndex++]=(char)('0'+charCount);
                }else{
                    for(int x=0; x<charCount; x++){
                        chars[resIndex++]=c;
                    }
                }
                c=chars[i];
                charCount=1;
            }
            char[] res = new char[resIndex+1];
            for(int i=0; i < res.length; i++){
                res[i] = chars[i];
            }
            System.out.println("|"+(new String(res))+"|");
        }


    }

    public static void test_1_4(){
        int len = 35;
        String s = "abcde  fghijklm  nopqr   stuv wxy z       ";
        char[] chars = s.toCharArray();
        int diff = chars.length - len-1;
        boolean addWhitespace=false;

        for(int i=(len-1); i>=0; i--){

            boolean whitespace =(chars[i]==' ');
            if(whitespace) {
                addWhitespace=true;
                if(i>0 && chars[i-1]==' ') {
                    diff++;
                    continue;
                }
            }

            if(addWhitespace){
                addWhitespace=false;
                chars[i + (diff--)]='0';
                chars[i +(diff--)]='2';
                chars[i +(diff)]='%';
                if(!whitespace) diff--;

            }
            if(!whitespace)
                 chars[i + diff] = chars[i];
        }

        System.out.println(new String(chars));
    }

    public static boolean test_1_1_with_hashset(String s){
        Set<Character> set = new HashSet<>();
        for(Character c : s.toCharArray()){
            if(!set.add(c)) return true;
        }

        return false;
    }


}
