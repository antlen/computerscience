package eclipseoptions.api;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * Created by antlen on 13/9/15.
 *
 * I was considering using a ConcurrentHashMap but even using there is still some race conditions.
 * If the use case does not require that the data set is always exact then it will be better to switch to ConcurrentHashMap
 *
 *
 *
 */
public class ConflatingQueueImpl<K,V> implements ConflatingQueue<K,V> {

    private final LinkedBlockingDeque<K> data = new LinkedBlockingDeque<K>();
    private final Map<K, KeyedValue<K,V>> lastValueCache = new HashMap<K, KeyedValue<K, V>>();

    public boolean offer(final KeyedValue<K, V> value) {
        if(value == null) throw new IllegalArgumentException("Null is not supported.");

        //add to the queue if there isnt an entry for this key in the map.
        // Also need to ensure the value is in the map before the key is added to the queue
        synchronized (lastValueCache) {
            final boolean addToQueue = !lastValueCache.containsKey(value.getKey());
            lastValueCache.put(value.getKey(), value);
            if (addToQueue) {
                data.offer(value.getKey());
            }
        }
        return true;
    }

    public KeyedValue<K, V> poll() throws InterruptedException {
        final K key = data.take();
        synchronized (lastValueCache) {
            return lastValueCache.remove(key);
        }
    }

    public boolean isEmpty() {
        return data.isEmpty();
    }


}
