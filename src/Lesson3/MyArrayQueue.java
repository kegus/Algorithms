package Lesson3;

import java.util.NoSuchElementException;

public class MyArrayQueue<Item> extends MyArrayItem<Item> {
    private int start = 0;
    private int end = 0;

    private void resize(int capacity) {
        Object[] tmp = new Object[capacity];
        for (int i = 0; i < size; i++) tmp[i] = objArr[(start + i) % objArr.length]; //x % n = [0;n - 1]
        objArr = tmp;
        start = 0;
        end  = size;
    }

    public void enqueue(Item item) {
        if (isFull()) resize(2 * objArr.length);
        set(item, end++);
        end %= objArr.length;
        size++;
    }

    public Item dequeue() {
        Item item = peekFront();
        size--;
        start++;
        start %= objArr.length;
        if (shouldResize()) resize(objArr.length / 2);
        return item;
    }

    public Item peekFront() {
        if (isEmpty()) throw new NoSuchElementException("Queue is empty");
        return get(start);
    }
}