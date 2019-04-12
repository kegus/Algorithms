package Lesson5.Knapsack;

import java.util.Arrays;

public class Knapsacks {
    private Goods[] knapsack;

    public Knapsacks(Goods[] knapsack) {
        this.knapsack = knapsack;
    }
    public int getWeight() {
        int res = 0;
        for (int i = 0; i < knapsack.length; i++) {
            res += knapsack[i].getWeight();
        }
        return res;
    }
    public int getPrice() {
        int res = 0;
        for (int i = 0; i < knapsack.length; i++) {
            res += knapsack[i].getPrice();
        }
        return res;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < knapsack.length; i++) {
            sb.append(knapsack[i]+" ");
        }
        sb.append(getWeight() + " " + getPrice());
        return sb.toString();
    }
}
