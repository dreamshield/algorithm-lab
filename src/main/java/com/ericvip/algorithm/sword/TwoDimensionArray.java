package com.ericvip.algorithm.sword;

/**
 * 面试题4：二维数组中查找
 * 详述：在一个二维数组中，每一行都按照从左到右递增的顺序排列，
 * 每一列都按着从上到下递增的顺序排列。
 * 请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否包含该整数。
 *
 * @author EricZhang
 * @date 2020/8/29
 * @time 8:19 AM
 */
public class TwoDimensionArray {

    /**
     * 二维数组中查找指定数值
     * <p>
     * 算法思路：
     * - 选取数组右上角的数值
     * - 如果等于要查找的数，则直接返回；
     * - 如果小于要查找的数，排除当前值所在的行；
     * - 如果大于要查找的数，排除当前值所在的列。
     * 重复以上步骤，直到找到对应数值。
     *
     * @param arr    二维数组
     * @param target 指定的数值
     * @return bool 找到: true；未找到或异常：false
     */
    public static boolean findTargetNum(int[][] arr, int target) {
        if (arr == null || arr.length == 0) {
            return false;
        }

        int curRow = 0;
        if (arr[curRow] == null) {
            return false;
        }
        int curColumn = arr[0].length - 1;
        int maxRow = arr.length - 1;

        while (curRow <= maxRow && curColumn >= 0) {
            if (arr[curRow] == null) {
                return false;
            }
            if (arr[curRow][curColumn] == target) {
                return true;
            }
            if (arr[curRow][curColumn] < target) {
                curRow++;
            } else {
                curColumn--;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] t = {null};

        System.out.println("t=" + t.length);
    }
}
