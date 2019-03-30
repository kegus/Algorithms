package Lesson2;

import java.util.Comparator;
import java.util.Iterator;

public class MyArrayList<Item> /*implements Iterable<Item>*/ {
    private Object[] list = new Object[1];
    private int size = 0;

    public int size() { return size; }

    public Item get(int index) {
        if (index < 0 || index > size - 1) {
            throw new IndexOutOfBoundsException();
        }
        return (Item) list[index];
    }

    public void set(int index, Item item) {
        if (index < 0 || index > size - 1) {
            throw new IndexOutOfBoundsException();
        }
        list[index] = item;
    }

    private void resize(int capacity) {
        Object[] temp = new Object[capacity];
        System.arraycopy (list, 0, temp, 0, list.length);
        list = temp;
    }

    public void add(Item item) {
        if (size <= list.length) {
            resize(2 * list.length);
        }
        list[size] = item;
        size++;
    }

    public int indexOf(Item item) {
        for (int i = 0; i < size; i++) {
            if (list[i].equals(item)){
                return i;
            }
        }
        return -1;
    }

    public boolean remove(Item item) {
        int index = indexOf(item);
        if (index < 0) return false;
        for (int i = index; i < size - 1; i++) {
            list[i] = list[i + 1];
        }
        list[--size] = null;
        if (size == list.length / 4 && size > 0) {
            resize(list.length / 2);
        }
        return true;
    }

    public boolean contains(Item item) {
        return indexOf(item) > -1;
    }

    private void exch(int i, int j) {
        Object temp = list[i];
        list[i] = list[j];
        list[j] = temp;
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < size; i++) {
            s.append(list[i].toString() + ", ");
        }
        return s.toString();
    }

//    private class MyArrayListIterator implements Iterator<Item> {
//
//        private int cursor = 0;
//
//        @Override
//        public boolean hasNext() {
//            return cursor != size;
//        }
//
//        @Override
//        public Item next() {
//            if (!hasNext()) {
//                throw new IndexOutOfBoundsException();
//            }
//            Item item = (Item) list[cursor];
//            cursor++;
//            return item;
//        }
//    }
//
//    @Override
//    public Iterator<Item> iterator() {
//        return new MyArrayListIterator();
//    }
//    @Override
//    public Iterator<Item> iterator() {
//        return null;
//    }
    private boolean binarySearch(Item item, Comparator<Item> cmp) {
        int low = 0;
        int high = size - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int res = cmp.compare(item, (Item) list[mid]);
            if (res < 0)  high = mid - 1;
            else if (res > 0) low = mid + 1;
            else return true;
        }
        return false;
    }

    private boolean less(Item item1, Item item2, Comparator<Item> cmp) { return cmp.compare(item1, item2) < 0; }

    public void selectionSort(Comparator<Item> cmp) {
        for (int i = 0; i < size - 1; i++) {
            int min = i;
            for (int j = i + 1; j < size; j++) {
                if (less((Item)list[j], (Item)list[min], cmp)) {
                    min = j;
                }
            }
            exch(i, min);
        }
    }

    public void insertionSort(Comparator<Item> cmp) {
        for (int i = 0; i < size; i++) {
            for (int j = i; j > 0; j--) {
                if (less((Item)list[j], (Item)list[j - 1], cmp)) {
                    exch(j, j - 1);
                }
                else {
                    break;
                }
            }
        }
    }
}
