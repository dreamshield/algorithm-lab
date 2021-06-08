package com.ericvip.algorithm.test;

/**
 * @author EricZhang
 * @date 2019/10/25
 * @time 7:34 AM
 */
public class BaseTest {


    public static void quickSortV1(int[] arr, int low, int high) {
        if (low >= high) {
            return;
        }
        int pivotLoc = partitionV1(arr, low, high);
        quickSortV1(arr, low, pivotLoc - 1);
        quickSortV1(arr, pivotLoc + 1, high);
    }

    private static int partitionV1(int[] arr, int low, int high) {
        // 将arr[low]作为枢轴
        int pivot = arr[low];
        int i = low;
        int j = high;
        // 从数组的两端向中间扫描
        while (i < j) {
            while (j > low && arr[j] >= pivot) {
                j--;
            }
            while (i < high && arr[i] <= pivot) {
                i++;
            }
            swap(arr, i, j);
        }
        swap(arr, low, j);
        return j;
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void quickSortV2(int[] arr, int low, int high) {
        if (low >= high) {
            return;
        }
        int pivotLoc = partitionV2(arr, low, high);
        quickSortV2(arr, low, pivotLoc - 1);
        quickSortV2(arr, pivotLoc + 1, high);
    }

    private static int partitionV2(int[] arr, int low, int high) {
        int pivot;
        pivot = arr[low];
        while (low < high) {
            while (low < high && arr[high] >= pivot) {
                high--;
            }
            swap(arr, low, high);
            while (low < high && arr[low] <= pivot) {
                low++;
            }
            swap(arr, low, high);
        }
        return low;
    }
}
