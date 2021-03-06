package ru.job4j.cache;

import java.io.FileNotFoundException;
import java.lang.ref.SoftReference;
import java.util.HashMap;
import java.util.Map;

public abstract class AbstractCache<K, V> {

    protected final Map<K, SoftReference<V>> cache = new HashMap<>();

    public void put(K key, V value) {
        cache.put(key, new SoftReference<>(value));
    }

    public V get(K key) {
        V value = cache.getOrDefault(key, new SoftReference<>(null)).get();
        if (value != null) {
            System.out.printf("The file %s is already exist!%n", key);
            return value;
        }
        try {
            value = load(key);
            if (!value.equals("")) {
                put(key, value);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return value;
    }

    protected abstract V load(K key) throws FileNotFoundException;

}