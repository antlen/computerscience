package eclipseoptions.api;

import java.util.Collection;

/**
 * A factory to create new instances of {@link com.eclipseoptions.javatest.tuple.api.Tuple}s with the specified elements
 */
public interface TupleFactory {
	/**
	 * Returns a new Tuple containing the elements in the given array in the same order
	 * @param arr the array containing the Tuple's elements
	 * @param <T> the lower bound of the Tuple elements types
	 * @return a new Tuple containing the elements in the given array in the same order
	 * @throws NullPointerException if the array is null
	 */
	<T> Tuple<T> newTuple(T... arr);

	/**
	 * Returns a new Tuple containing the elements in the given collection in the same order
	 * @param collection the collection containing the Tuple's elements
	 * @param <T> the lower bound of the Tuple elements types
	 * @return a new Tuple containing the elements in the given collection in the same order
	 * @throws NullPointerException if the collection is null
	 */
	<T> Tuple<T> newTuple(Collection<T> collection);

	/**
	 * Returns a new {@link com.eclipseoptions.javatest.tuple.api.ComparableTuple} containing the comparable elements
	 * in the given array in the same order.
	 *
	 * @param arr the array containing the Tuple's elements
	 * @param <T> the lower bound of the Tuple elements types
	 * @return a comparable Tuple containing the comparable elements in the given array in the same order
	 * @throws NullPointerException if the array is null
	 */
	<T extends Comparable<T>> ComparableTuple<T> newComparableTuple(T... arr);

	/**
	 * Returns a new {@link com.eclipseoptions.javatest.tuple.api.ComparableTuple} containing the comparable elements
	 * in the given collection in the same order.
	 *
	 * @param collection the collection containing the Tuple's elements
	 * @param <T> the lower bound of the Tuple elements types
	 * @return a comparable Tuple containing the comparable elements in the given collection in the same order
	 * @throws NullPointerException if the collection is null
	 */
	<T extends Comparable<T>> ComparableTuple<T> newComparableTuple(Collection<T> collection);
}
