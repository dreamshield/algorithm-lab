package com.ericvip.algorithm.sword;

import java.util.Stack;

/**
 * 面试题9：用两个栈实现队列
 * 描述：用两个栈实现一个队列。队列的声明如下，请实现它的两个函数 appendTail 和 deleteHead。
 * 分别完成在队列尾部插入整数和在队列头部删除整数的功能。(若队列中没有元素，deleteHead操作返回 -1 )
 * 注意：1 <= values <= 10000
 * 最多会对 appendTail、deleteHead 进行 10000 次调用
 *
 * @author EricZhang
 * @date 2020/12/28
 * @time 8:01 AM
 */
public class StackToCQueue {

    private Stack<Integer> storeStack;
    private Stack<Integer> delStack;

    public StackToCQueue() {
        storeStack = new Stack<>();
        delStack = new Stack<>();
    }

    public void appendTail(int value) {
        if (value < 1 || value > 10000) {
            throw new IllegalArgumentException("参数不在有效范围");
        }
        storeStack.push(value);
    }

    public int deleteHead() {
        if (delStack.isEmpty()) {
            while (!storeStack.isEmpty()) {
                delStack.push(storeStack.pop());
            }
        }
        if (delStack.isEmpty()) {
            return -1;
        }
        return delStack.pop();
    }
}
