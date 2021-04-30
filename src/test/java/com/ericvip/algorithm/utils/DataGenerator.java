package com.ericvip.algorithm.utils;

import org.apache.commons.lang3.RandomUtils;

/**
 * @author Eric
 * @date 2021-04-27
 **/
public class DataGenerator {

    /**
     * 生成指定长度与最大值的数组
     *
     * @param len 数组指定长度
     * @param max 指定的最大值
     * @return 数据
     */
    public static int[] generateRandomIntArr(int len, int max) {
        int[] arr = new int[len];
        for (int i = 0; i < len; i++) {
            arr[i] = RandomUtils.nextInt() % max;
        }
        return arr;
    }

    public static void main(String[] args) {
        int len = 20;
        int[] arr = generateRandomIntArr(len, 20);
        for (int i = 0; i < len; i++) {
            System.out.println("i = " + i + " v = " + arr[i]);
        }
    }
}
