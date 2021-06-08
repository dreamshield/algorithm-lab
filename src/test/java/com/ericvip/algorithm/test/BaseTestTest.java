package com.ericvip.algorithm.test;

import com.ericvip.algorithm.utils.DataGenerator;
import org.junit.Test;

public class BaseTestTest {

    @Test
    public void testQuickSort() {
        long start1 = System.currentTimeMillis();
        for (int i = 0; i < 1000; i++) {
            int[] arr = DataGenerator.generateRandomIntArr(2000, 10000);
            BaseTest.quickSortV1(arr, 0, arr.length - 1);
        }
        long end1 = System.currentTimeMillis();
        System.out.println("diffV1=" + (end1 - start1));

        long start2 = System.currentTimeMillis();
        for (int i = 0; i < 1000; i++) {
            int[] arr = DataGenerator.generateRandomIntArr(2000, 10000);
            BaseTest.quickSortV2(arr, 0, arr.length - 1);
        }
        long end2 = System.currentTimeMillis();
        System.out.println("diffV2=" + (end2 - start2));
    }
}