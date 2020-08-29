package com.ericvip.algorithm.sword;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author EricZhang
 * @date 2020/8/29
 * @time 9:05 AM
 */
public class TwoDimensionArrayTest {

    @Test
    public void testFind() {
        // 二维数组为空
        boolean res = TwoDimensionArray.findTargetNum(null, 123);
        Assert.assertFalse(res);
        // 第二维为null
        res = TwoDimensionArray.findTargetNum(new int[][]{null, null}, 123);
        Assert.assertFalse(res);
        // 第二全部无值
        res = TwoDimensionArray.findTargetNum(new int[][]{}, 123);
        Assert.assertFalse(res);
        // 找到目标值
        int[][] arr = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        for (int[] nums : arr) {
            for (int anInt : nums) {
                res = TwoDimensionArray.findTargetNum(arr, anInt);
                if (!res) {
                    System.out.println("curNum=" + anInt);
                }
                Assert.assertTrue(res);
            }
        }
        // 未找到目标值
        res = TwoDimensionArray.findTargetNum(arr, 10);
        Assert.assertFalse(res);
    }
}