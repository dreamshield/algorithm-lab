package com.ericvip.algorithm.structure;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * @author EricZhang
 * @date 2019/10/31
 * @time 8:13 AM
 */
public class Queue<E> implements Iterable<E> {
    private Node<E> head;
    private Node<E> tail;
    private int len;

    public Queue() {
        head = null;
        tail = null;
        len = 0;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public int size() {
        return len;
    }

    public E peek() {
        if (isEmpty()) {
            throw new NoSuchElementException("Queue underflow");
        }
        return head.item;
    }

    public void enqueue(E item) {
        Node<E> temp = new Node<>();
        temp.item = item;
        if (isEmpty()) {
            head = tail = temp;
        } else {
            tail.next = temp;
            tail = temp;
        }
        len++;
    }

    public E dequeue() {
        if (isEmpty()) {
            throw new NoSuchElementException("Queue underflow");
        }
        E item = head.item;
        head = head.next;
        len--;
        if (isEmpty()) {
            tail = head;
        }
        return item;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (E item : this) {
            sb.append(item);
            sb.append(" ");
        }
        return sb.toString();
    }

    private static class Node<T> {
        private T item;
        private Node<T> next;
    }

    @Override
    public Iterator<E> iterator() {
        return new ListIterator<>(head);
    }

    private static class ListIterator<T> implements Iterator<T> {
        private Node<T> current;

        public ListIterator(Node<T> current) {
            this.current = current;
        }

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public T next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            T item = current.item;
            current = current.next;
            return item;
        }
    }
}
