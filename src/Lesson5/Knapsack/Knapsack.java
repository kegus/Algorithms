package Lesson5.Knapsack;

public class Knapsack {
    public static void main(String[] args) {
        int i = 0;
        Goods[] knapsack = {new Goods("1", 1, 1),
                            new Goods("2", 2, 2),
                            new Goods("3", 3, 3),
                            new Goods("4", 4, 4),
                            new Goods("5", 5, 5),
                        };
        Knapsacks work = new Knapsacks(knapsack);
        work.takeAll();
        while (!work.isEmpty()) {
            i++;
            System.out.println(i+". " + work);
            work.throw_one();
        }
        //System.out.println(work.tmCount);
        System.out.println(work.tm);
    }
}
