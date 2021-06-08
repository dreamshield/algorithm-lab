package com.ericvip.algorithm.sort;

/**
 * @author EricZhang
 * @date 2019/12/12
 * @time 8:28 AM
 */
public class HeapSort extends BaseSort {

    /**
     * 堆排序
     *
     * @param a   待排序数组
     * @param <T> 泛型
     */
    public static <T extends Comparable<? super T>> void sort(T[] a) {
        int n = a.length;
        // 构造堆，从n/2开始，跳过大小为1的子堆
        for (int k = n / 2; k >= 1; k--) {
            sink(a, k, n);
        }

        while (n > 1) {
            swap(a, 1, n--);
            sink(a, 1, n);
        }
    }

    /**
     * 小值节点下沉
     *
     * @param pq  数组
     * @param k   第k节点
     * @param n   节点总数
     * @param <T> 泛型
     */
    private static <T extends Comparable<? super T>> void sink(T[] pq, int k, int n) {
        while (2 * k <= n) {
            int j = 2 * k;
            // 获取左右子节点中，最大的一个
            if (j < n && smaller(pq, j, j + 1)) {
                j++;
            }
            if (!smaller(k, j)) {
                break;
            }
            // 交换父节点与子节点
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
