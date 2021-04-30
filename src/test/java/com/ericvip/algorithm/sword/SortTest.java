package com.ericvip.algorithm.sword;

import com.ericvip.algorithm.utils.DataGenerator;
import org.junit.Test;

import static org.junit.Assert.*;

public class SortTest {

    @Test
    public void testQuickSort() {
        int[] arr = DataGenerator.generateRandomIntArr(20, 100);
        System.out.println("-------------排序前------------");
        for (int a : arr) {
            System.out.println("v=" + a);
        }
        Sort.quickSort(arr, 0, arr.length - 1);
        System.out.println("-------------排序后------------");
        for (int a : arr) {
            System.out.println("v=" + a);
        }
    }

}