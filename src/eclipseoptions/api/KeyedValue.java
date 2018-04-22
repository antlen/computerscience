package eclipseoptions.api;

/**
 * <p>A simple interface which describes a value with an associated key.</p>
 *
 * <p>Instances of {@link KeyedValue} are immutable.</p>
 *
 * <p>Two KeyedValues are considered to related to the same key if the keys are {@link Object#equals(Object)} to each other.</p>
 */
public interface KeyedValue<K, V> {
	/**
	 * Returns the key
	 * @return the key
	 */
	K getKey();

	/**
	 * Returns the value
	 * @return the value
	 */
	V getValue();
}
