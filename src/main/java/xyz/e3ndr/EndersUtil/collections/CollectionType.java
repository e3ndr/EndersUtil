package xyz.e3ndr.endersutil.collections;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.concurrent.CopyOnWriteArrayList;

public enum CollectionType {
    NORMAL,
    COPYONWRITE,
    HASH;

    public <T> Collection<T> getNewCollection() {
        switch (this) {
            case COPYONWRITE:
                return new CopyOnWriteArrayList<>();

            case HASH:
                return new HashSet<>();

            case NORMAL:
            default:
                return new ArrayList<>();
        }
    }

}
