package Lesson8;

import java.util.Comparator;
import java.util.TreeMap;

public class MyTreeHashMap<Key, Value> {
    private int M = 1024*1024;
    private int size = 0;
    private Object[] st = new Object[M];
    private Comparator<Key> cmp;

    public MyTreeHashMap(Comparator<Key> cmp) {
        this.cmp = cmp;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    private int hash(Key key) {
        return (key.hashCode() & 0x7fffffff) % M;
    }

    public Value get(Key key) { //a[key]
        if (key == null) {
            throw new IllegalArgumentException("Ключ не может равняться null");
        }
        int i = hash(key);
        if (st[i] == null) return null;
        return (Value)((TreeMap)st[i]).get(key);
    }

    public boolean contains(Key key) {
        return get(key) != null;
    }

    public void put(Key key, Value value) { //a[key] = value
        if (key == null) {
            throw new IllegalArgumentException("Ключ не может равняться null");
        }
        int i = hash(key);
        if (st[i] == null) st[i] = new TreeMap<Key, Value>(cmp);
        ((TreeMap)st[i]).put(key, value);
        size++;
        return;
    }
}
