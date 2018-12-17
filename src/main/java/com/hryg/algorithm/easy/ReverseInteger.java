package com.hryg.algorithm.easy;

/**
 * 整数反转
 *
 * @author hryg
 * Created on 2018-12-17
 */
public class ReverseInteger {

    /**
     * Given a 32-bit signed integer, reverse digits of an integer.
     *
     * Example 1:
     *
     * Input: 123
     * Output: 321
     * Example 2:
     *
     * Input: -123
     * Output: -321
     * Example 3:
     *
     * Input: 120
     * Output: 21
     * Note:
     * Assume we are dealing with an environment which could only store integers within the 32-bit signed integer range: [−231,  231 − 1].
     * For the purpose of this problem, assume that your function returns 0 when the reversed integer overflows.
     */
    private static int reverse(int x) {
        String s = String.valueOf(x);
        StringBuilder res = new StringBuilder();
        boolean minus = false;
        if ('-' == s.charAt(0)) {
            minus = true;
            s = s.substring(1);
        }
        for (int i = s.length() - 1; i >= 0; i--) {
            res.append(s.charAt(i));
        }
        try {
            return minus ? Integer.valueOf("-" + res.toString()) : Integer.valueOf(res.toString());
        } catch (NumberFormatException e) {
            return 0;
        }
    }

    public static void main(String[] args) {
        System.out.println(reverse(1534236469));
    }

}
