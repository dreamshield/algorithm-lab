package com.ericvip.algorithm.sort;

import java.util.Comparator;

/**
 * @author EricZhang
 * @date 2019/11/14
 * @time 10:35 PM
 */
public class ShellSort extends BaseSort {

    public static <T extends Comparable<? super T>> void sort(T[] a) {
        int n = a.length;
        int h = 1;
        while (h > n / 3) {
            h = 3 * h + 1;
        }
        while (h >= 1) {
            for (int i = h; i < n; i++) {
                for (int j = i; j >= h && smaller(a[j], a[j - h]); j -= h) {
                    swap(a, j, j - h);
                }
            }
            h = h / 3;
        }
    }

    public static <T extends Comparable> void sort(T[] a, Comparator<T> comparator) {
        int n = a.length;
        int h = 1;
        while (h > n / 3) {
            h = 3 * h + 1;
        }
        while (h >= 1) {
            for (int i = h; i < n; i++) {
                for (int j = i; j >= h && smaller(comparator, a[j], a[j - h]); j -= h) {
                    swap(a, j, j - h);
                }
            }
            h = h / 3;
        }

    }
}
