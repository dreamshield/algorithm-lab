package com.ericvip.algorithm.sort;

import edu.princeton.cs.algs4.StdOut;

import java.util.Comparator;

/**
 * @author EricZhang
 * @date 2019/11/11
 * @time 9:53 PM
 */
public class BaseSort {

    protected static <T extends Comparable<? super T>> boolean bigger(T v, T w) {
        return v.compareTo(w) > 0;
    }

    protected static <T extends Comparable<? super T>> boolean smaller(T v, T w) {
        return v.compareTo(w) < 0;
    }


    protected static <T> boolean bigger(Comparator<T> comparator, T v, T w) {
        return comparator.compare(v, w) > 0;
    }

    protected static <T> boolean smaller(Comparator<T> comparator, T v, T w) {
        return comparator.compare(v, w) < 0;
    }

    protected static void swap(Object[] a, int i, int j) {
        Object temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public static <T extends Comparable<? super T>> boolean isSorted(T[] a) {
        for (int i = 0; i < a.length; i++) {
            if (bigger(a[i], a[i + 1])) {
                return false;
            }
        }
        return true;
    }

    private static <T extends Comparable<? super T>> boolean isSorted(T[] a, int lo, int hi) {
        for (int i = lo; i <= hi; i++) {
            if (bigger(a[i], a[i + 1])) {
                return false;
            }
        }
        return true;
    }

    public static <T> boolean isSorted(T[] a, Comparator<T> comparator) {
        for (int i = 0; i < a.length; i++) {
            if (bigger(comparator, a[i], a[i + 1])) {
                return false;
            }
        }
        return true;
    }

    public static <T extends Comparable<? super T>> void show(T[] a) {
        for (T val : a) {
            StdOut.print(val + " ");
        }
        StdOut.println();
    }

    public static <T extends Comparable<? super T>> void sort(T[] a) {
        throw new UnsupportedOperationException("not supported method");
    }
}
