package com.ericvip.algorithm.sort;

import java.util.Arrays;
import java.util.List;

/**
 * @author EricZhang
 * @date 2019/11/25
 * @time 8:26 AM
 */
public class MergeBUSort extends BaseSort {

    public static <T extends Comparable<? super T>> void sort(T[] a) {
        int len = a.length;
        for (int sz = 1; sz < len; sz *= 2) {
            for (int lo = 0; lo < len - sz; lo += 2 * sz) {
                merge(a, lo, lo + sz - 1, Math.min(lo + 2 * sz - 1, len - 1));
            }
        }
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
