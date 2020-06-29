package xyz.e3ndr.endersutil.collections;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public enum MapType {
    HASH,
    CONCURRENTHASH;

    public <K, V> Map<K, V> getNewMap() {
        switch (this) {
            case CONCURRENTHASH:
                return new ConcurrentHashMap<>();

            case HASH:
            default:
                return new HashMap<>();
        }
    }

}
