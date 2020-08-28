package com.ericvip.algorithm.sword;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

/**
 * @author EricZhang
 * @date 2020/8/25
 * @time 11:19 PM
 */
public class DuplicationInArrayTest {

    List<Integer> duplicatedNum = Arrays.asList(1, 6);

    @Test
    public void testFindDuplicatedNumSimpleLoop() {
        // input is null
        int res = DuplicationInArray.findDuplicatedNumSimpleLoop(null);
        Assert.assertEquals(-1, res);
        // have duplicated num
        res = DuplicationInArray.findDuplicatedNumSimpleLoop(getDuplicatedNumArr());
        Assert.assertTrue(duplicatedNum.contains(res));
        // has no duplicated num
        res = DuplicationInArray.findDuplicatedNumSimpleLoop(getNoDuplicatedNumArr());
        Assert.assertEquals(-1, res);
    }
    @Test
    public void testFindDuplicatedNumHashSet() {
        // input is null
        int res = DuplicationInArray.findDuplicatedNumHashSet(null);
        Assert.assertEquals(-1, res);
        // have duplicated num
        res = DuplicationInArray.findDuplicatedNumHashSet(getDuplicatedNumArr());
        Assert.assertTrue(duplicatedNum.contains(res));
        // has no duplicated num
        res = DuplicationInArray.findDuplicatedNumHashSet(getNoDuplicatedNumArr());
        Assert.assertEquals(-1, res);
    }

    @Test
    public void testFinDuplicatedNumNoExtraSpaceLoop() {
        // input is null
        int res = DuplicationInArray.findDuplicatedNumNoExtraSpaceLoop(null);
        Assert.assertEquals(-1, res);
        // have duplicated num
        res = DuplicationInArray.findDuplicatedNumNoExtraSpaceLoop(getDuplicatedNumArr());
        Assert.assertTrue(duplicatedNum.contains(res));
        // has no duplicated num
        res = DuplicationInArray.findDuplicatedNumNoExtraSpaceLoop(getNoDuplicatedNumArr());
        Assert.assertEquals(-1, res);
        // illegal
        res = DuplicationInArray.findDuplicatedNumNoExtraSpaceLoop(getIllegalNumArr());
        Assert.assertEquals(-1, res);
        // over bounded
        res = DuplicationInArray.findDuplicatedNumNoExtraSpaceLoop(getOverBoundNumArr());
        Assert.assertEquals(-1, res);
    }

    @Test
    public void testFindDuplicatedNumSpecial() {
        // 数组为null
        int res = DuplicationInArray.findDuplicatedNumSpecial(null);
        Assert.assertEquals(-1, res);
        // 找到重复元素-存在单个重复
        int[] numsA = {1, 1, 2, 3, 4, 5};
        res = DuplicationInArray.findDuplicatedNumSpecial(numsA);
        Assert.assertEquals(1, res);
        // 找到重复元素-存在多个重复
        int[] numsB = {1, 2, 3, 3, 5, 5, 6, 7};
        res = DuplicationInArray.findDuplicatedNumSpecial(numsB);
        Assert.assertEquals(5, res);
        // 数组元素值不在有效范围内
        int[] numsC = {1, 2, 3, 4, 5};
        res = DuplicationInArray.findDuplicatedNumSpecial(numsC);
        Assert.assertEquals(-1, res);


    }



    private int[] getDuplicatedNumArr() {
        return new int[]{1, 0, 6, 9, 2, 3, 1, 6, 7, 8};
    }

    private int[] getNoDuplicatedNumArr() {
        return new int[]{9, 1, 2, 4, 3, 5, 8, 7, 6, 0};
    }

    private int[] getIllegalNumArr() {
        return new int[]{0, 1, 3, 1, -1, -2, 5, 6, 9, 2};
    }

    private int[] getOverBoundNumArr() {
        return new int[]{9, 1, 2, 3, 3, 5, 2, 7, 6, 100};
    }


}