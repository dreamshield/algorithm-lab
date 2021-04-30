package com.ericvip.algorithm.test;

/**
 * @author EricZhang
 * @date 2019/10/25
 * @time 7:34 AM
 */
public class BaseTest {

    public static void quickSort(int[] arr, int lo, int hi) {
        if (lo >= hi) {
            return;
        }
        int j = partition(arr, lo, hi);
        quickSort(arr, lo, j - 1);
        quickSort(arr, j + 1, hi);

    }

    private static int partition(int[] arr, int lo, int hi) {
        int i = lo;
        int j = hi + 1;
        int k = arr[lo];
        int temp;
        while (true) {
            while(arr[++i] < k) {
                if (i == hi) {
                    break;
                }
            }
            while(arr[--j] > k) {
                if (j == lo) {
                    break;
                }
            }
            if (i >= j) {
                break;
            }
            temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
        arr[lo] = arr[j];
        arr[j] = k;
        return j;
    }
}
