package com.ericvip.algorithm.structure;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * @author EricZhang
 * @date 2019/12/8
 * @time 8:09 AM
 */
public class MaxPQ<E extends Comparable<? super E>> implements Iterable<E> {
    private static final int DEFAULT_INITIAL_CAPACITY = 1 << 3;
    private int index = 0;
    private E[] pq;

    @SuppressWarnings("unchecked")
    public MaxPQ() {
        pq = (E[]) new Comparable[DEFAULT_INITIAL_CAPACITY];
    }

    public void insert(E item) {
        if (index == pq.length - 1) {
            resize(pq.length << 1);
        }
        pq[++index] = item;
        swim(index);
    }

    public E delMax() {
        if (isEmpty()) {
            throw new NoSuchElementException("Priority queue underflow");
        }
        E max = pq[1];
        swap(1, index--);
        pq[index + 1] = null;
        sink(1);
        if (index == pq.length >> 2) {
            resize(pq.length >> 1);
        }
        return max;
    }
    
    public E maxItem() {
        if (isEmpty()) {
            throw new NoSuchElementException("Priority queue underflow");
        }
        return pq[1];
    }

    public boolean isEmpty() {
        return index == 0;
    }

    public int size() {
        return index;
    }

    public void swim(int k) {
        while (k > 1) {
            int parent = k >> 1;
            if (!smaller(parent, k)) {
                break;
            }
            swap(parent, k);
            k = parent;
        }
    }

    public void sink(int k) {
        while (2 * k <= index) {
            int j = k << 1;
            if (j < index && smaller(j, j + 1)) {
                j++;
            }
            if (!smaller(k, j)) {
                break;
            }
            swap(k, j);
            k = j;
        }
    }

    public boolean smaller(int i, int j) {
        return pq[i].compareTo(pq[j]) < 0;
    }

    public void swap(int i, int j) {
        E temp = pq[i];
        pq[i] = pq[j];
        pq[j] = temp;
    }

    public void resize(int newLen) {
        pq = Arrays.copyOf(pq, newLen);
    }

    @Override
    public Iterator<E> iterator() {
        return new HeapIterator();
    }

    private class HeapIterator implements Iterator<E> {
        private MaxPQ<E> copy;

        public HeapIterator() {
            copy = new MaxPQ<>();
            for (int i = 1; i <= index; i++) {
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
                throw new NoSuchElementException("Priority queue underflow");
            }
            return copy.delMax();
        }
    }
}
