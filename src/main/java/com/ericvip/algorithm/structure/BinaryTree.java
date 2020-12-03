package com.ericvip.algorithm.structure;

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
 *
 * @author EricZhang
 * @date 2020/1/19
 */
public interface BinaryTree<K extends Comparable<? super K>, V> {

    /**
     * 二叉树节点
     *
     * @param <K> 键
     * @param <V> 值
     */
    class Node<K extends Comparable<? super K>, V> {
        /* 键 */
        private K key;
        /* 值 */
        private V value;
        /* 左子树 */
        private Node<K, V> left;
        /* 右子树 */
        private Node<K, V> right;
        /* 以该节点为根的子树中的节点总数 */
        private int n;

        public Node(K key, V value, int n) {
            this.key = key;
            this.value = value;
            this.n = n;
        }

        public K getKey() {
            return key;
        }

        public void setKey(K key) {
            this.key = key;
        }

        public V getValue() {
            return value;
        }

        public void setValue(V value) {
            this.value = value;
        }

        public Node<K, V> getLeft() {
            return left;
        }

        public void setLeft(Node<K, V> left) {
            this.left = left;
        }

        public Node<K, V> getRight() {
            return right;
        }

        public void setRight(Node<K, V> right) {
            this.right = right;
        }

        public int getN() {
            return n;
        }

        public void setN(int n) {
            this.n = n;
        }
    }

    /**
     * 前序遍历
     * 注：自身节点 -> 左子树 -> 右子树
     */
    void preOrderTraverse();

    /**
     * 中序遍历
     * 注：左子树 -> 自身节点 -> 右子树
     */
    void inOrderTraverse();

    /**
     * 后序遍历
     * 注：左子树 -> 右子树 -> 自身节点
     */
    void postOrderTraverse();

    /**
     * 判断树是否为空
     *
     * @return true:空，false:非空
     */
    boolean isEmpty();

    /**
     * 树的大小(节点数量)
     * 表中键值对的数量
     */
    int size();

    /**
     * 数的高度
     */
    int height();

    /**
     * 将键值对存入二叉树中
     *
     * @param key   键
     * @param value 值
     */
    void put(K key, V value);

    /**
     * 获取指定键对应的值，若key不存在返回null
     *
     * @param key 指定键
     * @return 返回值
     */
    V get(K key);

    /**
     * 从表中删去键key对应的节点
     *
     * @param key 指定键
     */
    void delete(K key);

    /**
     * 指定键key是否存在与表中
     *
     * @param key 指定的键
     * @return 判断结果
     */
    boolean contains(K key);

    /**
     * 最小的键
     */
    K minKey();

    /**
     * 返回指定子树的最小节点
     *
     * @param root 指定子树的根节点
     * @return 最小节点
     */
    Node<K, V> minNode(Node<K, V> root);

    /**
     * 最大的键
     */
    K max();

    /**
     * 返回指定子树的最大节点
     *
     * @param root 指定子树的根节点
     * @return 最大节点
     */
    Node<K, V> maxNode(Node<K, V> root);

    /**
     * 小于等于key的最大键
     *
     * @param key 指定的key
     */
    K floorKey(K key);

    /**
     * 指定子树中小于等于key的最大节点
     *
     * @param root 子树的根节点
     * @param key  指定key
     * @return 找到的节点
     */
    Node<K, V> floorNode(Node<K, V> root, K key);

    /**
     * 大于等于key的最小键
     *
     * @param key 指定的键
     */
    K ceilingKey(K key);

    /**
     * 指定子树中大于等于key的最小节点
     *
     * @param root 子树的根节点
     * @param key  指定key
     * @return 找到的节点
     */
    Node<K, V> ceilingNode(Node<K, V> root, K key);

    /**
     * 小于等于key的键的数量
     *
     * @param key 指定的key
     * @return 键的数量
     */
    int rank(K key);

    /**
     * 排名为r的键
     *
     * @param r 指定的排名
     * @return 对应的键
     */
    K select(int r);

}
