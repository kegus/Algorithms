package Lesson3;

import java.util.NoSuchElementException;

public class MyArrayStack<Item> extends MyArrayItem<Item> {
    private void resize(int capacity) {
        Object[] tmp = new Object[capacity];
        for (int i = 0; i < size; i++) tmp[i] = objArr[i];
        objArr = tmp;
    }

    public void push(Item item) {
        if (isFull()) resize(objArr.length * 2);
        set(item, size++);
    }

    public Item pop() {
        Item item = peek();
        size--;
        if (shouldResize()) resize(objArr.length / 2);
        return item;
    }

    public Item peek() {
        if (isEmpty()) throw new NoSuchElementException("Stack is empty");
        return get(size - 1);
    }
    public String toString() {
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < size; i++) {
            s.append(objArr[i] + ", ");
        }
        return s.toString();
    }
}