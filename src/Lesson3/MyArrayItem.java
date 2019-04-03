package Lesson3;

public class MyArrayItem<Item> {
    protected Object[] stack = new Object[1];
    protected int size = 0;

    public int size() {
        return size;
    }
    public boolean isEmpty() {
        return size == 0;
    }
}
