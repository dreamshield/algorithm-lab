package com.ericvip.algorithm.sword;

/**
 * @author Eric
 * @date 2021-04-27
 **/
public class Sort {

    private Sort() {
    }

    /**
     * 快速排序
     * 算法说明：快速排序算法首先会在序列中随机选择一个基准值（pivot），然后将除了基准值以外的数分为“比基准值小的数”和“比基准值大的数”这两个类别
     * 再将其排列成以下形式: [ 比基准值小的数 ] 基准值 [ 比基准值大的数 ]
     * <p>
     * 算法平均时间复杂度：O[nlog(n)]；算法最差时间复杂度: O[n2]
     *
     * @param arr 待排序数组
     */
    public static void quickSort(int[] arr, int lo, int hi) {
        if (hi <= lo) {
            return;
        }
        int k = partition(arr, lo, hi);
        quickSort(arr, lo, k - 1);
        quickSort(arr, k + 1, hi);

    }

    private static int partition(int[] arr, int lo, int hi) {
        int i = lo;
        int j = hi + 1;
        int key = arr[lo];
        int temp;
        while (true) {
            while (arr[++i] < key) {
                if (i == hi) {
                    break;
                }
            }

            while (arr[--j] > key) {
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
        arr[j] = key;
        return j;
    }
}
