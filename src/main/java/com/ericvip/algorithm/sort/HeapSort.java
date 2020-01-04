package com.ericvip.algorithm.sort;

/**
 * @author EricZhang
 * @date 2019/12/12
 * @time 8:28 AM
 */
public class HeapSort extends BaseSort {

    public static <T extends Comparable<? super T>> void sort(T[] a) {
        int n = a.length;
        for (int k = n / 2; k >= 1; k--) {
            sink(a, k, n);
        }
        while (n > 1) {
            swap(a, 1, n--);
            sink(a, 1, n);
        }
    }

    private static <T extends Comparable<? super T>> void sink(T[] pq, int k, int n) {
        while (2 * k <= n) {
            int j = 2 * k;
            if (j < n && smaller(pq, j, j + 1)) {
                j++;
            }
            if (!smaller(k, j)) {
                break;
            }
            swap(pq, k, j);
            k = j;
        }
    }

    private static <T extends Comparable<? super T>> boolean smaller(T[] pq, int i, int j) {
        return pq[i - 1].compareTo(pq[j - 1]) < 0;
    }

    private static <T extends Comparable<? super T>> void swap(T[] pq, int i, int j) {
        T temp = pq[i - 1];
        pq[i - 1] = pq[j - 1];
        pq[j - 1] = temp;
    }

}
