package com.ericvip.algorithm.structure;

import org.junit.Test;

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
    }

    @Test
    public void testFindByKey() {
    }

    @Test
    public void testInsertTail() {
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
}