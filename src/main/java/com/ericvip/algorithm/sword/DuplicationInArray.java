package com.ericvip.algorithm.sword;

import com.ericvip.algorithm.utils.ArrUtils;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 面试题3:数组中重复的数字
 * 详述：在一个长度为 n 的数组 nums 里的所有数字都在 0～n-1 的范围内。
 * 数组中某些数字是重复的，但不知道有几个数字重复了，也不知道每个数字重复了几次。
 * 请找出数组中任意一个重复的数字。如果没有找到或异常返回-1
 * <p>
 * --------示例--------
 * 输入：[2, 3, 1, 0, 2, 5, 3]
 * 输出：2或3；如果不存在重复的数字输出-1
 *
 * @author EricZhang
 * @date 2020/8/25
 * @time 8:27 AM
 */
public class DuplicationInArray {

    private DuplicationInArray() {
    }

    /**
     * 算法思路：
     * step1: 对输入的数组进行排序；
     * step2: 遍历排序后的数组，每次循环比较相邻的两个元素
     * - 如果相等则找到重复元素，并返回对应元素
     * - 如果遍历完后，没有相邻相等的元素，则没有重复的，并返回-1
     * <p>
     * 时间复杂度：O(nlogn)
     * 空间复杂度：O(1)
     * <p>
     * 注：该算法适用于数组元素大于0的任何数组，对元素大小的要求只要大于0就满足
     *
     * @param nums 待查找的数组
     * @return 查找结果
     */
    public static int findDuplicatedNumSimpleLoop(int[] nums) {
        if (nums == null) {
            return -1;
        }
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] < 0) {
                return -1;
            }
            if (nums[i] == nums[i + 1]) {
                return nums[i];
            }
        }
        return -1;
    }

    /**
     * 算法思路：
     * 新建同数组大小相同的Hash表，依次遍历数组中每一个元素，
     * 如果Hash表中已经存在该元素，则表示存在重复的元素并返回；
     * 如果不存在该元素，则将该元素添加到Hash表中。
     * <p>
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)
     *
     * @param nums 待查找数组
     * @return 查找结果
     */
    public static int findDuplicatedNumHashSet(int[] nums) {
        if (nums == null) {
            return -1;
        }
        Set<Integer> backSet = new HashSet<>(nums.length);
        for (int num : nums) {
            if (backSet.contains(num)) {
                return num;
            } else {
                backSet.add(num);
            }
        }
        return -1;
    }

    /**
     * 算法思路：
     * 从头到尾依次扫描数组中的每一个数字。
     * - 如果下标i同当前对应的元素值相等，则继续遍历；
     * - 如果下标i同当前对应的元素值(记为m)不相等，则比较m与a[m]；
     * - 如果二者相等，则存在重复数字并返回
     * - 如果二者不相等，则交换a[i]与a[m]
     * - 重复以上步骤
     * <p>
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     * <p>
     * 注：该算法的前提是，数组中的元素值必须在0~n-1范围内
     *
     * @param nums 待查找数据
     * @return 查找结果
     */
    public static int findDuplicatedNumNoExtraSpaceLoop(int[] nums) {
        if (nums == null) {
            return -1;
        }
        for (int num : nums) {
            if (num < 0 || num > nums.length - 1) {
                return -1;
            }
        }
        for (int i = 0; i < nums.length; i++) {
            while (nums[i] != i) {
                if (nums[i] == nums[nums[i]]) {
                    return nums[i];
                }
                ArrUtils.swap(nums, i, nums[i]);
            }
        }
        return -1;
    }

    /**
     * 重复数字算法变种：在一个长度为n+1的数组里的所有数字都在1~n的范围内，找出数组中任意一个重复的数字。
     * 由于最大数字小于数组个数，所以必定存在重复元素。
     * <p>
     * 算法思路：
     * 把从1~n的数字从中间数字m分为两部分，前面一半为1~m，后面一半为m+1~n。如果1~m的数字的数目超过m个(m - 1 + 1)，即mid-start+1，
     * 那么这一半区间一定包含重复数字；否则，另一半m+1~n一定包含重复数字。我们可以继续一分为二直到找到重复的数字为止。
     * <p>
     * 注：该算法不能找到所有的重复数字，但一定能够找一个。
     * <p>
     * 时间复杂度：O(nlogn)
     * 空间复杂度：O(1)
     *
     * @param nums 待查找数组
     * @return 查找结果，返回-1表示未找到或异常
     */
    public static int findDuplicatedNumSpecial(int[] nums) {
        if (nums == null) {
            return -1;
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < 1 || nums[i] >= nums.length) {
                return -1;
            }
        }
        int start = 1;
        int end = nums.length - 1;
        while (end >= start) {
            int mid = ((end - start) >> 1) + start;
            /* 计算指定区间内元素个数 */
            int count = countItem(nums, start, mid);
            if (end == start) {
                if (count > 1) {
                    return start;
                } else {
                    break;
                }
            }

            if (count > (mid - start) + 1) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }
        return -1;
    }

    /**
     * 计算指定范围内数组元素的个数
     *
     * @param nums  数组
     * @param start 范围下限
     * @param end   范围上限
     * @return 元素个数
     */
    private static int countItem(int[] nums, int start, int end) {
        int count = 0;
        if (nums == null) {
            return count;
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= start && nums[i] <= end) {
                count++;
            }
        }
        return count;
    }
}
