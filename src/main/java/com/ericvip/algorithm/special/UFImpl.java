package com.ericvip.algorithm.special;

/**
 * 基于路径压缩的quick-union算法.
 *
 * @author EricZhang
 * @date 2019 /11/10
 * @time 8 :16 AM
 */
public class UFImpl implements IUF {

    /**
     * 触点索引
     */
    private int[] id;
    /**
     * 各个分量大小
     */
    private int[] sz;
    /**
     * 分量数量
     */
    private int count;

    public UFImpl(int count) {
        if (count <= 0) {
            throw new IllegalArgumentException(String.format("Array length must be lager than 0, count=%d", count));
        }
        id = new int[count];
        sz = new int[count];

        this.count = count;
        for (int i = 0; i < count; i++) {
            id[i] = i;
            sz[i] = 1;
        }
    }

    @Override
    public void union(int p, int q) {
        int idP = find(p);
        int idQ = find(q);

        if (idP == idQ) {
            return;
        }

        if (sz[idP] > sz[idQ]) {
            id[idQ] = id[idP];
            sz[idP] += sz[idQ];
        } else {
            id[idP] = id[idQ];
            sz[idQ] += sz[idP];
        }
        count--;
    }

    @Override
    public int find(int p) {
        validate(p);
        while (p != id[p]) {
            // 查找跳跃一个
            id[p] = id[id[p]];
            p = id[p];
        }
        return p;
    }

    @Override
    public int count() {
        return count;
    }

    private void validate(int p) {
        int len = id.length;
        if (p < 0 || p >= len) {
            throw new IllegalArgumentException(String.format("index %d is not between 0 and %d", p, (len-1)));
        }
    }
}
