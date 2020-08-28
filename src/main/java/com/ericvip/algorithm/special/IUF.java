package com.ericvip.algorithm.special;

/**
 * The interface Iuf.
 *
 * @author EricZhang
 * @date 2019 /11/8
 * @time 8 :29 AM
 */
public interface IUF {

    /**
     * 在p与q间增加一条连接
     *
     * @param p the p
     * @param q the q
     */
    void union(int p, int q);

    /**
     * 获取p所在分量的分量值
     *
     * @param p the p
     * @return int
     */
    int find(int p);

    /**
     * 判断p与q是否在同一个分量
     *
     * @param p the p
     * @param q the q
     * @return boolean
     */
    default boolean connected(int p, int q) {
        return find(p) == find(q);
    }

    /**
     * 分量的数量
     *
     * @return int
     */
    int count();
}
