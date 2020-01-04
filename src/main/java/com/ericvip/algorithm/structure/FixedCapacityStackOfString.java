package com.ericvip.algorithm.structure;

/**
 * @author EricZhang
 * @date 2019/10/29
 * @time 8:08 AM
 */
public class FixedCapacityStackOfString {

    private int index;

    private String[] a;

    public FixedCapacityStackOfString(int cap) {
        a = new String[cap];
    }

    public void push(String item) {
        a[index++] = item;
    }

    public String pop() {
        return a[--index];
    }

    public int size() {
        return index;
    }

    public boolean isEmpty() {
        return index == 0;
    }
}
