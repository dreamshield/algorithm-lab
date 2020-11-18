package com.ericvip.algorithm.sword;

import org.junit.Assert;
import org.junit.Test;


/**
 * @author EricZhang
 * @date 2020/9/6
 * @time 8:12 AM
 */
public class SortedArrayMergeTest {

    @Test
    public void testMerge() {
        Integer[] arr1 = {1, 2, 3, 4, 5, null, null, null, null, null, null, null, null};
        Integer[] arr2 = {0, 2, 7, 8, 9};
        SortedArrayMerge.merge(arr1, arr2);
        Integer[] res = {0, 1, 2, 2, 3, 4, 5, 7, 8, 9};
        for (int i = 0; i < res.length; i++) {
            Assert.assertEquals(arr1[i], res[i]);
        }
    }
}