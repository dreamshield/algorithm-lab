package com.ericvip.algorithm.special;

/**
 * @author EricZhang
 * @date 2019/11/9
 * @time 7:59 AM
 */
public class WeightedQuickUnionUFImpl implements IUF {
    /**
     * 触点索引
     */
    private int[] id;
    /**
     * 各个分量大小
     */
    private int[] sz;
    /**
     * 联通分量数量
     */
    private int count;

    public WeightedQuickUnionUFImpl(int count) {
        this.count = count;
        id = new int[count];
        sz = new int[count];
        for (int i = 0; i < count; i++) {
            id[i] = i;
            sz[i] = 1;
        }
    }

    @Override
    public void union(int p, int q) {
        int rootP = find(p);
        int rootQ = find(q);
        if (rootP == rootQ) {
            return;
        }
        // 加权，总是将较小的树连接到较大的树
        if (sz[p] <= sz[q]) {
            id[rootP] = rootQ;
            sz[rootP] += sz[rootQ];
        } else {
            id[rootQ] = rootP;
            sz[rootQ] += sz[rootP];
        }
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
        int len = id.length;
        if (p < 0 || p >= len) {
            throw new IllegalArgumentException(String.format("index %d is not between 0 and %d", p, (len-1)));
        }
    }

}
