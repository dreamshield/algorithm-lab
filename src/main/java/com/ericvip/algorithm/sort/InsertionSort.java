package com.ericvip.algorithm.sort;

import java.util.Comparator;

/**
 * @author EricZhang
 * @date 2019/11/11
 * @time 10:26 PM
 */
public class InsertionSort extends BaseSort {

    public static <T extends Comparable<? super T>> void sort(T[] a) {
        int len = a.length;
        for (int i = 1; i < len; i++) {
            for (int j = i; j > 0 && smaller(a[j], a[j - 1]); j--) {
                swap(a, j, j - 1);
            }
        }
    }

    public static <T> void sort(T[] a, Comparator<? super T> comparator) {
        int len = a.length;
        for (int i = 0; i < len; i++) {
            for (int j = i; j > 0 && smaller(comparator, a[j], a[j - 1]) ; j--) {
                swap(a, j,  j - 1);
            }
        }
    }
}
