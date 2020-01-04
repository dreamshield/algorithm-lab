package com.ericvip.algorithm.structure;

import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @author EricZhang
 * @date 2019/12/8
 * @time 10:34 PM
 */
public class MaxPQTest {

    @Test
    public void testInsert() {
        TestData td = genTestData();
        MaxPQ<String> pq = td.getPq();
        List<String> oriData = td.getOriData();
        assertFalse(pq.isEmpty());
        System.out.println("Origin Data = ");
        for (String v1 : oriData) {
            System.out.print(v1 + " ");
        }
        System.out.println("");
        System.out.println("Queue Data = ");
        for (String v2 : pq) {
            System.out.print(v2 + " ");
        }
    }

    @Test
    public void testDelMax() {
        TestData td = genTestData();
        MaxPQ<String> pq = td.getPq();
        List<String> oriData = td.getOriData();
        assertFalse(pq.isEmpty());
        String maxVal = oriData.get(0);
        for (String v1 : oriData) {
            if (v1.compareTo(maxVal) > 0) {
                maxVal = v1;
            }
        }
        int oriLen = pq.size();
        String queueMax = pq.delMax();
        assertEquals(maxVal, queueMax);
        assertEquals(oriLen - 1, pq.size());
    }

    @Test
    public void testMaxItem() {
        TestData td = genTestData();
        MaxPQ<String> pq = td.getPq();
        List<String> oriData = td.getOriData();
        assertFalse(pq.isEmpty());
        String maxVal = oriData.get(0);
        for (String v1 : oriData) {
            if (v1.compareTo(maxVal) > 0) {
                maxVal = v1;
            }
        }
        int oriLen = pq.size();
        assertEquals(maxVal, pq.maxItem());
        assertEquals(oriLen, pq.size());
    }

    @Test
    public void testIsEmpty() {
        TestData td = genTestData();
        MaxPQ<String> pq = td.getPq();
        int oriLen = pq.size();
        for (int i = 0; i < oriLen; i++) {
            pq.delMax();
        }
        assertTrue(pq.isEmpty());
        assertEquals(0, pq.size());
    }

    private TestData genTestData() {
        TestData td = new TestData();
        MaxPQ<String> pq = new MaxPQ<>();
        List<String> oriData = new ArrayList<>();
        String val;
        for (int i = 0; i < 32; i++) {
            val = RandomStringUtils.randomAlphabetic(1).toUpperCase();
            oriData.add(val);
            pq.insert(val);
        }
        td.setOriData(oriData);
        td.setPq(pq);
        return td;
    }

    private static class TestData {
        private MaxPQ<String> pq;
        private List<String> oriData;

        public MaxPQ<String> getPq() {
            return pq;
        }

        public void setPq(MaxPQ<String> pq) {
            this.pq = pq;
        }

        public List<String> getOriData() {
            return oriData;
        }

        public void setOriData(List<String> oriData) {
            this.oriData = oriData;
        }
    }
}