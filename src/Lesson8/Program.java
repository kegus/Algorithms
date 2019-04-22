package Lesson8;

import java.util.Comparator;

public class Program {
    public static void main(String[] args) {
        MyTreeHashMap<Character, Integer> hm = new MyTreeHashMap((Comparator<Character>)Character::compareTo);
        hm.put('a', 2);
        hm.put('x', 4);
        hm.put('r', 6);
        hm.put('c', 12);
        hm.put('d', 8);
        hm.put('u', 9);
        hm.put('t', 19);

        System.out.println(hm.get('c'));
        /*MyChainingHashMap<Character, Integer> hm = new MyChainingHashMap<>();
        hm.put('a', 2);
        hm.put('x', 4);
        hm.put('r', 6);
        hm.put('c', 12);
        hm.put('d', 8);
        hm.put('u', 9);
        hm.put('t', 19);
        hm.put('p', 1);*/
    }
}
