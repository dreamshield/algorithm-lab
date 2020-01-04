package com.ericvip.algorithm.sort;

import edu.princeton.cs.algs4.StdRandom;

/**
 * @author EricZhang
 * @date 2019/11/21
 * @time 8:46 AM
 */
public class QuickSort extends BaseSort {

    public static <T extends Comparable<? super T>> void sort(T[] a) {
        StdRandom.shuffle(a);
        sort(a, 0, a.length - 1);
    }

    private static <T extends Comparable<? super T>> void sort(T[] a, int lo, int hi) {
        if (hi <= lo) {
            return;
        }
        int j = partion(a, lo, hi);
        sort(a, lo, j - 1);
        sort(a, j + 1, hi);
    }

    private static <T extends Comparable<? super T>> int partion(T[] a, int lo, int hi) {
        int i = lo;
        int j = hi + 1;
        T v = a[lo];
        while (true) {
            while (smaller(a[++i], v)) {
                if (i == hi) {
                    break;
                }
            }
            while (smaller(v, a[--j])) {
                if (j == lo) {
                    break;
                }
            }
            if (i >= j) {
                break;
            }
            swap(a, i, j);
        }
        swap(a, lo, j);
        return j;
    }

    private QuickSort() {
    }
}
