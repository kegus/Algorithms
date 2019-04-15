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

    public boolean isEmpty() {
        for (int i = 0; i < knapsack.length; i++) {
            if (!knapsack[i].isTaken()) return false;
        }
        return true;
    }

    public void process() {
        int i = 0;
        int n = 1;
        while (!isEmpty()) {
            knapsack[i].setTaken(true);
            Goods[] tmp = new Goods[knapsack.length - n];
            for (int j = 0, k = 0; j < knapsack.length; j++) {
                if (!knapsack[j].isTaken()) {
                    tmp[k] = knapsack[j];
                    k++;
                }
            }
        }
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
