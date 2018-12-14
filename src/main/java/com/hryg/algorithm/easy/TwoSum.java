package com.hryg.algorithm.easy;

import java.util.*;

/**
 * 两数之和
 *
 * @author hryg
 * Created on 2018-12-13
 */
public class TwoSum {

    /**
     * Given an array of integers, return indices of the two numbers such that they add up to a specific target.
     * You may assume that each input would have exactly one solution, and you may not use the same element twice.
     *
     * Example:
     *
     * Given nums = [2, 7, 11, 15], target = 9,
     *
     * Because nums[0] + nums[1] = 2 + 7 = 9,
     * return [0, 1].
     */
    private static int[] twoSum(int[] nums, int target) {
        // 暴力方式，时间复杂度 O(n2)
        /*if (nums == null || nums.length <= 0) {
            return new int[0];
        }
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[] {i, j};
                }
            }
        }*/

        // 时间复杂度最低 O(n)
        int[] result = new int[2];
        Map<Integer, Integer> map = new HashMap<>(nums.length);
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                result[1] = i;
                result[0] = map.get(target - nums[i]);
                return result;
            }
            map.put(nums[i], i);
        }

        throw new IllegalArgumentException("No two sum solution");
    }

    public static void main(String[] args) {
        int[] test = twoSum(new int[]{3, 2, 4}, 6);
        System.out.println(Arrays.toString(test));
    }

}
