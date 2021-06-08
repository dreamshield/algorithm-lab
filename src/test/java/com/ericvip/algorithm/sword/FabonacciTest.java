package com.ericvip.algorithm.sword;

import org.junit.Assert;
import org.junit.Test;

public class FabonacciTest {

    @Test
    public void testPreNByRecursive() {
        int res = Fabonacci.fibNByRecursive(0);
        Assert.assertEquals(0, res);
        res = Fabonacci.fibNByRecursive(1);
        Assert.assertEquals(1, res);
        res = Fabonacci.fibNByRecursive(7);
        Assert.assertEquals(13, res);
//        res = Fabonacci.fibNByRecursive(100);
//        System.out.println("res=" + res);
    }

    @Test
    public void testPreNByLoop() {
        int res = Fabonacci.fibNByLoop(0);
        Assert.assertEquals(0, res);
        res = Fabonacci.fibNByLoop(1);
        Assert.assertEquals(1, res);
        res = Fabonacci.fibNByLoop(7);
        Assert.assertEquals(13, res);
        res = Fabonacci.fibNByLoop(100);
        System.out.println("res=" + res);
    }
}