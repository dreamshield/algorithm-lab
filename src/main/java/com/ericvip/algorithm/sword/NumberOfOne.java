package com.ericvip.algorithm.sword;

/**
 * @author Eric
 * @date 2021-05-06
 **/
public class NumberOfOne {

    public static int solutionByFlagMove(int n) {
        int count = 0;
        int flag = 1;
        int shiftTimes = 0;
        while (flag != 0) {
            if ((((n & flag) >> shiftTimes) & 1) == 1) {
                count++;
            }
            shiftTimes++;
            flag <<= 1;
        }
        return count;
    }

    public static int solutionByMinusOne(int n) {
        int count = 0;
        while (n != 0) {
            count++;
            n &= (n - 1);
        }
        return count;
    }
}
