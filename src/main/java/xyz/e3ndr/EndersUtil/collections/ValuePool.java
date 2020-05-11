/**
 * 2020 e3ndr.
 * Proudly licensed under MIT. (Don't be a dick though)
 */
package xyz.e3ndr.EndersUtil.collections;

import java.util.Arrays;
import java.util.Collection;
import java.util.Map;
import java.util.Set;

import lombok.Getter;
import lombok.ToString;

@ToString
public class ValuePool<K, V> implements Map<K, Collection<V>> {
    private Map<K, Collection<V>> entries;
    private @Getter MapType mapType;
    private @Getter CollectionType collectionType;

    /**
     * Instantiates a new value pool with the default {@link MapType#HASH} and the
     * default {@link CollectionType#NORMAL}.
     */
    public ValuePool() {
        this(MapType.HASH, CollectionType.NORMAL);
    }

    /**
     * Instantiates a new value pool with the provided {@link MapType} and the
     * default {@link CollectionType#NORMAL}.
     *
     * @param mapType the map type
     */
    public ValuePool(MapType mapType) {
        this(mapType, CollectionType.NORMAL);
    }

    /**
     * Instantiates a new value pool with the default {@link MapType#HASH} and the
     * provided {@link CollectionType}.
     *
     * @param collectionType the collection type
     */
    public ValuePool(CollectionType collectionType) {
        this(MapType.HASH, collectionType);
    }

    /**
     * Instantiates a new value pool with the provided {@link MapType} and the
     * provided {@link CollectionType}.
     *
     * @param mapType the map type
     * @param collectionType the collection type
     */
    public ValuePool(MapType mapType, CollectionType collectionType) {
        this.entries = mapType.getNewMap();
        this.mapType = mapType;
        this.collectionType = collectionType;
    }

    public void put(K key, @SuppressWarnings("unchecked") V... values) {
        this.put(key, Arrays.asList(values));
    }

    @Override
    public Collection<V> put(K key, Collection<V> values) {
        Collection<V> stored = this.entries.get(key);

        if (stored == null) {
            stored = this.collectionType.getNewCollection();
            this.entries.put(key, stored);
        }

        stored.addAll(values);

        return null;
    }

    @Override
    public int size() {
        return this.entries.size();
    }

    @Override
    public boolean isEmpty() {
        return this.entries.size() == 0;
    }

    @Override
    public boolean containsKey(Object key) {
        return this.entries.containsKey(key);
    }

    @Override
    public boolean containsValue(Object value) {
        return this.entries.containsValue(value);
    }

    @Override
    public Collection<V> get(Object key) {
        return this.entries.get(key);
    }

    @Override
    public Collection<V> remove(Object key) {
        return this.entries.remove(key);
    }

    /**
     * Removes the specified value from any collection
     * 
     * @apiNote Calling this can be very costly computationally and time wise.
     * 
     * @param value to remove
     * @return whether or not the value was removed from any collection
     */
    public boolean removeValue(Object value) {
        boolean removed = false;

        for (Collection<V> collection : this.values()) {
            for (Object obj : collection) {
                if (value.equals(obj)) {
                    removed = true;
                }
            }
        }

        return removed;
    }

    @Override
    public void putAll(Map<? extends K, ? extends Collection<V>> m) {
        for (Entry<? extends K, ? extends Collection<V>> entry : m.entrySet()) {
            this.put(entry.getKey(), entry.getValue());
        }
    }

    @Override
    public void clear() {
        this.entries.clear();
    }

    @Override
    public Set<K> keySet() {
        return this.entries.keySet();
    }

    @Override
    public Collection<Collection<V>> values() {
        return this.entries.values();
    }

    @Override
    public Set<Entry<K, Collection<V>>> entrySet() {
        return this.entries.entrySet();
    }

}
