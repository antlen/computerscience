package eclipseoptions.api;

/**
 * <p>A ConflatingQueue is an unbounded blocking queue of {@link KeyedValue}s which conflates multiple updates on the
 * same key during the time a value for a key remains in the queue. It can be considered a FIFO queue with respect to
 * the keys, but not necessarily the values.</p>
 *
 * <p>A ConflatingQueue implementation is thread-safe and supports multiple concurrent producers and consumers. Each item
 * in the queue is only made available at most once to a single consumer.</p>
 *
 * <p>A ConflatingQueue does not permit null entries.</p>
 *
 * <p>A typical purpose of such a queue is to interface between a high frequency producer and a low frequency consumer,
 * where it is still meaningful to process the latest value for each key, such as market data updates.</p>
 *
 * <p>For example, if the keyed value is a stock ticker and the value the last traded price, and the queue starts empty:
 * </p>
 *
 * <ol>
 *     <li>
 *         A consumer calls {@link #poll()}, and blocks because the queue is empty
 *     </li>
 *     <li>
 *         A producer calls {@link #offer(KeyedValue)} with key=5 and price=80. The consumer call unblocks and is
 *         provided the value
 *     </li>
 *     <li>
 *         A producer calls {@link #offer(KeyedValue)} with key=5 and price=81.
 *     </li>
 *     <li>
 *         A producer calls {@link #offer(KeyedValue)} with key=1 and price=100.
 *     </li>
 *     <li>
 *         A producer calls {@link #offer(KeyedValue)} with key=5 and price=82, which replaces the already queued
 *         price=81.
 *     </li>
 *     <li>
 *         A consumer calls {@link #poll()} three times. The first two calls return key=5 and price=82,
 *         key=1 and price=100 and the third call blocks because the queue is empty.
 *     </li>
 * </ol>
 *
 * @param <K> the type of the {@link com.eclipseoptions.javatest.conflator.api.KeyedValue}'s key
 * @param <V> the type of the {@link com.eclipseoptions.javatest.conflator.api.KeyedValue}'s value
 */
public interface ConflatingQueue<K, V> {
	/**
	 * Adds a keyed value to the queue.
	 *
	 * If a keyed value already exists in the queue with the same key, then the old value in the queue is updated
	 * in place with the new value. The order of the new value within the queue should be the same as the old value.
	 *
	 * If no keyed value exists in the queue with the same key, the value is added to the end of the queue.
	 *
	 * @param value the keyed value to add to the queue
	 * @return true if the keyed value could be added to the queue, false otherwise
	 * @throws NullPointerException if value is null
	 */
	boolean offer(KeyedValue<K, V> value);

	/**
	 * Removes the first keyed value in the queue, blocking if the queue is empty.
	 *
	 * @return the first keyed value in the queue
	 * @throws InterruptedException if the thread was interrupted while waiting a keyed value to be added to the queue
	 */
	KeyedValue<K, V> poll() throws InterruptedException;

	/**
	 * Checks whether the queue is currently empty
	 *
	 * @return true if the queue is currently empty, false otherwise
	 */
	boolean isEmpty();
}
