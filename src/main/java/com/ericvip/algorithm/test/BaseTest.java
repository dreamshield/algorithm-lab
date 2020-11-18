package com.ericvip.algorithm.test;

import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdRandom;

import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @author EricZhang
 * @date 2019/10/25
 * @time 7:34 AM
 */
public class BaseTest {

    public static void main(String[] args) {
        SimpleDateFormat
                dfDateOnly = new SimpleDateFormat("yyyy/MM/dd"),
                dfYearWeek = new SimpleDateFormat("YYYY/ww");

        Calendar c = Calendar.getInstance();
        c.set(2015, 11, 31);

        System.out.println("Date: " + dfDateOnly.format(c.getTime()));
        System.out.println("Week: " + dfYearWeek.format(c.getTime()));
        String t = "We are happy";
        t.replace("", "%");
        int[] arr = new int[10];
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
