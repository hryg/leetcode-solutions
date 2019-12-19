package com.hryg.algorithm.easy;

/**
 * 实现strStr()
 *
 * @author hryg
 * Created on 2019-07-04
 */
public class ImplementStrStr {

    /**
     * Implement strStr().
     * <p>
     * Return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.
     * <p>
     * Example 1:
     * <p>
     * Input: haystack = "hello", needle = "ll"
     * Output: 2
     * Example 2:
     * <p>
     * Input: haystack = "aaaaa", needle = "bba"
     * Output: -1
     * Clarification:
     * <p>
     * What should we return when needle is an empty string? This is a great question to ask during an interview.
     * <p>
     * For the purpose of this problem, we will return 0 when needle is an empty string. This is consistent to C's strstr() and Java's indexOf().
     */
    public static int strStr(String haystack, String needle) {
        if (haystack == null || needle == null) return -1;
        if ("".equals(needle) || haystack.equals(needle)) return 0;
        char[] haystackChars = haystack.toCharArray();
        char[] needleChars = needle.toCharArray();
        int result = -1;
        for (int i = 0, j = 0; i < haystackChars.length - needleChars.length; i++) {
            if (haystackChars[i] == needleChars[j]) {
                result = result == -1 ? i : result;
                if (++j == needleChars.length) return result;
            } else {
                j = 0;
                result = -1;
            }
        }
        return result;
    }

    public static void main(String[] args) {

    }
}
