package com.ericvip.algorithm.sword;

/**
 * 面试题5：对两个非空有序数组进行合并，合并后的数组依然是有序的。
 * 并且其中一个数组的剩余空间完全可以容纳下另一个数组。
 *
 * @author EricZhang
 * @date 2020/9/4
 * @time 7:43 AM
 */
public class SortedArrayMerge {

    /**
     * 算法思路：从尾到头比较两个数组中的元素，将较大的元素复制到大数组中尾部的合适位置
     * <p>
     * 注：arr1的长度可以同时容纳arr1与arr2
     *
     * @param arr1 数组1
     * @param arr2 数组2
     */
    public static void merge(Integer arr1[], Integer arr2[]) {
        if (arr1.length == 0 || arr2.length == 0) {
            throw new NumberFormatException("数组不能为空");
        }

        int arr1ValidLen = 0;
        int arr2ValidLen = 0;

        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != null) {
                arr1ValidLen++;
                continue;
            }
            break;
        }
        for (int i = 0; i < arr2.length; i++) {
            if (arr2[i] != null) {
                arr2ValidLen++;
                continue;
            }
            break;
        }
        int i = arr1ValidLen - 1;
        int j = arr2ValidLen - 1;

        while (j >= 0) {
            if ((i >= 0) && (arr1[i] > arr2[j])) {
                arr1[i + j + 1] = arr1[i];
                i--;
            } else {
                arr1[i + j + 1] = arr2[j];
                j--;
            }
        }
    }
}
