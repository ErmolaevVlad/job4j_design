package ru.job4j.map;

import java.util.*;

public class NonCollisionMap<K, V> implements SimpleMap<K, V> {
    private static final float LOAD_FACTOR = 0.75f;

    private int capacity = 8;
    private int count = 0;
    private int modCount = 0;
    private MapEntry<K, V>[] table = new MapEntry[capacity];

    @Override
    public boolean put(K key, V value) {
        if (count * 1.0 / table.length  >= LOAD_FACTOR) {
            expand();
        }
        boolean rsl = false;
        int index = getIndex(key);
        if (table[index] == null) {
            table[index] = new MapEntry<>(key, value);
            modCount++;
            count++;
            rsl = true;
        }
        return rsl;
    }

    @Override
    public V get(K key) {
        int index = getIndex(key);
        V rsl = null;
        if (table[index] != null) {
            if (compareKey(key, index)) {
               rsl = table[index].value;
            }
        }
        return rsl;
    }

    @Override
    public boolean remove(K key) {
        int index = getIndex(key);
        boolean rsl = false;
        if (table[index] != null) {
            if (compareKey(key, index)) {
                table[index] = null;
                rsl = true;
                modCount++;
                count--;
            }
        }
        return rsl;
    }

    @Override
    public Iterator<K> iterator() {

        return new Iterator<K>() {
            final int exceptedModCount = modCount;
            int index;

            @Override
            public boolean hasNext() {
                if (exceptedModCount != modCount) {
                    throw new ConcurrentModificationException();
                }
                while (index < table.length && table[index] == null) {
                    index++;
                }
                return index < table.length;
            }

            @Override
            public K next() {
                if (!hasNext()) {
                    throw  new NoSuchElementException();
                }
                return table[index++].key;
            }
        };
    }

    private int hash(int hashCode) {
        return hashCode ^ (hashCode >>> 16);
    }

    private int indexFor(int hash) {
        return hash & (table.length - 1);
    }

    private void expand() {
        MapEntry<K, V>[] newTable = new MapEntry[capacity * 2];
        int i = 0;
        while (i < table.length) {
            if (table[i] != null) {
                int hashCode = Objects.hashCode(table[i].key);
                int hash = hash(hashCode);
                int index = hash & (newTable.length - 1);
                newTable[index] = new MapEntry<>(table[i].key, table[i].value);
            }
            i++;
        }
        table = newTable;
    }

    private int getIndex(K key) {
        int hashCode = Objects.hashCode(key);
        int hash = hash(hashCode);
        return  indexFor(hash);
    }

    private boolean compareKey(K key, int index) {
       return Objects.hashCode(key) == (Objects.hashCode(table[index].key))
                && Objects.equals(key, table[index].key);
    }

    private static class MapEntry<K, V> {
        K key;
        V value;

        public MapEntry(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }
}