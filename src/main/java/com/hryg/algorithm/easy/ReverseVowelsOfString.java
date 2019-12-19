package com.hryg.algorithm.easy;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Objects;

/**
 * 反转字符串中的元音字母
 *
 * @author hryg
 * Created on 2019-11-05
 */
public class ReverseVowelsOfString {

    /**
     * Write a function that takes a string as input and reverse only the vowels of a string.
     *
     * Example 1:
     *
     * Input: "hello"
     * Output: "holle"
     * Example 2:
     *
     * Input: "leetcode"
     * Output: "leotcede"
     * Note:
     * The vowels does not include the letter "y".
     */
    public static String reverseVowels(String s) {
        HashSet<Character> vowels = new HashSet<>(
                Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U')
        );
        if (Objects.isNull(s)) return null;
        int i = 0, j = s.length() - 1;
        char[] result = new char[s.length()];
        while (i <= j) {
            char ci = s.charAt(i);
            char cj = s.charAt(j);
            if (!vowels.contains(ci)) {
                result[i++] = ci;
            } else if (!vowels.contains(cj)) {
                result[j--] = cj;
            } else {
                result[i++] = cj;
                result[j--] = ci;
            }
        }
        return new String(result);
    }

    public static void main(String[] args) {

    }

}
