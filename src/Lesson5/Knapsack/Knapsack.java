package Lesson5.Knapsack;

public class Knapsack {
    public static void main(String[] args) {
        Goods[] knapsack = {new Goods("it1", 2, 3),
                            new Goods("it2", 5, 7),
                            new Goods("it3", 7, 2),
                        };
        Knapsacks work = new Knapsacks(knapsack);
        System.out.println(work);
    }
}
