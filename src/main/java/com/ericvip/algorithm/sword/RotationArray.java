package com.ericvip.algorithm.sword;

/**
 * @author Eric
 * @date 2021-05-06
 **/
public class RotationArray {

    public int minArrValue(int[] numbers) {
        int indexPre = 0;
        int indexPost = numbers.length - 1;
        int indexMid = indexPre;
        while (numbers[indexPre] >= numbers[indexPost]) {
            // 结束条件，indexPre与indexPost相邻
            if (indexPost - indexPre == 1) {
                indexMid = indexPost;
                break;
            }
            indexMid = indexPre + (indexPost - indexPre) / 2;
            if (numbers[indexPre] == numbers[indexPost] && numbers[indexPre] == numbers[indexMid]) {
                return minValueByOrder(numbers, indexPre, indexPost);
            }
            if (numbers[indexPre] <= numbers[indexMid]) {
                indexPre = indexMid;
            } else if (numbers[indexPost] >= numbers[indexMid]) {
                indexPost =  indexMid;
            }

        }


        return numbers[indexMid];
    }

    private int minValueByOrder(int[] arr, int indexPre, int indexPost) {
        int res = arr[indexPre];
        for (int i = indexPre + 1; i <= indexPost; i++) {
            if (arr[i] < res) {
                res = arr[i];
            }
        }
        return res;
    }
}
