package Lesson2;

public class Program {
    public static void main(String[] args) {
        MyArrayList<Character> list = new MyArrayList<>();
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
        System.out.println(list);
    }
}
