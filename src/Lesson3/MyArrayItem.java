package Lesson3;

import java.util.NoSuchElementException;

public class MyArrayItem<Item> {
    protected Object[] objArr = new Object[1];
    protected int size = 0;

    public int size() {
        return size;
    }
    public boolean isEmpty() {
        return size == 0;
    }
    public boolean isFull() {
        return size == objArr.length;
    }
    protected boolean shouldResize() {
        return size == objArr.length / 4 && size > 0;
    }
    protected Item get(int index){
        if (index < 0 || index > objArr.length - 1) throw new NoSuchElementException(" Index out of bounds");
        return (Item) objArr[index];
    }
    protected void set(Item item, int index){
        if (index < 0 || index > objArr.length - 1) throw new NoSuchElementException(" Index out of bounds");
        objArr[index] = item;
    }
}
