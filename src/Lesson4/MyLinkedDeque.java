package Lesson4;

public class MyLinkedDeque<Item> {
    private MyLinkedList<Item> deque = new MyLinkedList<>();

    public void insertLeft(Item item) {deque.addFirst(item);}

    public void insertRight(Item item) {deque.addLast(item);}

    public Item removeLeft() {return deque.removeFirst();}

    public Item removeRight() {return deque.removeLast();}

    public Item peekLeft() {return deque.getFirst();}

    public Item peekRight() {return deque.getLast();}

    public String toString() {return deque.toString();}
}
