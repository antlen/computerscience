package eclipseoptions.api;

/**
 * <p>A comparable tuple is a {@link com.eclipseoptions.javatest.tuple.api.Tuple} with comparable elements and which
 * itself is comparable.</p>
 *
 * <p>A comparable tuple permits null elements.</p>
 *
 * @param <T> the lower bound of the type of the elements contained in the tuple.
 */
public interface ComparableTuple<T extends Comparable<T>> extends Tuple<T>, Comparable<ComparableTuple<T>> {
	/**
	 * Compares this ComparableTuple with the specified ComparableTuple for order.  Returns a negative integer, zero,
	 * or a positive integer as this ComparableTuple is less than, equal to, or greater than the specified ComparableTuple.
	 *
	 * ComparableTuples are ordered lexicographically. Two ComparableTuples can be different for two reasons:
	 *
	 * <ol>
	 *     <li>
	 *         One of more of the elements at a given index is different from the element at the same index in the
	 *         other tuple
	 *     </li>
	 *     <li>
	 *         The two tuples contain a different number of elements
	 *     </li>
	 * </ol>
	 *
	 * In the first case, if the first different element in this tuple is less than that of the of the corresponding
	 * element in the other tuple, then this tuple is less than the other tuple; otherwise it is greater than the other
	 * tuple. Note that null elements are considered less than non-null elements.
	 *
	 * In the second case, if elements at common indices are equal, then the shorter tuple is less than the longer
	 * tuple.
	 *
	 * @param o the tuple with which to compare this tuple
	 * @return a negative integer, zero, or a positive integer as this tuple
	 *          is less than, equal to, or greater than the specified tuple
	 */

	int compareTo(ComparableTuple<T> o);
}
