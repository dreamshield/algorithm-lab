package com.ericvip.algorithm.structure;

import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @author EricZhang
 * @date 2020/1/6
 * @time 7:56 AM
 */
public class LinkListTest {

    private static final List<String> TEST_DATA = Arrays.asList("A", "B", "C", "D", "E", "F", "G");

    @Test
    public void testInsertAtPointedKey() {
        LinkList<String> linkList = genTestData();
        int oriSize = linkList.size();
        String data = "Z";
        String pointedKey = "C";
        boolean res = linkList.insertAtPointedKey(pointedKey, data);
        assertTrue(res);
        int newSize = linkList.size();
        assertEquals(oriSize + 1, newSize);
        int indexZ = linkList.getIndexByKey("Z");
        int indexC = linkList.getIndexByKey("C");
        assertEquals(indexZ, indexC + 1);
        pointedKey = "L";
        res = linkList.insertAtPointedKey(pointedKey, data);
        assertFalse(res);
    }

    @Test
    public void testContainsKey() {
        LinkList<String> linkList = genTestData();
        String key = "B";
        boolean res = linkList.containsKey(key);
        assertTrue(res);
        key = "Z";
        res = linkList.containsKey(key);
        assertFalse(res);
    }

    @Test
    public void testInsertTail() {
        LinkList<String> linkList = new LinkList<>();
        for (String data : TEST_DATA) {
            linkList.insertTail(data);
        }

        int index = 0;
        assertFalse(linkList.isEmpty());
        for (String data : linkList) {
            assertEquals(TEST_DATA.get(index), data);
            index++;
        }
    }

    @Test
    public void testInsertHead() {
        LinkList<String> linkList = new LinkList<>();
        for (String data : TEST_DATA) {
            linkList.insertHead(data);
        }
        assertFalse(linkList.isEmpty());
        int index = 0;
        for (String data : linkList) {
            assertEquals(TEST_DATA.get(TEST_DATA.size() - 1 - index), data);
            index++;
        }
    }

    @Test
    public void testDeleteHead() {
        LinkList<String> linkList = genTestData();
        assertFalse(linkList.isEmpty());
        for (int i = TEST_DATA.size() - 1; i >= 0; i--) {
            assertEquals(TEST_DATA.get(i), linkList.deleteHead());
        }
        assertTrue(linkList.isEmpty());
    }

    private LinkList<String> genTestData() {
        LinkList<String> linkList = new LinkList<>();
        for (String data : TEST_DATA) {
            linkList.insertHead(data);
        }
        return linkList;
    }

    @Test
    public void testGetDataByIndex() {
        LinkList<String> linkList = new LinkList<>();
        for (String data : TEST_DATA) {
            linkList.insertTail(data);
        }
        assertFalse(linkList.isEmpty());
        for (int index = 0; index < TEST_DATA.size(); index++) {
            assertEquals(TEST_DATA.get(index), linkList.getDataByIndex(index));
        }
    }

    @Test
    public void testDeleteByKey() {
        LinkList<String> linkList = genTestData();
        assertFalse(linkList.isEmpty());
        int oriSize = linkList.size();
        boolean res = linkList.deleteByKey("C");
        int newSize1 = linkList.size();
        assertTrue(res);
        assertEquals(oriSize - 1, newSize1);
        assertFalse(linkList.containsKey("C"));
        res = linkList.deleteByKey("G");
        int newSize2 = linkList.size();
        assertTrue(res);
        assertEquals(newSize1 - 1, newSize2);
        assertFalse(linkList.containsKey("G"));
        int index = 0;
        for (String data : TEST_DATA) {
            if (data.equals("G") || data.equals("C")) {
                continue;
            }
            assertEquals(data, linkList.getDataByIndex(linkList.size() - 1 - index));
            index++;
        }
    }

    @Test
    public void testReverseByLoop() {
        LinkList<String> linkList = genTestData();
        assertFalse(linkList.isEmpty());
        linkList.reverseByLoop();
        int index = 0;
        for (String data : linkList) {
            assertEquals(TEST_DATA.get(index), data);
            index++;
        }
    }

    @Test
    public void testGetMidValueBySize() {
        LinkList<String> linkList = new LinkList<>();
        String midData;
        List<String> testData = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            String data = RandomStringUtils.randomAlphabetic(1).toUpperCase();
            testData.add(data);
            linkList.insertTail(data);
        }
        midData = testData.get(testData.size() / 2);
        assertEquals(midData, linkList.getMidValueBySize());
        String additionalData = "Z";
        testData.add(additionalData);
        linkList.insertTail(additionalData);
        midData = testData.get(testData.size() / 2);
        assertEquals(midData, linkList.getMidValueBySize());
    }

    @Test
    public void testGetMidValueByScaleplate() {
        LinkList<String> linkList = new LinkList<>();
        String midData;
        List<String> testData = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            String data = RandomStringUtils.randomAlphabetic(1).toUpperCase();
            testData.add(data);
            linkList.insertTail(data);
        }
        midData = testData.get(testData.size() / 2 - 1);
        assertEquals(midData, linkList.getMidValueByScaleplate());
        String additionalData = "Z";
        testData.add(additionalData);
        linkList.insertTail(additionalData);
        midData = testData.get(testData.size() / 2);
        assertEquals(midData, linkList.getMidValueByScaleplate());
    }

    @Test
    public void testHasCycle() {
        // 无环测试
        LinkList<String> linkListNoCycle = genTestData();
        assertFalse(linkListNoCycle.isEmpty());
        assertFalse(linkListNoCycle.hasCycle());
        // 有环
        LinkList<String> linkListHasCycle = genTestData();
        LinkList.Node<String> head = linkListHasCycle.getHeadNode();
        LinkList.Node<String> tail = linkListHasCycle.getTailNode();
        tail.setNext(head.getNext().getNext());
        assertTrue(linkListHasCycle.hasCycle());
    }

    @Test
    public void testGetTailNode() {
        // 空链表
        LinkList<String> linkList = new LinkList<>();
        assertNull(linkList.getTailNode());
        // 非空
        linkList.insertTail("A");
        linkList.insertTail("B");
        LinkList.Node<String> tail = linkList.getTailNode();
        assertNotNull(tail);
        assertEquals("B", tail.getData());
    }
}