package antlen.google;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by antlen on 14/9/15.
 */
public class SampleQuestions {


    public static void main(String args[]){
        double val = Math.pow(7,3);
        double res = (Math.log10(val)/Math.log10(3));
      System.out.println(Math.log10(val) + "/" + Math.log10(3) + " = " + res + " = " + (((val - (int) val) == 0.0)));

        val = 628;
         res = (Math.log10(val)/Math.log10(3));
        System.out.println(Math.log10(val) + "/" + Math.log10(3) + " = " + res + " = " + (((val - (int) val) == 0.0)));

      //  findDepartureAndDestination(new BoardingCard[]{new BoardingCard("York", "London"),new BoardingCard("Scar", "Leeds"),new BoardingCard("Boro", "Scar"),new BoardingCard("Leeds", "York")});
    }

    public static void removeDupLowestLexicalOrder(){
        char[] ch = "cbacdcbc".toCharArray();
        List<List<Integer>> res = new ArrayList<>(26);

        for(int i =0; i < ch.length; i++){
            char c = ch[i];
            int arrayIndex = c - 'a';
            for(int x=res.size()-1; x <= arrayIndex; x++){
                res.add(new ArrayList<>());
            }

            List<Integer> indexes =res.get(arrayIndex);
            indexes.add(i);
        }
        //a=2
        //b=1,6
        //c=0,3,7
        //d=4
        //acdb
        char[] shortest = new char[ch.length];
        int max=-1;
        for(int i =0; i< res.size(); i++){
            List<Integer> indexes = res.get(i);
            if(indexes==null || indexes.isEmpty()) continue;
            boolean added = false;
            boolean working = true;

            int[] currentRefs = new int[26];
            while(working) {
                working = false;
                for (int f = 0; f < indexes.size(); f++) {
                    int lowestRef = indexes.get(f);
                    if (lowestRef > max) {
                        working = true;
                        shortest[lowestRef] = (char) ('a' + i);
                        max = lowestRef;
                        currentRefs[(char) ('a' + i)]=lowestRef;
                        added = true;
                        break;
                    }
                }
                if (!added) {
                    working=true;
                    int lowestRef = indexes.get(0);
                    shortest[lowestRef] = (char) ('a' + i);
                    max = lowestRef;
                    currentRefs[(char) ('a' + i)]=lowestRef;
                }
            }
        }
        System.out.print(Arrays.toString(shortest));

    }


    private static void createIncArray(){
        final int[] arr = new int[]{9,9,9,9,9,9,9,9,9};

        int incIndex = -1;

        for(int i= arr.length-1; i>=0; i--){
            if(arr[i]< 9){
                incIndex=i;
                break;
            }else{
               arr[i]=0;
            }
        }

        final int[] res = new int[arr.length+(incIndex==-1?1:0)];
        if(incIndex==-1){
            res[0]=1;
        }else{
            for(int i= arr.length-1; i>=0; i--){
                res[i]=arr[i] + (i==incIndex?1:0);
            }
        }

        System.out.print(Arrays.toString(res));
    }



    private static void findDepartureAndDestination(BoardingCard[] bcs){
        Map<String,BoardingCard > departures = new ConcurrentHashMap<>();
        Map<String, BoardingCard> destinations = new ConcurrentHashMap<>();

        for(BoardingCard bc : bcs){
            departures.put(bc.departureCity, bc);
            destinations.put(bc.destinationCity, bc);
        }
        String start = null;
        Iterator<Map.Entry<String, BoardingCard>> i = departures.entrySet().iterator();
        while(i.hasNext()){
            Map.Entry<String, BoardingCard> departure = i.next();
            if(start ==null && !destinations.containsKey(departure.getKey())){
                start=departure.getKey();
            }
            if(departures.containsKey(departure.getValue().destinationCity)){
                destinations.remove(departure.getValue().destinationCity);
            }
        }

        System.out.println(start + " - > " + destinations.toString());
    }


    private static class BoardingCard{
        private final String departureCity;
        private final String destinationCity;

        public BoardingCard(String departureCity, String destinationCity) {
            this.departureCity = departureCity;
            this.destinationCity = destinationCity;
        }
    }

}
