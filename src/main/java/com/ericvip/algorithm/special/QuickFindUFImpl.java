package com.ericvip.algorithm.special;

/**
 * @author EricZhang
 * @date 2019/11/8
 * @time 8:41 AM
 */
public class QuickFindUFImpl implements IUF {
    /**
     * 分量id，以触点为索引
     */
    private int[] id;
    /**
     * 分量数量
     */
    private int count;

    public QuickFindUFImpl(int count) {
        this.count = count;
        id = new int[count];
        for (int i = 0; i < count; i++) {
            id[i] = i;
        }
    }

    @Override
    public void union(int p, int q) {
        int idP = find(p);
        int idQ = find(q);
        if (idP == idQ) {
            return;
        }
        for (int i = 0; i < id.length; i++) {
            if (id[i] == idP) {
                id[i] = idQ;
            }
        }
        count--;
    }

    @Override
    public int find(int p) {
        validate(p);
        return id[p];
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
