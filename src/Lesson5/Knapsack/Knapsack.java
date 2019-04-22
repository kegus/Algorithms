package Lesson5.Knapsack;

import java.util.Arrays;

public class Knapsack {
    public static void main(String[] args) {
        int i = 0;
        int chkWeight = 21;
        int maxPrice = 0;
        int tmpPrice = 0;
        Goods[] maxGoods = new Goods[0];
        Goods[] knapsack = {new Goods("1", 1, 2),
                            new Goods("2", 2, 5),
                            new Goods("3", 3, 9),
                            new Goods("4", 4, 7),
                            new Goods("5", 5, 8),
                            new Goods("6", 6, 4),
                            new Goods("7", 7, 1)
                         };
        Knapsacks work = new Knapsacks(knapsack);
        work.takeAll();
        while (!work.isEmpty()) {
            if (work.getWeight() < chkWeight) {
                tmpPrice = work.getPrice();
                if (tmpPrice > maxPrice) {
                    maxPrice = tmpPrice;
                    maxGoods = work.getItems();
                }
                i++;
                System.out.println(i + ". " + work);
            }
            work.throw_one();
        }
        System.out.println(Arrays.toString(maxGoods) + " " + maxPrice);
        //System.out.println(work.tmCount);
        //System.out.println(work.tm);
    }
}
