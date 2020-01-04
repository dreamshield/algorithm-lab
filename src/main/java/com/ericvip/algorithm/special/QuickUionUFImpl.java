package com.ericvip.algorithm.special;

/**
 * @author EricZhang
 * @date 2019/11/8
 * @time 8:56 AM
 */
public class QuickUionUFImpl implements IUF {
    /**
     * 已触点为索引
     */
    private int[] id;
    /**
     * 分量数量
     */
    private int count;

    public QuickUionUFImpl(int count) {
        this.count = count;
        id = new int[count];
        for (int i = 0; i < count; i++) {
            id[i] = i;
        }
    }

    @Override
    public void union(int p, int q) {
        int rootP = find(p);
        int rootQ = find(p);
        if (rootP == rootQ) {
            return;
        }
        id[p] = rootQ;
        count--;
    }

    @Override
    public int find(int p) {
        validate(p);
        while (p != id[p]) {
            p = id[p];
        }
        return p;
    }

    @Override
    public int count() {
        return count;
    }

    private void validate(int p) {
        int n = id.length;
        if (p < 0 || p >= n) {
            throw new IllegalArgumentException(String.format("index %d is not between 0 and %d", p, (n-1)));
        }
    }
}
