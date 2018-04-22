package eclipseoptions.api;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;

/**
 * Created by antlen on 13/9/15.
 */
public class TupleImpl<T> implements Tuple<T> {

    private final T[] data;

    public TupleImpl(final T[] data) {
        if(data == null){
            throw new IllegalArgumentException("The array cannot be null.");
        }
        //copy the array so we can guarantee immutability.
        this.data = Arrays.copyOf(data, data.length);
    }

    public TupleImpl(final Collection<T> c){
        data= toArray(c);
    }

    protected static <T> T[] toArray(final Collection<T> c) {
        if(c == null || c.isEmpty()){
            throw new IllegalArgumentException("The collection cannot be null or empty.");
        }
        T t = null;
        final Iterator<T> i = c.iterator();
        while(t == null && i.hasNext()){
            t = i.next();
        }
        if(t==null){
            throw new IllegalArgumentException("There are no references in the data set so cannot infer the generic type.");
        }
        return c.toArray((T[]) Array.newInstance(t.getClass(), c.size()));
    }

    public T get(final int index) {
        validateIndex(index);

        return data[index];
    }

    private void validateIndex(final int index) {
        if(index >= data.length || index < 0){
            throw new IndexOutOfBoundsException();
        }
    }

    public Tuple replace(final int index, final T value) {
        validateIndex(index);

        T[] copy = Arrays.copyOf(data, data.length);
        copy[index] = value;

        return create(copy);
    }

    protected Tuple create(final T[] copy) {
        return new TupleImpl(copy);
    }


    public int size() {
        return data.length;
    }

    public Object[] toArray() {
        return Arrays.copyOf(data, data.length);
    }

    public Iterator iterator() {
        return new Iterator() {
            int index = 0;
            public boolean hasNext() {
                return index<data.length;
            }

            public Object next() {
                return data[index++];
            }
        };
    }

    @Override
    public boolean equals(final Object obj) {
        if(obj == null) return false;

        if(obj == this) return true;

        if(!( obj instanceof Tuple)) return false;

        final Tuple<?> other = (Tuple<?>)obj;
        if(other.size() != size()) return false;

        for(int i=0; i< data.length; i++){
            Object d1 = data[i];
            Object d2 = other.get(i);
            if(d1==null && d2 == null){
                continue;
            }

            if(d1==null || d2==null || !d1.equals(d2)){
                return false;
            }
        }

        return true;
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(data);
    }

    @Override
    public String toString() {
        return Arrays.toString(data);
    }
}
