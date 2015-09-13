package eclipseoptions.api;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by antlen on 13/9/15.
 */
public class TupleTest {

    public static void main(String args[] ){
        TupleFactory f = new TupleFactoryImpl();

        List<String> l = new ArrayList<String>();
        l.add("Hello");
        l.add(null);
        l.add("Options");

        ComparableTuple<String> t = f.newComparableTuple(l);

        System.out.println(t);

        ComparableTuple<String> t2 = f.newComparableTuple(new String[]{"Hello", null, "Options"});
        System.out.println(t2);

        Iterator<String> i = t.iterator();
        while(i.hasNext()){
            System.out.println(i.next());
        }

        System.out.println("T and T2 should be equal : " + t2.equals(t));

        ComparableTuple<String> t3 = (ComparableTuple<String> )t2.replace(2, "Bbb");

        ComparableTuple<String>  t4 = (ComparableTuple<String> )t2.replace(2, "Zzz");
        System.out.println(t2);
        System.out.println(t3);

        System.out.println("T and T2 should be equal : " + t2.equals(t));

        System.out.println("T and T3 should not be equal : " + t3.equals(t));


        System.out.println("T vs T2 should be 0 : " + t2.compareTo(t));

        System.out.println("T vs T3 should be -1 : " + t3.compareTo(t));
        System.out.println("T vs T4 should be 1 : " + t4.compareTo(t));

        ComparableTuple<String> t5 = f.newComparableTuple(new String[]{"Hello", null, "Options", "boo"});

        System.out.println("T vs T5 should be -1 : " + t.compareTo(t5));
        System.out.println("T5 vs T should be 1 : " + t5.compareTo(t));

    }

}
