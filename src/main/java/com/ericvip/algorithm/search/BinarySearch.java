package com.ericvip.algorithm.search;

/**
 * @author EricZhang
 * @date 2019/10/24
 * @time 8:36 AM
 */
public class BinarySearch {

    private static int indexOf(int key, int[] a) {
        int low = 0;
        int high = a.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (key < a[mid]) {
                high = mid - 1;
            } else if (key > a[mid]) {
                low = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    public static int rank(int key, int[] a) {
        return indexOf(key, a);
    }
}
