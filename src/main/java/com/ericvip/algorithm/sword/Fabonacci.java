package com.ericvip.algorithm.sword;

/**
 * @author Eric
 * @date 2021-05-06
 **/
public class Fabonacci {

    public static int fibNByRecursive(int n) {
        if (n < 0) {
            throw new NumberFormatException("n必须大于0");
        }
        if (n <= 1) {
            return n;
        }
        return fibNByRecursive(n - 1) + fibNByRecursive(n - 2);
    }

    public static int fibNByLoop(int n) {
        if (n < 0) {
            throw new NumberFormatException("n必须大于0");
        }
        if (n < 2) {
            return n;
        }
        int minusTwo = 0;
        int minusOne = 1;
        int fibN = 0;
        for (int i = 2; i <= n; i++) {
            fibN = (minusTwo + minusOne) % 1000000007;
            minusTwo = minusOne;
            minusOne = fibN;
        }
        return fibN;
    }

    private Fabonacci() {
    }
}
