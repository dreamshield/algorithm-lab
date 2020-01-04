package com.ericvip.algorithm.structure;

import java.util.Arrays;
import java.util.Iterator;

/**
 * @author EricZhang
 * @date 2019/10/30
 * @time 7:19 AM
 */
public class FixedCapacityStack<E> implements Iterable<E> {
    private int index;
    private E[] a;

    @SuppressWarnings("unchecked")
    public FixedCapacityStack(int cap) {
        a = (E[]) new Object[cap];
    }

    private void resize(int max) {
        a = Arrays.copyOf(a, max);
    }

    public void push(E item) {
        if (a.length == index) {
            resize(2 * a.length);
        }
        a[index++] = item;
    }

    public E pop() {
        E item = a[--index];
        a[index] = null;
        if (index > 0 && index == a.length / 4) {
            resize(a.length / 2);
        }
        return item;
    }

    public int size() {
        return index;
    }

    public boolean isEmpty() {
        return index == 0;
    }

    @Override
    public Iterator<E> iterator() {
        return new ReverseArrayIterator();
    }

    private class ReverseArrayIterator implements Iterator<E> {
        private int i = index;

        @Override
        public boolean hasNext() {
            return i > 0;
        }

        @Override
        public E next() {
            return a[--i];
        }
    }
}
