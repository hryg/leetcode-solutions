package com.hryg.algorithm.easy;

/**
 * 平方数之和
 *
 * @author hryg
 * Created on 2019-11-04
 */
public class SumOfSquareNumbers {

    /**
     * Given a non-negative integer c, your task is to decide whether there're two integers a and b such that a2 + b2 = c.
     *
     * Example 1:
     *
     * Input: 5
     * Output: True
     * Explanation: 1 * 1 + 2 * 2 = 5
     *
     *
     * Example 2:
     *
     * Input: 3
     * Output: False
     */
    public static boolean judgeSquareSum(int c) {
        if (c < 0) return false;
        int i = 0, j = (int) Math.sqrt(c);
        while (i <= j) {
            int powSum = i * i + j * j;
            if (powSum == c) {
                return true;
            } else if (powSum > c) {
                j--;
            } else {
                i++;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(judgeSquareSum(5));
    }

}
