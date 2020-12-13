package com.ericvip.algorithm.structure;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.function.Consumer;

/**
 * 二叉查找树：每一个节点都含有一个Comparable的键(以及相关联的值)且每个节点的键都大于其左子树中的任意节点的键
 * 而小于其右子树中任意节点的键。
 *
 * @author EricZhang
 * @date 2020/11/23
 */
public class BST<K extends Comparable<? super K>, V> implements BinaryTree<K, V> {

    /**
     * 根节点
     */
    private Node<K, V> root;

    @Override
    public boolean isEmpty() {
        return root == null;
    }

    @Override
    public int size() {
        return size(root);
    }

    @Override
    public void preorderTraverse() {
        preOrderTraverse(root);
    }

    /**
     * 先序遍历指定子树序列
     * 思路:
     * step1: 一路向左遍历节点，并处理当前节点，并入栈
     * step2: 左节点处理完成，开始处理各左节点(之前入栈的节点)的右子树
     *
     * @param root 子树根节点
     */
    private void preOrderTraverse(Node<K, V> root) {
        Deque<Node<K, V>> stack = new ArrayDeque<>();
        Node<K, V> node = root;
        while (node != null || !stack.isEmpty()) {
            while (node != null) {
                doSomething(System.out::println, node.getValue());
                stack.push(node);
                node = node.getLeft();
            }
            if (!stack.isEmpty()) {
                node = stack.pop().getRight();
            }
        }
    }

    @Override
    public void inorderTraverse() {
        inOrderTraverse(root);
    }

    /**
     * 中序遍历指定子树序列
     * 思路：
     * step1: 一路向左遍历节点并入队列
     * step2: 到达最左端后，队列pop该节点并进行处理
     * step3: 处理完继续处理该节点的右子树
     *
     * @param root 当前子树的根节点
     */
    private void inOrderTraverse(Node<K, V> root) {
        Deque<Node<K, V>> stack = new ArrayDeque<>();
        Node<K, V> node = root;
        while (node != null || !stack.isEmpty()) {
            while (node != null) {
                stack.push(node.getLeft());
                node = node.getLeft();
            }

            if (!stack.isEmpty()) {
                node = stack.pop();
                doSomething(System.out::println, node.getValue());
                node = node.getRight();
            }
        }
    }

    @Override
    public void postorderTraverse() {
        postOrderTraverse(root);
    }

    /**
     * 后续遍历指定子序列
     * 思路：
     * step1: 一路向左遍历左节点并入栈
     * step2: 每次进行节点处理前，先判断该节点的右子树是否均处理完成
     * (包括两种情况：①右子树为空；②右子树遍历完成，即lastVisit = node.getRight())
     * step3: 如果右子树未遍历完成，先遍历右子树
     * 注：lastVisit初始值设置为root的原因
     *
     * @param root 根节点
     */
    private void postOrderTraverse(Node<K, V> root) {
        Deque<Node<K, V>> stack = new ArrayDeque<>();
        Node<K, V> node = root;
        Node<K, V> lastVisit = null;
        while (node != null || !stack.isEmpty()) {
            while (node != null) {
                stack.push(node);
                node = node.getLeft();
            }
            // 处理当前节点前，先判断右子树情况
            // 不满足处理当前节点条件时，当前节点还要保留在栈中，因为还没有处理，所以不能pop
            node = stack.peek();
            if (node.getRight() == null || node.getRight() == lastVisit) {
                doSomething(System.out::println, node.getValue());
                stack.pop();
                lastVisit = node;
                node = null;
            } else {
                node = node.getRight();
            }
        }
    }

    @Override
    public void levelOrderTraverse() {

    }

    private void doSomething(Consumer<V> c, V value) {
        c.accept(value);
    }

    /**
     * 获取指定节点对应子树中的节点总数
     *
     * @param node 指定的节点
     * @return 节点数
     */
    private int size(Node<K, V> node) {
        if (node == null) {
            return 0;
        }
        return node.getN();
    }

    @Override
    public void put(K key, V value) {
        root = put(root, key, value);
    }

    /**
     * 在指定子树中插入键值对
     *
     * @param node  指定子树的根节点
     * @param key   键
     * @param value 值
     * @return 新插入的节点(返回值只有在新插入节点时才有意义)
     */
    private Node<K, V> put(Node<K, V> node, K key, V value) {
        if (node == null) {
            return new Node<>(key, value, 1);
        }
        int cmp = node.getKey().compareTo(key);
        // 左子节点
        if (cmp < 0) {
            node.setLeft(put(node.getLeft(), key, value));
        }
        // 右子节点
        else if (cmp > 0) {
            node.setRight(put(node.getRight(), key, value));
        }
        // 当前节点
        else {
            node.setValue(value);
        }
        node.setN(node.getLeft().getN() + node.getRight().getN() + 1);
        return node;
    }

    /**
     * 查主指定的键
     * 实现方法：循环
     *
     * @param key 指定键
     * @return 查找结果
     */
    @Override
    public V get(K key) {
        Node<K, V> node = root;
        while (node != null) {
            int cmp = node.getKey().compareTo(key);
            if (cmp == 0) {
                return node.getValue();
            } else if (cmp < 0) {
                node = node.getRight();
            } else {
                node = node.getLeft();
            }
        }
        return null;
    }

    /**
     * 在指定的子树中查找对应键
     * 实现方法：递归
     *
     * @param node 指定子树的根节点
     * @param key  查找的键
     * @return 查找结果
     */
    public V get(Node<K, V> node, K key) {
        if (node == null) {
            return null;
        }
        int cmp = node.getKey().compareTo(key);
        // 左节点
        if (cmp < 0) {
            return get(node.getLeft(), key);
        }
        // 右节点
        else if (cmp > 0) {
            return get(node.getRight(), key);
        }
        // 当前节点
        else {
            return node.getValue();
        }
    }

    @Override
    public void delete(K key) {

    }

    @Override
    public boolean contains(K key) {
        Node<K, V> node = root;
        int cmp;
        while (node != null) {
            cmp = node.getKey().compareTo(key);
            if (cmp == 0) {
                return true;
            } else if (cmp > 0) {
                node = node.getLeft();
            } else {
                node = node.getRight();
            }
        }
        return false;
    }

    @Override
    public K minKey() {
        Node<K, V> node = minNode(root);
        if (node != null) {
            return node.getKey();
        }
        return null;
    }

    /**
     * 注：最小节点一定存在于左子树中
     */
    @Override
    public Node<K, V> minNode(Node<K, V> root) {
        Node<K, V> node = root;
        while (node != null) {
            if (node.getLeft() != null) {
                node = node.getLeft();
            } else {
                return node;
            }
        }
        return null;
    }

    @Override
    public K max() {
        Node<K, V> maxNode = maxNode(root);
        if (maxNode != null) {
            return maxNode.getKey();
        }
        return null;
    }

    /**
     * 最大节点一定存在于右子树中
     */
    @Override
    public Node<K, V> maxNode(Node<K, V> root) {
        Node<K, V> node = root;
        while (node != null) {
            if (node.getRight() != null) {
                node = node.getRight();
            } else {
                return node;
            }
        }
        return null;
    }

    @Override
    public K floorKey(K key) {
        Node<K, V> floorNode = floorNode(root, key);
        if (floorNode != null) {
            return floorNode.getKey();
        }
        return null;
    }

    /**
     * 小于等于key的最大值
     * 思路：
     * ①：当前节点等于指定的key，当前节点就是目标节点;
     * ②：当前节点小于指定的key(说明小于指定key的最大值在右子树)
     * - 如果当前节点右子树为空，或者右子树大于指定的key，那么当前节点就是目标节点
     * - 否则目标节点一定在右子树，继续遍历右子树
     * ③：当前节点大于指定的key(说明目标节点在左子树)
     * 需要向左一直遍历每个子树，同时对每个子树的根节点应用条件①与②进行判断
     */
    @Override
    public Node<K, V> floorNode(Node<K, V> root, K key) {
        Node<K, V> node = root;
        int cmp;
        while (node != null) {
            cmp = node.getKey().compareTo(key);
            if (cmp == 0) {
                return node;
            } else if (cmp > 0) {
                node = node.getLeft();
            } else {
                if (node.getRight() == null || node.getRight().getKey().compareTo(key) > 0) {
                    return node;
                } else {
                    node = node.getRight();
                }
            }
        }
        return null;
    }

    /**
     * 大于等于指定key的最小值的节点
     * 思路：
     * ①：当前节点等于指定的key, 当前节点就是目标节点;
     * ②：当前节点大于指定的key(说明大于key的最小值在左子树)
     * - 如果当前节点的做节点为空，或者当前节点的左节点小于指定的key，那么当前节点就是目标节点；
     * - 否则，最小节点一定在当前节点的左子树；
     * ③：当前节点小于指定的key(说明大于key的最小值在右子树)
     * 需要向右一直遍历，每个子树都通过条件①与②来判断节点。
     */
    @Override
    public Node<K, V> ceilingNode(Node<K, V> root, K key) {
        Node<K, V> node = root;
        int cmp;
        while (node != null) {
            cmp = node.getKey().compareTo(key);
            if (cmp == 0) {
                return node;
            } else if (cmp > 0) {
                if (node.getLeft() == null || node.getLeft().getKey().compareTo(key) < 0) {
                    return node;
                } else {
                    node = node.getLeft();
                }
            } else {
                node = node.getRight();
            }
        }
        return null;
    }

    @Override
    public K ceilingKey(K key) {
        Node<K, V> node = ceilingNode(root, key);
        if (node != null) {
            return node.getKey();
        }
        return null;
    }

    @Override
    public int rank(K key) {
        return rank(root, key);
    }

    private int rank(Node<K, V> node, K key) {
        if (node == null) {
            return 0;
        }
        int cmp = node.getKey().compareTo(key);
        if (cmp < 0) {
            return rank(node.getLeft(), key);
        } else if (cmp > 0) {
            return 1 + size(node.getLeft()) + rank(node.getRight(), key);
        } else {
            return size(node.getLeft());
        }
    }

    @Override
    public K select(int r) {
        Node<K, V> node = select(root, r);
        return node == null ? null : node.getKey();
    }

    private Node<K, V> select(Node<K, V> root, int r) {
        Node<K, V> node = root;
        int t;
        int tmp = r;
        while (node != null) {
            t = size(node.getLeft());
            if (t < tmp) {
                node = node.getLeft();
            } else if (t > tmp) {
                node = node.getRight();
                tmp -= t - 1;
            } else {
                return node;
            }
        }
        return null;
    }

    @Override
    public int maxHeight() {
        return 0;
    }

    @Override
    public void deleteMin() {
        root = deleteMin(root);
    }

    /**
     * 删除指定子树的最小值
     *
     * @param node 子树的根节点
     * @return 新子树的根节点
     */
    Node<K, V> deleteMin(Node<K, V> node) {
        if (node == null) {
            return null;
        }
        if (node.getLeft() == null) {
            return node.getRight();
        }
        node.setLeft(deleteMin(node.getLeft()));
        node.setN(1 + size(node.getLeft()) + size(node.getRight()));
        return node;
    }

    @Override
    public void deleteMax() {
        root = deleteMax(root);
    }

    /**
     * 删除指定子树的最大值
     *
     * @param node 指定子树的根节点
     * @return 新子树的根节点
     */
    Node<K, V> deleteMax(Node<K, V> node) {
        if (node == null) {
            return null;
        }
        if (node.getRight() == null) {
            return node.getLeft();
        }
        node.setRight(deleteMax(node.getRight()));
        node.setN(1 + size(node.getLeft()) + size(node.getRight()));
        return node;
    }

    @Override
    public void deleteKey(K key) {
        root = deleteKey(root, key);
    }

    /**
     * 删除指定子树中指定的键
     *
     * @param node 指定子树跟节点
     * @param key  指定删除的key
     * @return 新的子树的根
     */
    Node<K, V> deleteKey(Node<K, V> node, K key) {
        Node<K, V> curNode = node;
        if (curNode == null) {
            return null;
        }
        int cmp = curNode.getKey().compareTo(key);
        if (cmp > 0) {
            curNode.setLeft(deleteKey(curNode.getLeft(), key));
        } else if (cmp < 0) {
            curNode.setRight(deleteKey(curNode.getRight(), key));
        } else {
            if (curNode.getLeft() == null) {
                return curNode.getRight();
            }
            if (curNode.getRight() == null) {
                return curNode.getLeft();
            }
            // step1: 将当前被删除的节点临时存储
            Node<K, V> t = curNode;
            // step2: 找到被删除节点右子树的最小节点(该节点就是替换被删除节点对应位置的最新节点)
            curNode = minNode(t.getRight());
            // step3: 将最新节点的右链接指向被删除节点右子树删除最小节点后的根节点
            curNode.setRight(deleteMin(t.getRight()));
            // step4: 将最新节点的左链接指向被删除节点的左连接
            curNode.setLeft(t.getLeft());
        }
        curNode.setN(1 + size(curNode.getLeft()) + size(curNode.getRight()));
        return curNode;
    }


}
