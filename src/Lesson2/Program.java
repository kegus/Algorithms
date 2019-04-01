package Lesson2;

import java.util.Random;

public class Program {
    private static Random rnd = new Random();
    private static int N = 10000;
    private static int a = 0;
    private static int b = 100;
    private static int M = 10;
    private static MyArrayList<Integer> list;

    private static void newList(){
        int rndNum;
        list = new MyArrayList<>();
        for (int i = 0; i < N; i++) {
            rndNum = a + rnd.nextInt(b);
            list.add(rndNum);
        }
    };

    public static void main(String[] args) {
        long timeAlg1;
        long timeAlg2;
        long timeInsert = 0;
        long timeSelect = 0;
        long timeBubble = 0;

        System.out.println("№  Вставка   Выбор  Пузырёк");
        for (int i = 0; i < M; i++) {
            System.out.print((i+1)+"     ");
            newList();
            timeAlg1 = System.currentTimeMillis();
            list.insertionSort(Integer::compareTo);
            timeAlg2 = System.currentTimeMillis();
            timeInsert += timeAlg2 - timeAlg1;
            System.out.print(timeAlg2 - timeAlg1 + "     ");

            newList();
            timeAlg1 = System.currentTimeMillis();
            list.selectionSort(Integer::compareTo);
            timeAlg2 = System.currentTimeMillis();
            timeSelect += timeAlg2 - timeAlg1;
            System.out.print(timeAlg2 - timeAlg1 + "     ");

            newList();
            timeAlg1 = System.currentTimeMillis();
            list.sortBubble(Integer::compareTo);
            timeAlg2 = System.currentTimeMillis();
            timeBubble += timeAlg2 - timeAlg1;
            System.out.println(timeAlg2 - timeAlg1);
        }
        System.out.println("среднее: " + timeInsert / M + "    " + timeSelect / M + "    " + timeBubble / M);

        /*MyArrayList<Character> list = new MyArrayList<>();
        list.add('a');
        list.add('d');
        list.add('x');
        list.add('e');
        list.add('t');
//        System.out.println(list.size());
//        System.out.println(list.indexOf('c'));
//        System.out.println(list.contains('x'));
//        System.out.println(list);
        list.add('f');
        list.add('t');
        System.out.println(list);
        list.insertionSort(Character::compareTo);
        System.out.println(list);*/
    }
}
