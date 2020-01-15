package com.ericvip.algorithm.structure;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * @author EricZhang
 * @date 2019/10/31
 * @time 7:47 AM
 */
public class Stack<E> implements Iterable<E> {
    private static final String STACK_UNDERFLOW = "Stack underflow";
    private Node<E> head;
    private int depth;

    public Stack() {
        head = null;
        depth = 0;
    }

    public void push(E item) {
        Node<E> newNode = new Node<>(item);
        newNode.next = head;
        head = newNode;
        depth++;
    }

    public E pop() {
        if (isEmpty()) {
            throw new NoSuchElementException(STACK_UNDERFLOW);
        }
        E item = head.item;
        head = head.next;
        depth--;
        return item;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public int size() {
        return depth;
    }

    public E peek() {
        if (isEmpty()) {
            throw new NoSuchElementException(STACK_UNDERFLOW);
        }
        return head.item;
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

        public Node(T item) {
            this.item = item;
        }
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
                throw new NoSuchElementException(STACK_UNDERFLOW);
            }
            T item = current.item;
            current = current.next;
            return item;
        }
    }
}
