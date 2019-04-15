package Lesson6;

import java.util.Random;

public class Program {
    public static void main(String[] args) {
        final int tree_count = 20;
        final int max_height = 6;
        int rnd_val = 0;

        Random rnd = new Random();
        MyTreeMap<Integer, Integer>[] treeArr = new MyTreeMap[tree_count];

        for (int i = 0; i < tree_count; i++) {
            treeArr[i] = new MyTreeMap<>();
            while (true) {
                rnd_val = rnd.nextInt(200) - 100;
                treeArr[i].put(rnd_val, rnd_val);
                if (treeArr[i].getHeight(rnd_val) > 6) break;
            }
            System.out.println("Дерево " + (i+1) + (treeArr[i].isBalanced() ? " сбалансировано" : " не сбалансировано"));
        }

        /*MyTreeMap<Character, Integer> tm = new MyTreeMap<>();
        tm.put('S', 1);
        tm.put('E', 1);
        tm.put('A', 1);
        tm.put('R', 1);
        tm.put('C', 1);
        tm.put('H', 1);
        tm.put('X', 1);*/
    }
}
