package com.ericvip.algorithm.structure;

import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @author EricZhang
 * @date 2019/12/3
 * @time 7:59 AM
 */
public class StackTest {

    @Test
    public void testPush() {
        int len = 10;
        Stack<String> stack = new Stack<>();
        List<String> list = new ArrayList<>();
        for (int i = 0; i < len; i++) {
            String val = RandomStringUtils.randomAlphabetic(10);
            stack.push(val);
            list.add(val);
        }
        assertFalse(stack.isEmpty());
        assertEquals(len, stack.size());
        System.out.println(stack.toString());
        int i = len - 1;
        for (String item : stack) {
            assertEquals(list.get(i), item);
            i--;
        }
    }

    @Test
    public void testPop() {
        int oriLen = 10;
        int popLen = 5;
        Stack<String> stack = new Stack<>();
        List<String> list = new ArrayList<>();
        for (int i = 0; i < oriLen; i++) {
            String val = RandomStringUtils.randomAlphabetic(10);
            stack.push(val);
            list.add(val);
        }
        assertFalse(stack.isEmpty());
        for (int i = 0; i < popLen; i++) {
            String val = stack.pop();
            assertEquals(list.get(oriLen - 1 - i), val);
        }
        assertEquals(oriLen - popLen, stack.size());
    }

    @Test
    public void testIsEmpty() {
        int oriLen = 10;
        Stack<String> stack = new Stack<>();
        assertTrue(stack.isEmpty());
        for (int i = 0; i < oriLen; i++) {
            stack.push(RandomStringUtils.randomAlphabetic(10));
        }
        assertFalse(stack.isEmpty());
        assertFalse(stack.isEmpty());
        int depth = stack.size();
        for (int i = 0; i < depth; i++) {
            stack.pop();
        }
        assertTrue(stack.isEmpty());
    }

    @Test
    public void testPeek() {
        int oriLen = 10;
        Stack<String> stack = new Stack<>();
        assertTrue(stack.isEmpty());
        String val = null;
        for (int i = 0; i < oriLen; i++) {
            val = RandomStringUtils.randomAlphabetic(10);
            stack.push(val);
        }
        assertFalse(stack.isEmpty());
        assertEquals(val, stack.peek());
        assertEquals(oriLen, stack.size());
    }

    @Test
    public void testForeach() {
        int oriLen = 10;
        Stack<String> stack = new Stack<>();
        assertTrue(stack.isEmpty());
        for (int i = 0; i < oriLen; i++) {
            stack.push(RandomStringUtils.randomAlphabetic(10));
        }
        assertFalse(stack.isEmpty());
        for (String item : stack) {
            System.out.println("item = " + item);
        }
        assertFalse(stack.isEmpty());
    }
}