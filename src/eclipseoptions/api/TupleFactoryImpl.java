package eclipseoptions.api;

import java.util.Collection;

/**
 * Created by antlen on 13/9/15.
 */
public class TupleFactoryImpl implements TupleFactory {

    public <T> Tuple<T> newTuple(final T... arr) {
        return new TupleImpl<T>(arr);
    }

    public <T> Tuple<T> newTuple(final Collection<T> collection) {
        return new TupleImpl<T>(collection);
    }

    public <T extends Comparable<T>> ComparableTuple<T> newComparableTuple(final T... arr) {
        return new ComparableTupleImpl<T>(arr);
    }

    public <T extends Comparable<T>> ComparableTuple<T> newComparableTuple(final Collection<T> collection) {
        return new ComparableTupleImpl<T>(collection);
    }


}
