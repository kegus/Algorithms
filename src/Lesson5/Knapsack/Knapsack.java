package Lesson5.Knapsack;

public class Knapsack {
    public static void main(String[] args) {
        Goods[] knapsack = {new Goods("чайник", 2, 3),
                            new Goods("пылесос", 5, 7),
                            new Goods("бочка", 7, 2),
                            new Goods("ноутбук", 4, 8),
                            new Goods("телефон", 1, 5),
                        };
        Knapsacks work = new Knapsacks(knapsack);
        System.out.println(work);
    }
}
