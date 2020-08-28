package com.ericvip.algorithm.structure;

import java.util.Iterator;

/**
 * @author EricZhang
 * @date 2020/1/19
 * @time 8:34 AM
 */
public interface BinaryTree {
    /**
     * 以下内容是对二叉树相关的定义与性质的整理：
     * 节点深度：对于任意节点n,n的深度为从根到n的唯一路径长，根的深度为0。
     * 节点高度：对于任意节点n,n的高度为从n到一片树叶的最长路径长，所有树叶的高度为0。
     * 树的深度=树的高度(每个的定义不同，可能出现大小为1的差值)。
     * 树的深度(深度比高度更能提现一棵向下生长的二叉树)：树中所有节点的最大深度，称为树的深度。特别的根节点的深度为0。
     * 度：树中任意节点的子树数目，称为该节点的度。
     * 树的度：一棵树中子树度的最大值。
     * 路径：由树中k+1节点通过树边首尾衔接而构成的序列{(v0, v1),(v1, v2), …, (vk-1 , vk) | k ≥ 0}，称作树中长度为k的一条路径(Path)。
     * 二叉树：是指每个节点最多有两个子树的有序树，通常将其两个子树的根分别称作"左子树"和"右子树"。
     * 满二叉树：除了叶子节点外，每一个节点都有左右子叶，并且叶子节点都处在最底层的二叉树。
     * 完全二叉树：只有在最下面两层节点的度小于2，并且最下面一层的节点都集中在该层最左边的若干位置的二叉树。
     * 二叉树的性质：
     * 性质①：在二叉树中，深度为k的节点不超过2^k个。
     * 性质②：深度为h的二叉树，最多包含2^(h+1)-1个节点。
     * 性质③：由n个节点构成的二叉树，深度至少为floor(log2(n))。
     * 性质④：对于任意一棵二叉树，如果叶子节点数为n0，且度2的节点数为n2，则n0=n2+1。
     * 性质⑤：由n个节点构成的完全二叉树，高度为floor(log2(n))。
     * 性质⑥：由固定数目的节点组成的所有二叉树中，完全二叉树的高度最低。
     * 性质⑦：对于一个有n个节点构成的完全二叉树，且节点采用顺序存储的方式存储，则节点之间存在如下关系：
     * A：如果i=1，则节点i为根，无父节点；如果i>1，则其父节点为floor(i/2);
     * B：如果2i<=n，则其左子树的根节点为2i；如果2i>n，则无左子树；
     * C：如果2i+1<=n，则其右子树的根节点为2i+1；如果2i+1>n，则无右子树。
     */

    /**
     * 判断树是否为空
     * @return true:空，false:非空
     */
    boolean isEmpty();

    /**
     * 树的大小(节点数量)
     * @return
     */
    int size();

    /**
     * 数的高度
     * @return
     */
    int height();

//    Iterator





}
