package Lesson5.Knapsack;

import java.util.Arrays;
import java.util.Comparator;

import Lesson8.MyTreeHashMap;

public class Knapsacks {
    public Boolean[] items;
    private Goods[] knapsack;
    private int countAll = 0;

    private class ItemsComparator implements Comparator<Boolean[]> {
        @Override
        public int compare(Boolean[] o1, Boolean[] o2) {
            for (int i = 0; i < o1.length; i++) {
                if (o1[i] && ! o2[i]) return i;
                else if (!o1[i] && o2[i]) return -i;
            }
            return 0;
        }
    }

    private MyTreeHashMap<Boolean[], Goods[]> tm = new MyTreeHashMap(new ItemsComparator());

    public Knapsacks(Goods[] knapsack) {
        this.knapsack = knapsack;
        countAll = knapsack.length;
        items = new Boolean[countAll];
    }

    public void takeAll() {
        for (int i = 0; i < items.length; i++) items[i] = true;
    }

    public boolean isEmpty() {
        for (int i = 0; i < items.length; i++) if (items[i]) return false;
        return true;
    }

    public boolean isFull() {
        for (int i = 0; i < items.length; i++) if (!items[i]) return false;
        return true;
    }

    private int countItems(){
        int res = 0;
        for (int i = 0; i < items.length; i++) if (items[i]) res++;
        return res;
    }

    public void throw_one() {
        int cntItems = countItems();
        Goods[] tmp_knapsack = new Goods[cntItems];
        int i = 0;
        int j = 0;
        while (i < countAll) {
            if (items[i]) {
                tmp_knapsack[j] = knapsack[i];
                j++;
            }
            i++;
        }
        tm.put(items, tmp_knapsack);

        boolean tmp;
        i = items.length-1;
        while (true) {
            tmp = items[i];
            items[i] = !items[i];
            if (tmp) break;
            i--;
        }
    }

    public int getWeight() {
        int res = 0;
        for (int i = 0; i < knapsack.length; i++) {
            if (items[i]) res += knapsack[i].getWeight();
        }
        return res;
    }
    public int getPrice() {
        int res = 0;
        for (int i = 0; i < knapsack.length; i++) {
            if (items[i]) res += knapsack[i].getPrice();
        }
        return res;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < knapsack.length; i++) {
            if (items[i]) sb.append(knapsack[i]+" ");
        }
        sb.append("вес: " + getWeight() + " цена: " + getPrice());
        return sb.toString();
    }
}
