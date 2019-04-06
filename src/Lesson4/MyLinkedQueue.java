package Lesson4;

public class MyLinkedQueue<Item> {
    private MyLinkedList<Item> queue = new MyLinkedList<>();

    public void enqueue(Item item) {queue.addFirst(item);}

    public Item dequeue() {return queue.removeLast();}

    public Item peekFront() {return queue.getLast();}

    public int size() {return queue.size();}

    public boolean isEmpty() {return queue.isEmpty();}

    public String toString() {return queue.toString();}
}
