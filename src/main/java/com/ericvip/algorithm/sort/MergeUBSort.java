package com.ericvip.algorithm.sort;

import java.util.Arrays;
import java.util.List;

/**
 * @author EricZhang
 * @date 2019/11/17
 * @time 10:07 AM
 */
public class MergeUBSort extends BaseSort {

    public static <T extends Comparable<? super T>> void sort(T[] a) {
        sort(a, 0, a.length - 1);
    }

    private static <T extends Comparable<? super T>> void sort(T[] a, int lo, int hi) {
        if (hi <= lo) {
            return;
        }
        int mid = lo + (hi - lo) / 2;
        sort(a, lo, mid);
        sort(a, mid + 1, hi);
        merge(a, lo, mid, hi);
    }

    private static <T extends Comparable<? super T>> void merge(T[] a, int lo, int mid, int hi) {
        int i = lo;
        int j = mid + 1;
        List<T> aux = Arrays.asList(a);

        for (int k = 0; k <= hi; k++) {
            if (i > mid) {
                a[k] = aux.get(j++);
            } else if (j > hi) {
                a[k] = aux.get(i++);
            } else if (smaller(aux.get(j), aux.get(i))) {
                a[k] = aux.get(j++);
            } else {
                a[k] = aux.get(i++);
            }
        }
    }
}
