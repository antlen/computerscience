package eclipseoptions.api;

import java.util.Collection;

/**
 * Created by antlen on 13/9/15.
 */
public class ComparableTupleImpl<T extends Comparable<T>> extends TupleImpl<T>  implements ComparableTuple<T>{


    public ComparableTupleImpl(final T[] data) {
        super(data);
    }

    public ComparableTupleImpl(final Collection<T> c) {
        super(c);
    }

    public int compareTo(final ComparableTuple<T> o) {
        final int size = size();
        final int otherSize = o.size();

        for(int i = 0; i < Math.min(size, otherSize); i++) {
            final T t1 = get(i);
            final T t2 = o.get(i);
            if (t1 != t2) {
                if(t1==null) return -1;
                if(t2==null) return 1;

                int res = t1.compareTo(t2);
                if (res != 0) return res>0?1:-1;
            }
        }


        if(otherSize > size) return -1;

        if(otherSize < size) return 1;

        return 0;
    }

    @Override
    protected Tuple create(final T[] copy) {
        return new ComparableTupleImpl(copy);
    }

}
