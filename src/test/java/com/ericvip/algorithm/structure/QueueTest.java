package com.ericvip.algorithm.structure;

import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author EricZhang
 * @date 2019/12/2
 * @time 8:26 AM
 */
public class QueueTest {

    @Test
    public void testIsEmpty() {
        Queue<String> queue = new Queue<>();
        int len = 10;
        for (int i = 0; i < len; i++) {
            String val = RandomStringUtils.randomAlphabetic(10);
            queue.enqueue(val);
        }
        Assert.assertFalse(queue.isEmpty());
        Assert.assertEquals(len, queue.size());
        for (int i = 0; i < len; i++) {
            queue.dequeue();
        }
        Assert.assertEquals(0, queue.size());
        Assert.assertTrue(queue.isEmpty());
    }

    @Test
    public void testPeek() {
        Queue<String> queue = new Queue<>();
        int len = 10;
        List<String> strList = new ArrayList<>();
        for (int i = 0; i < len; i++) {
            String val = RandomStringUtils.randomAlphabetic(10);
            queue.enqueue(val);
            strList.add(val);
        }
        Assert.assertFalse(queue.isEmpty());
        String item = queue.peek();
        Assert.assertEquals(strList.get(0), item);
        Assert.assertEquals(len, queue.size());
    }

    @Test
    public void testEnqueue() {
        Queue<String> queue = new Queue<>();
        int len = 10;
        for (int i = 0; i < len; i++) {
            queue.enqueue(RandomStringUtils.randomAlphabetic(10));
        }
        Assert.assertFalse(queue.isEmpty());
        Assert.assertEquals(len, queue.size());
        System.out.println(queue.toString());
    }

    @Test
    public void testDequeue() {
        Queue<String> queue = new Queue<>();
        int oriLen = 10;
        List<String> strList = new ArrayList<>();
        for (int i = 0; i < oriLen; i++) {
            String val = RandomStringUtils.randomAlphabetic(10);
            queue.enqueue(val);
            strList.add(val);
        }
        Assert.assertFalse(queue.isEmpty());
        System.out.println("Origin Queue:" + queue.toString());
        int dequeueLen = 5;
        for (int i = 0; i < 5; i++) {
            String item = queue.dequeue();
            Assert.assertEquals(strList.get(i), item);
        }
        Assert.assertEquals(oriLen - dequeueLen, queue.size());
        System.out.println("After dequeue:" + queue.toString());
    }

    @Test
    public void testGC() {
        Queue<String> queue = new Queue<>();
        int oriLen = 10;
        for (int i = 0; i < oriLen; i++) {
            String val = RandomStringUtils.randomAlphabetic(10);
            queue.enqueue(val);
        }
        for (int i = 0; i < 5; i++) {
            queue.dequeue();
        }
        System.out.println("Done");
        Assert.assertTrue(true);
    }

    @Test
    public void testForeach() {
        Queue<String> queue = new Queue<>();
        int oriLen = 10;
        for (int i = 0; i < oriLen; i++) {
            String val = RandomStringUtils.randomAlphabetic(10);
            queue.enqueue(val);
        }
        Assert.assertFalse(queue.isEmpty());
        for (String item : queue) {
            System.out.println("item = " + item);
        }
        Assert.assertFalse(queue.isEmpty());
    }
}