package com.ericvip.algorithm.structure;

import java.util.Arrays;
import java.util.Iterator;

/**
 * @author EricZhang
 * @date 2019/10/30
 * @time 8:49 AM
 */
public class ResizingArrayStack<E> implements Iterable<E> {

    private E[] a = (E[]) new Object[16];
    private int index;

    private void resize(int newSize) {
        a = Arrays.copyOf(a, newSize);
    }

    public void push(E item) {
        if (index == a.length) {
            resize(2 * a.length);
        }
        a[index++] = item;
    }

    public E pop() {
        if (index > 0 && index == a.length / 4) {
            resize(a.length / 2);
        }
        E item = a[--index];
        a[index] = null;
        return item;
    }

    public boolean isEmpty() {
        return index == 0;
    }

    public int size() {
        return index;
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
