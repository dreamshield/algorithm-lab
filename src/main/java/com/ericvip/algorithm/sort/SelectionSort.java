package com.ericvip.algorithm.sort;

import java.util.Comparator;

/**
 * @author EricZhang
 * @date 2019/11/11
 * @time 9:53 PM
 */
public class SelectionSort extends BaseSort {

    public static <T extends Comparable<? super T>> void sort(T[] a) {
        int len = a.length;
        for (int i = 0; i < len; i++) {
            int minIndex = i;
            for (int j = i + 1; j < len; j++) {
                if (smaller(a[j], a[minIndex])) {
                    minIndex = j;
                }
            }
            if (i != minIndex) {
                swap(a, i, minIndex);
            }
        }
    }

    public static <T> void sort(T[] a, Comparator<T> comparator) {
        int len = a.length;
        for (int i = 0; i < len; i++) {
            int minIndex = i;
            for (int j = i + 1; j < len; j++) {
                if (smaller(comparator, a[j], a[minIndex])) {
                    minIndex = j;
                }
            }
            if (minIndex != i) {
                swap(a, i, minIndex);
            }

        }
    }
}
