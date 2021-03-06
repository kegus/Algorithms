package Lesson4;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class MyLinkedList<Item> implements Iterable<Item> {
    private Node first = null;
    private Node last = null;
    private int size = 0;

    @Override
    public Iterator<Item> iterator() {
        return new MyLinkedListIterator();
    }

    private class MyLinkedListIterator implements Iterator<Item> {
        Node cursor = first;
        @Override
        public boolean hasNext() {
            return cursor != null;
        }

        @Override
        public Item next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            Item item = cursor.item;
            cursor = cursor.next;
            return item;
        }
    }

    private class Node {
        Item item;
        Node next;
        Node previous;

        public Node(Node previous, Item item, Node next) {
            this.previous = previous;
            this.item = item;
            this.next = next;
        }
    }

    public int size() {return size;}

    public boolean isEmpty() {return size == 0;}

    public Item getFirst() {
        if (isEmpty()) {
            throw new NoSuchElementException("List is empty.");
        }
        return first.item;
    }

    public void addFirst(Item item) {
        Node oldFirst = first;
        first = new Node(null, item, oldFirst);
        if (isEmpty()) {
            last = first;
        }
        else {
            oldFirst.previous = first;
        }
        size++;
    }

    public Item removeFirst() {
        if (isEmpty()) {
            throw new NoSuchElementException("List is empty");
        }
        Node second = first.next;
        Item item = first.item;
        first.next = null;
        first = second;
        size--;
        if (isEmpty()) {
            last = null;
        }
        else {
            second.previous = null;
        }
        return item;
    }

    public Item getLast() {
        if (isEmpty()) {
            throw new NoSuchElementException("List is empty.");
        }
        return last.item;
    }

    public void addLast(Item item) {
        Node oldLast = last;
        last = new Node(oldLast, item, null);
        if (isEmpty()) {
            first = last;
        }
        else {
            oldLast.next = last;
        }
        size++;
    }

    public Item removeLast() {
        if (isEmpty()) {
            throw new NoSuchElementException("List is empty.");
        }
        Item item = last.item;
        Node previous = last.previous;
        last.previous = null;
        last = previous;
        size--;
        if (isEmpty()) {
            first = null;
        }
        else {
            last.next = null;
        }
        return item;
    }

    private Node getNodeByIndex(int index) {
        int currentIndex;
        Node current = null;
        if (index > size / 2) {
            currentIndex = size - 1;
            current = last;
            while (currentIndex > index) {
                current = current.previous;
                currentIndex--;
            }
        } else {
            currentIndex = 0;
            current = first;
            while (currentIndex < index) {
                current = current.next;
                currentIndex++;
            }
        }
        return current;
    }
    public Item get(int index) {
        if (index < 0 || index > size - 1) throw new IndexOutOfBoundsException();
        return getNodeByIndex(index).item;
    }

    public void set(int index, Item item) {
        if (index < 0 || index > size - 1)  throw new IndexOutOfBoundsException();
        getNodeByIndex(index).item = item;
    }

    public int indexOf(Item item) {
        Node current = first;
        int currentIndex = 0;
        while (current != null && !current.item.equals(item)) {
            current = current.next;
            currentIndex++;
        }
        return current != null ? currentIndex : -1;
    }

    public boolean contains(Item item) {return indexOf(item) > -1;}

    public Item remove(Item item) {
        Node current = first;

        while (current != null && !current.item.equals(item)) {
            current = current.next;
        }
        if (current == null) {
            return null;
        }
        if (current == first) {
            return removeFirst();
        }
        if (current == last) {
            return removeLast();
        }

        Node next = current.next;
        Node previous = current.previous;
        previous.next = next;
        next.previous = previous;
        size--;
        current.previous = null;
        current.next = null;
        return current.item;
    }

    public void add(int index, Item item) { //addBefore
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }
        if (index == 0) {
            addFirst(item);
            return;
        }
        if (index == size) {
            addLast(item);
            return;
        }
        Node current = getNodeByIndex(index);
        Node newNode = new Node(current.previous, item, current);
        Node previous = current.previous;
        previous.next = newNode;
        current.previous = newNode;
        size++;
    }

    public void delete(int index) {
        if (index < 0 || index > size - 1) {
            throw new IndexOutOfBoundsException();
        }
        if (index == 0) {
            removeFirst();
            return;
        }
        if (index == size - 1) {
            removeLast();
            return;
        }
        Node current = getNodeByIndex(index);
        Node previous = current.previous;
        Node next = current.next;
        previous.next = next;
        next.previous = previous;
        size--;
        current.next = null;
        current.previous = null;
    }

    public String toString() {
        StringBuilder s = new StringBuilder();
        Node current = first;
        while (current != null) {
            s.append(current.item.toString());
            s.append(", ");
            current = current.next;
        }
        return s.toString();
    }
}