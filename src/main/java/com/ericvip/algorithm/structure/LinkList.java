package com.ericvip.algorithm.structure;

/**
 * @author EricZhang
 * @date 2019/12/31
 * @time 8:50 AM
 */
public class LinkList<T> {
    private Node<T> head;


    private static class Node<T> {
        private T data;
        private Node<T> next;

        public Node(T data, Node<T> next) {
            this.data = data;
            this.next = next;
        }

        public T getData() {
            return data;
        }

        public void setData(T data) {
            this.data = data;
        }

        public Node<T> getNext() {
            return next;
        }

        public void setNext(Node<T> next) {
            this.next = next;
        }
    }

}
