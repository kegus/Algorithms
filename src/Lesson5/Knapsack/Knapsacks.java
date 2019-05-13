package Lesson5.Knapsack;

import java.util.Arrays;
import java.util.Comparator;

import Lesson8.MyTreeHashMap;

public class Knapsacks {
    public Boolean[] items;
    private Goods[] knapsack;
    private int countAll = 0;
    public int tmCount = 0;

    private class ItemsComparator implements Comparator<Boolean[]> {
        @Override
        public int compare(Boolean[] o1, Boolean[] o2) {
            for (int i = 0; i < o1.length; i++) {
                if (o1[i] && ! o2[i]) return i+1;
                else if (!o1[i] && o2[i]) return -i-1;
            }
            return 0;
        }
    }

    public MyTreeHashMap<Boolean[], Goods[]> tm = new MyTreeHashMap(new ItemsComparator());

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

    private void saveKnapsack(){
        tmCount++;
        int cntItems = countItems();
        Boolean[] tmp_items = new Boolean[countAll];
        Goods[] tmp_knapsack = new Goods[cntItems];
        int i = 0, j = 0;
        while (i < countAll) {
            if (items[i]) {
                tmp_knapsack[j] = knapsack[i];
                j++;
            }
            tmp_items[i] = items[i];
            i++;
        }
        tm.put(tmp_items, tmp_knapsack);
    }

    public void throw_one() {
        saveKnapsack();
        boolean tmp;
        int i = items.length-1;
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

    public Goods[] getItems(){
        Goods[] res = new Goods[countItems()];
        for (int i = 0, j = 0; i < knapsack.length; i++) {
            if (items[i]) res[j++] = knapsack[i];
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
