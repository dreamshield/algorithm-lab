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

    private Node<T> head;

    /**
     * 在指定key的节点后面插入数据，注：仅在第一个匹配key处插入
     *
     * @param key  指定的key节点
     * @param data 待插入的数据
     */
    public void insertAtPointedKey(T key, T data) {
        Node<T> current = head;
        while (current != null) {
            if (current.data.equals(key)) {
                Node<T> newNode = new Node<>(data);
                newNode.next = current.next;
                current.next = newNode;
                break;
            }
            current = current.next;
        }
    }

    /**
     * 删除指定的key对应的节点，头结点要特殊处理
     * 注：仅删除第一个匹配到key的节点
     *
     * @param key 待删除的key
     * @return 返回删除的节点
     */
    public Node<T> deleteByKey(T key) {
        if (isEmpty()) {
            throw new NoSuchElementException("LinkList is empty");
        }
        Node<T> current = head;
        Node<T> previous = head;
        while (!current.data.equals(key)) {
            // 未找到对应节点，直接返回
            if (current.next == null) {
                return null;
            }
            previous = current;
            current = current.next;
        }

        if (current == head) {
            head = head.next;
        } else {
            previous.next = current.next;
        }
        return current;
    }

    /**
     * 查找指定的key，找到返回对应节点，未找到返回null
     *
     * @param key 待查找的key
     * @return 查找结果
     */
    public Node<T> findByKey(T key) {
        Node<T> current = head;
        while (current != null) {
            if (current.data.equals(key)) {
                return current;
            }
            current = current.next;
        }
        return null;
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
        }
        while (current.next != null) {
            current = current.next;
        }
        current.next = newNode;
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
    }

    /**
     * 链表数据删除-头删除
     *
     * @return 删除的节点对应的数据
     */
    public T deleteHead() {
        if (isEmpty()) {
            throw new NoSuchElementException("LinkList is empty");
        }
        Node<T> temp = head;
        head = head.next;
        return temp.data;
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

    public LinkList() {
        this.head = null;
    }

    public LinkList(Node<T> head) {
        this.head = head;
    }

    private static class Node<E> {
        private E data;
        private Node<E> next;

        public Node(E data) {
            this.data = data;
        }

        public Node(E data, Node<E> next) {
            this.data = data;
            this.next = next;
        }
    }
}
