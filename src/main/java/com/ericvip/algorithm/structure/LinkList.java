package com.ericvip.algorithm.structure;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * LinkList类实现了单链表数据结构以及与其相关的常用操作
 *
 * @author EricZhang
 * @date 2019/12/31
 * @time 8:50 AM
 */
public class LinkList<T> implements Iterable<T> {

    private static final String LINK_LIST_IS_EMPTY = "Link list is empty";
    private Node<T> head;
    private int size = 0;

    /**
     * 获取有环链表中环的起始节点
     * 思路：1. 判断链表是否有环；2.根据"Floyd cycle detection algorithm"原理，
     * 获取环的起始节点
     * @return 无环：null；有环：Node<T> 环的入口节点
     */
    public Node<T> getCycleStartPoint() {
        Node<T> node = hasCycleReturnByNode();
        if (node == null) {
            return null;
        }
        Node<T> probNode = head;
        while (!probNode.equals(node)) {
            probNode = probNode.next;
            node = node.next;
        }
        return probNode;
    }

    /**
     * 返回有环链表中环的长度
     * 思路：1.判断链表是否有环；2.有环的情况下根据步骤1返回环中任意节点，遍历环一周，
     * 得到环的长度
     * @return 如果链表无环返回0；有环返回对应的长度
     */
    public int getLinkListCycleLength() {
        Node<T> node = hasCycleReturnByNode();
        if (node == null) {
            return 0;
        }
        Node<T> current = node;
        int len = 1;
        while (!current.next.equals(node)) {
            current = current.next;
            len++;
        }
        return len;
    }

    /**
     * 判断链表是否有环
     * 基本思路：采用快慢指针，快指针一次走两步，慢指针一次走一步，
     * 当两个指针相遇时，则表示链表存在环；否则不存在
     * 算法原理："Floyd cycle detection algorithm"
     * @return 有：true；无：false；链表为空返回false
     */
    public boolean hasCycle() {
        if (isEmpty()) {
            return false;
        }
        Node<T> walker = head;
        Node<T> runner = head;
        while (runner.next != null) {
            walker = walker.next;
            if (runner.next.next != null) {
                runner = runner.next.next;
            }
            if (walker.equals(runner)) {
                return true;
            }
        }
        return false;
    }

    /**
     * 判断链表是否有环
     * 基本思想：采用快慢指针，快指针一次走两步，慢指针一次走一步，
     * 当两个指针相遇时，则表示链表存在环；否则不存在
     * 算法原理："Floyd cycle detection algorithm"
     * @return 当链表有环时返回环内任意一个节点；当链表无环时返回null;
     */
    public Node<T> hasCycleReturnByNode() {
        if (isEmpty()) {
            return null;
        }
        Node<T> walker = head;
        Node<T> runner = head;
        while (runner.next != null) {
            walker = walker.next;
            if (runner.next.next != null) {
                runner = runner.next.next;
            }
            if (walker.equals(runner)) {
                return walker;
            }
        }
        return null;
    }

    /**
     * 该方法通过记录的链表size值，直接计算得到中间节点
     * 注：当链表有偶数个节点时，中间节点为中间两个节点的后一个节点
     *
     * @return 链表为空：返回null；非空返回对应的中间节点
     */
    public T getMidValueBySize() {
        if (isEmpty()) {
            return null;
        }
        return getDataByIndex(size() / 2);
    }

    /**
     * 查找单链表的中间节点-快慢指针法(标尺法)
     * 定义两个指针变量，快指针一次移动两个节点，慢指针一次移动1个节点，当快指针到达链表尾部时，
     * 慢指针所在的位置就是链表的中间节点
     * 注：当链表有偶数个节点时，中间节点为中间两个节点的前一个节点
     *
     * @return 链表为空：返回null；链表非空：中间节点对应的数据
     */
    public T getMidValueByScale() {
        if (isEmpty()) {
            return null;
        }
        Node<T> runner = head;
        Node<T> walker = head;
        while (runner.next != null) {
            if (runner.next.next != null) {
                runner = runner.next.next;
                walker = walker.next;
            } else {
                runner = runner.next;
            }
        }
        return walker.data;
    }

    /**
     * 链表反转-递归法
     * 基本思想：从头结点找到尾节点，然后从尾节点往回走，
     * 再将当节点的下一个节点的直接后继设置为当前节点。
     * 注：该方法仅用于记录算法思路，不作为实际应用
     *
     * @param head 当前头结点
     * @return 反转后的头结点
     */
    public static <E> Node<E> reverseByRecursion(Node<E> head) {
        if (head == null || head.next == null) {
            return head;
        }
        Node<E> current = reverseByRecursion(head.next);
        head.next.next = head;
        head.next = null;
        return current;
    }

    /**
     * 链表反转-遍历法
     * 基本思想：从链表头开始依次遍历链表各个节点，并改变每个节点next域指针的指向，
     * 即指向当前节点的直接前驱
     */
    public void reverseByLoop() {
        if (isEmpty()) {
            throw new NoSuchElementException(LINK_LIST_IS_EMPTY);
        }
        // 当前节点的直接前驱
        Node<T> prev = head;
        // 当前节点
        Node<T> cur = head.next;
        // 保存当前节点的直接后继
        Node<T> temp;
        while (cur != null) {
            temp = cur.next;
            cur.next = prev;
            prev = cur;
            cur = temp;
        }
        head.next = null;
        head = prev;
    }

    /**
     * 查找指定key对应的索引，找到返回对应的索引，未找到抛出异常
     *
     * @param key 指定的key
     * @return 索引
     */
    public int getIndexByKey(T key) {
        if (isEmpty()) {
            throw new NoSuchElementException(LINK_LIST_IS_EMPTY);
        }
        int index = 0;
        Node<T> current = head;
        while (current != null) {
            if (current.data.equals(key)) {
                return index;
            }
            current = current.next;
            index++;
        }
        throw new NoSuchElementException("The pointed key not exist");
    }

    /**
     * 查找指定索引对应的值
     *
     * @param findIndex 指定的索引
     * @return 查找结果
     */
    public T getDataByIndex(int findIndex) {
        if (findIndex < 0 || findIndex >= size()) {
            throw new IndexOutOfBoundsException("Index out of link list bounds");
        }
        Node<T> current = head;
        int index = 0;
        while (current != null) {
            // 距离需要的索引位置较远时，一次移动两个节点，加快移动速度
            // 当快要接近索引位置时，一次移动一个节点
            if (index < findIndex - 2) {
                current = current.next.next;
                index += 2;
            } else if (findIndex == index) {
                return current.data;
            } else {
                current = current.next;
                index++;
            }
        }
        return null;
    }

    /**
     * 在指定key的节点后面插入数据，注：仅在第一个匹配key处插入
     *
     * @param key  指定的key节点
     * @param data 待插入的数据
     * @return 插入结果
     */
    public boolean insertAtPointedKey(T key, T data) {
        Node<T> current = head;
        while (current != null) {
            if (current.data.equals(key)) {
                Node<T> newNode = new Node<>(data);
                newNode.next = current.next;
                current.next = newNode;
                size++;
                return true;
            }
            current = current.next;
        }
        return false;
    }

    /**
     * 删除指定的key对应的节点，头结点要特殊处理
     * 注：仅删除第一个匹配到key的节点
     *
     * @param key 待删除的key
     * @return 返回删除的节点
     */
    public boolean deleteByKey(T key) {
        if (isEmpty()) {
            throw new NoSuchElementException(LINK_LIST_IS_EMPTY);
        }
        Node<T> current = head;
        Node<T> previous = head;
        while (!current.data.equals(key)) {
            // 未找到对应节点，直接返回
            if (current.next == null) {
                return false;
            }
            previous = current;
            current = current.next;
        }

        if (current == head) {
            head = head.next;
        } else {
            previous.next = current.next;
        }
        size--;
        return true;
    }

    /**
     * 判断链表是否包含指定的key
     *
     * @param key 待查找的key
     * @return 查找结果
     */
    public boolean containsKey(T key) {
        Node<T> current = head;
        while (current != null) {
            if (current.data.equals(key)) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    /**
     * 链表数据插入-尾插法，注：这里为了简化其它操作，没有采用记录尾结点的方法
     *
     * @param data 待插入的数据
     */
    public void insertTail(T data) {
        Node<T> current = head;
        Node<T> newNode = new Node<>(data);
        if (isEmpty()) {
            head = newNode;
        } else {
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
        size++;
    }

    /**
     * 链表数据插入-头插法
     *
     * @param data 待插入数据
     */
    public void insertHead(T data) {
        Node<T> newNode = new Node<>(data);
        newNode.next = head;
        head = newNode;
        size++;
    }

    /**
     * 链表数据删除-头删除
     *
     * @return 删除的节点对应的数据
     */
    public T deleteHead() {
        if (isEmpty()) {
            throw new NoSuchElementException(LINK_LIST_IS_EMPTY);
        }
        Node<T> temp = head;
        head = head.next;
        size--;
        return temp.data;
    }

    /**
     * 获取尾结点
     *
     * @return 尾结点
     */
    public Node<T> getTailNode() {
        if (isEmpty()) {
            return null;
        }
        Node<T> current = head;
        while (current.next != null) {
            current = current.next;
        }
        return current;
    }

    /**
     * 获取头结点
     *
     * @return 头结点
     */
    public Node<T> getHeadNode() {
        return head;
    }

    /**
     * 从尾到头遍历链表：栈遍历法
     */
    public void iteratorFromTailToHeadByStack() {
        if (size() == 0) {
            return;
        }
        Stack<T> stack = new Stack<>();
        Node<T> current = head;
        while(current != null) {
            stack.push(current.getData());
            current = current.next;
        }
        while (!stack.isEmpty()) {
            System.out.println("Data=" + stack.pop());
        }
    }

    /**
     * 从尾到头打印链表: 递归法
     */
    public void iteratorFromTailToHeadByRecursive() {
        if (head != null) {
            if (head.next != null) {
                iteratorFromTailToHeadByRecursive();
            }
            System.out.println("Data=" + head.getData());
        }
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            Node<T> current = head;

            @Override
            public boolean hasNext() {
                return current != null;
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                T data = current.data;
                current = current.next;
                return data;
            }
        };
    }

    /**
     * 判断链表是否为空
     *
     * @return 判空结果
     */
    public boolean isEmpty() {
        return head == null;
    }

    public int size() {
        return size;
    }

    public LinkList() {
        this.head = null;
    }

    public LinkList(Node<T> head) {
        this.head = head;
    }

    static class Node<E> {
        private E data;
        private Node<E> next;

        public Node(E data) {
            this.data = data;
        }

        public E getData() {
            return data;
        }

        public void setData(E data) {
            this.data = data;
        }

        public Node<E> getNext() {
            return next;
        }

        public void setNext(Node<E> next) {
            this.next = next;
        }
    }
}
