package Lesson3;

//import java.util.ArrayDeque;

import java.util.NoSuchElementException;

public class MyArrayDeque<Item> extends MyArrayItem<Item> {
    private int left = -1;
    private int right = -1;

    private void resize(int capacity) {
        Object[] tmp = new Object[capacity];
        if (left < 0 || right < 0); else {
            for (int i = 0; i < size; i++) tmp[i] = objArr[(left + i) % objArr.length]; //x % n = [0;n - 1]
            left = 0;
            right = size - 2 < 0 ? 0 : size - 2;
        }
        objArr = tmp;
    }

    public void insertLeft(Item item) {
        size++;
        if (isFull()) resize(2 * objArr.length);
        if (left < 0) {
            left = 0;
            right = 0;
        } else if (--left < 0) left = objArr.length-1;
        set(item, left);
    }

    public void insertRight(Item item) {
        size++;
        if (isFull()) resize(2 * objArr.length);
        if (right < 0) {
            left = 0;
            right = 0;
        } else if (++right == objArr.length) right = 0;
        set(item, right);
    }

    public Item removeLeft(){
        Item item = peekLeft();
        size--;
        left++;
        if (shouldResize()) resize(objArr.length / 2);
        left %= objArr.length;
        return item;
    }
    public Item removeRight(){
        Item item = peekRight();
        size--;
        right--;
        if (shouldResize()) resize(objArr.length / 2);
        if (right < 0) right = objArr.length-1;
        return item;
    }
    public Item peekLeft(){
        if (isEmpty()) throw new NoSuchElementException("Deque is empty");
        return get(left);
    }
    public Item peekRight(){
        if (isEmpty()) throw new NoSuchElementException("Deque is empty");
        return get(right);
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        if (left < 0 || right < 0 || isEmpty() ) s.append("Empty deque"); else
        for (int i = 0; i < size; i++) {
            s.append(objArr[(left + i) % objArr.length] + ", ");
        }
        return s.toString();
    }
}
