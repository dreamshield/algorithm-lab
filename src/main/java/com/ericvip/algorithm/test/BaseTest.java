package com.ericvip.algorithm.test;

import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdRandom;

import java.util.*;

/**
 * @author EricZhang
 * @date 2019/10/25
 * @time 7:34 AM
 */
public class BaseTest {

    public static void main(String[] args) {
        Map<String, String> m = new HashMap<>();
        int N = 50;
        double[] a = new double[N];
        for (int i = 0; i < N; i++) {
            a[i] = StdRandom.random();
        }
        Arrays.sort(a);
        for (int i = 0; i < N; i++) {
            double x = 1.0 * i/N;
            double y = a[i] / 2.0;
            double rw = 0.5/N;
            double rh = a[i] / 2.0;
            StdDraw.filledRectangle(x, y, rw, rh);
        }
    }

    public static <T extends Comparable<T>> T min(T[] a) {
        if (a == null || a.length == 0) {
            return null;
        }

        T smallest = a[0];
        for (T t : a) {
            if (smallest.compareTo(t) > 0) {
                smallest = t;
            }
        }
        return smallest;
    }
}
