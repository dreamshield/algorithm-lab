package com.ericvip.algorithm.sword;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class NumberOfOneTest {

    @Test
    public void testSolutionByFlagMove() {
        int res = NumberOfOne.solutionByFlagMove(9);
        Assert.assertEquals(2, res);
        res = NumberOfOne.solutionByFlagMove(7);
        Assert.assertEquals(3, res);
        res = NumberOfOne.solutionByFlagMove(-5);
        Assert.assertEquals(31, res);
        res = NumberOfOne.solutionByFlagMove(Integer.MAX_VALUE);
        Assert.assertEquals(31, res);
        res = NumberOfOne.solutionByFlagMove(Integer.MIN_VALUE);
        Assert.assertEquals(1, res);
    }

    @Test
    public void testSolutionByMinusOne() {
        int res = NumberOfOne.solutionByMinusOne(9);
        Assert.assertEquals(2, res);
        res = NumberOfOne.solutionByMinusOne(7);
        Assert.assertEquals(3, res);
        res = NumberOfOne.solutionByMinusOne(-5);
        Assert.assertEquals(31, res);
        res = NumberOfOne.solutionByMinusOne(Integer.MAX_VALUE);
        Assert.assertEquals(31, res);
        res = NumberOfOne.solutionByMinusOne(Integer.MIN_VALUE);
        Assert.assertEquals(1, res);
    }
}