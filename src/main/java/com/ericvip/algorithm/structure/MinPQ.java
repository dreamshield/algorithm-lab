package com.ericvip.algorithm.structure;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * @author EricZhang
 * @date 2019/12/8
 * @time 5:53 PM
 */
public class MinPQ<E extends Comparable<? super E>> implements Iterable<E> {
    private static final int DEFAULT_INITIAL_CAPACITY = 1 << 3;
    private int index = 0;
    private E[] pq;

    @SuppressWarnings("unchecked")
    public MinPQ() {
        pq = (E[]) new Comparable[DEFAULT_INITIAL_CAPACITY];
    }

    public void insert(E item) {
        if (index == pq.length) {
            resize(pq.length << 1);
        }
        pq[++index] = item;
        swim(index);
    }

    public E delMin() {
        if (isEmpty()) {
            throw new NoSuchElementException("Queue underflow");
        }
        if (index == pq.length >> 2) {
            resize(pq.length >> 1);
        }
        E min = pq[1];
        swap(1, index--);
        pq[index + 1] = null;
        sink(1);
        return min;
    }

    private void swap(int i, int j) {
        E temp = pq[i];
        pq[i] = pq[j];
        pq[j] = temp;
    }

    private void swim(int k) {
        while (k > 1) {
            int parent = k >> 1;
            if (!larger(parent, k)) {
                break;
            }
            swap(parent, k);
            k = parent;
        }
    }

    private void sink(int k) {
        while (2 * k <= index) {
            int j = k << 1;
            if (j < index && larger(j, j + 1)) {
                j++;
            }
            if (!larger(k, j)) {
                break;
            }
            swap(k, j);
            k = j;
        }
    }

    private boolean larger(int i, int j) {
        return pq[i].compareTo(pq[j]) > 0;
    }

    public int size() {
        return index;
    }

    public boolean isEmpty() {
        return index == 0;
    }

    private void resize(int newLen) {
        pq = Arrays.copyOf(pq, newLen);
    }

    @Override
    public Iterator<E> iterator() {
        return new HeapIterator();
    }

    private class HeapIterator implements Iterator<E> {
        private MinPQ<E> copy = new MinPQ<>();

        public HeapIterator() {
            for (int i = 0; i < index; i++) {
                copy.insert(pq[i]);
            }
        }

        @Override
        public boolean hasNext() {
            return !copy.isEmpty();
        }

        @Override
        public E next() {
            if (!hasNext()) {
                throw new NoSuchElementException("Queue underflow");
            }
            return copy.delMin();
        }
    }
}
