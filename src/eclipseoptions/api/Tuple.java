package eclipseoptions.api;

import java.util.Iterator;

/**
 * <p>A tuple is an immutable, ordered data structure of elements, backed by an array, which permits null elements.</p>
 *
 * <p><strong>IMPORTANT</strong>: when implementing this interface, you must use an array, not a list.</p>
 *
 * @param <T> the lower bound of the type of the elements contained in the tuple.
 */
public interface Tuple<T> extends Iterable<T> {
	/**
	 * Gets the element at the given index in the tuple
	 *
	 * @param index the index of the element to be returned
	 * @return the element at the given index in the tuple
	 * @throws IndexOutOfBoundsException if the element is negative or greater than the last element index
	 */
	T get(int index);

	/**
	 * Returns a Tuple with the element at the given index replaced with the given value
	 *
	 * @param index the index of the element to be replace
	 * @param value the value with which to replace the given element
	 * @return a tuple with the element at the given index replaced with the given value
	 * @throws IndexOutOfBoundsException if the element is negative or greater than the last element index
	 */
	Tuple<T> replace(int index, T value);

	/**
	 * Returns the number of elements in this tuple
	 * @return the number of elements in this tuple
	 */
	int size();

	/**
	 * Returns an array containing the elements of this tuple in order
	 * @return an array containing the elements of this tuple in order
	 */
	Object[] toArray();

	/**
	 * Returns an iterator over the elements of this tuple in order
	 * @return an iterator over the elements of this tuple in order
	 */

	Iterator<T> iterator();

	/**
	 * Indicates whether some other object is equal to this Tuple.
	 *
	 * Two Tuples are considered equal if all both contain the same number of elements which are
	 * {@link Object#equals(Object)} to each other (or both null), in the same order.
	 *
	 * @param o the object to check for equality
	 * @return true if the object is equal to this Tuple, false otherwise
	 */
	@Override
	boolean equals(Object o);

	/**
	 * Returns a hash code value for the tuple which meets the "general contract" of {@link Object#hashCode()}
	 *
	 * @return a hash code value for the tuple which meets the "general contract" of {@link Object#hashCode()}
	 */
	@Override
	int hashCode();
}
