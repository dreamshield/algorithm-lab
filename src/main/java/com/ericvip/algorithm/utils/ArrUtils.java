package com.ericvip.algorithm.utils;

/**
 * @author EricZhang
 * @date 2020/8/27
 * @time 8:11 AM
 */
public class ArrUtils {

    private ArrUtils() {
    }

    public static void swap(int[] nums, int i, int j) {
        if (nums == null) {
            return;
        }
        if (nums.length < Math.max(i, j) || i < 0 || j < 0) {
            throw new IndexOutOfBoundsException("Array index out of range");
        }
        int aux = nums[i];
        nums[i] = nums[j];
        nums[j] = aux;
    }
}
