package com.hryg.algorithm.easy;

import java.util.*;

/**
 * 删除排序数组中的重复项
 *
 * @author hryg
 * Created on 2019-07-01
 */
public class RemoveDuplicatesFromSortedArray {

    /**
     * Given a sorted array nums, remove the duplicates in-place such that each element appear only once and return the new length.
     *
     * Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.
     *
     * Example 1:
     *
     * Given nums = [1,1,2],
     *
     * Your function should return length = 2, with the first two elements of nums being 1 and 2 respectively.
     *
     * It doesn't matter what you leave beyond the returned length.
     * Example 2:
     *
     * Given nums = [0,0,1,1,1,2,2,3,3,4],
     *
     * Your function should return length = 5, with the first five elements of nums being modified to 0, 1, 2, 3, and 4 respectively.
     *
     * It doesn't matter what values are set beyond the returned length.
     * Clarification:
     *
     * Confused why the returned value is an integer but your answer is an array?
     *
     * Note that the input array is passed in by reference, which means modification to the input array will be known to the caller as well.
     *
     * Internally you can think of this:
     *
     * // nums is passed in by reference. (i.e., without making a copy)
     * int len = removeDuplicates(nums);
     *
     * // any modification to nums in your function would be known by the caller.
     * // using the length returned by your function, it prints the first len elements.
     * for (int i = 0; i < len; i++) {
     *     print(nums[i]);
     * }
     */
    public static int removeDuplicates(int[] nums) {
        /// 最开始的原始解法
        /*
        if (nums == null) return 0;
        if (nums.length == 1) return 1;
        HashMap<Integer, Integer> bin = new LinkedHashMap<>(nums.length);
        int len = nums.length;
        int tmp;
        for (int i = 0; i < len;) {
            if (bin.containsKey(nums[i])) {
                tmp = nums[i];
                for (int j = i; j < len - 1; j++) {
                    nums[j] = nums[j + 1];
                }
                len -= 1;
                nums[len] = tmp;
            } else {
                bin.put(nums[i], i++);
            }
        }
        return bin.size();
        */

        /// 稍微好一丢丢
       /*
       if (nums == null) return 0;
        if (nums.length == 1) return 1;
        HashMap<Integer, Integer> bin = new LinkedHashMap<>(nums.length);
        for (int num : nums) {
            bin.put(num, num);
        }
        Iterator<Integer> iterator = bin.keySet().iterator();
        int index = 0;
        while (iterator.hasNext()) {
            nums[index++] = iterator.next();
        }
        return index;
        */

        Set<Integer> set = new LinkedHashSet<>(nums.length);
        for (int num : nums) {
            set.add(num);
        }
        int index = 0;
        for (Integer integer : set) {
            nums[index++] = integer;
        }
        return index;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{0,0,1,1,1,2,2,3,3,4};
        System.out.println(removeDuplicates(nums));
        for (int num : nums) {
            System.out.println(num);
        }
    }
}
