package ru.job4j.collection;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

public class ForwardLinked<T> implements Iterable<T> {
    private int size;
    private int modCount;
    private Node<T> head;

    public void add(T value) {
       Node<T> l = head;
        final Node<T> newNode = new Node<>(value, null);
        if (head == null) {
            head = newNode;
        } else {
            while (l.next != null) {
                l = l.next;
            }
            l.next = newNode;
        }
        modCount++;
        size++;
    }

    public T get(int index) {
       Objects.checkIndex(index, size);
        Node<T> next = head;
        for (int i = 0; i != index; i++) {
            next = next.next;
        }
        return next.item;
    }

    public void addFirst(T value) {
        head = new Node<>(value, head);
        modCount++;
        size++;
    }

    public T deleteFirst() {
        if (head == null) {
            throw new NoSuchElementException();
        }
        T deleteItem = head.item;
        Node<T> temp = head.next;
        head.item = null;
        head.next = null;
        head = temp;
        size--;
        modCount++;
        return deleteItem;
    }

    @Override
    public Iterator<T> iterator() {
         return new Iterator<T>() {
            final int expectedModCount = modCount;
            Node<T> l;
            Node<T> next = head;

            @Override
            public boolean hasNext() {
                if (expectedModCount != modCount) {
                    throw new ConcurrentModificationException();
                }
                return next != null;
            }

            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                l = next;
                next = next.next;
                return l.item;
            }
        };
    }

    public int getSize() {
        return size;
    }

    private static class Node<T> {
       private T item;
        private Node<T> next;

        Node(T element, Node<T> next) {
            this.item = element;
            this.next = next;
        }
    }
}