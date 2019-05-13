package Lesson8;

import Lesson5.Knapsack.Goods;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Set;
import java.util.TreeMap;

public class MyTreeHashMap<Key, Value> {
    private int M = 24;
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
        //Goods[] b = (Goods[])((TreeMap)st[i]).get(key);
        ((TreeMap)st[i]).put(key, value);
        size++;
        return;
    }

    @Override
    public String toString() {
        int j = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            if (st[i] != null) {
                //sb.append(Arrays.toString((Boolean[])((TreeMap)st[i]).firstKey())+ " ");
                Set<Boolean[]> s = ((TreeMap)st[i]).keySet();
                for (Boolean[] b: s) {
                    j++;
                    sb.append(j+". "+Arrays.toString(b) + " \n");
                }
            }
        }
        return "MyTreeHashMap{} \n"+sb;
    }
}
