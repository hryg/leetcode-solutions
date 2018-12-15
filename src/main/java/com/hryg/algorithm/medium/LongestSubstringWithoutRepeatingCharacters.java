package com.hryg.algorithm.medium;

/**
 * 无重复字符的最长子串
 *
 * @author hryg
 * Created on 2018-12-15
 */
public class LongestSubstringWithoutRepeatingCharacters {

    /**
     * Given a string, find the length of the longest substring without repeating characters.
     *
     * Example 1:
     *
     * Input: "abcabcbb"
     * Output: 3
     * Explanation: The answer is "abc", with the length of 3.
     * Example 2:
     *
     * Input: "bbbbb"
     * Output: 1
     * Explanation: The answer is "b", with the length of 1.
     * Example 3:
     *
     * Input: "pwwkew"
     * Output: 3
     * Explanation: The answer is "wke", with the length of 3.
     * Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
     */
    private static int lengthOfLongestSubstring(String s) {
        int maxLength = 0;
        StringBuilder buffer = new StringBuilder();
        String val;
        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j < s.length(); j++) {
                val = String.valueOf(s.charAt(j));
                if (!buffer.toString().contains(val)) {
                    buffer.append(val);
                } else {
                    break;
                }
            }
            if (maxLength < buffer.length()) {
                maxLength = buffer.length();
            }
            buffer.setLength(0);
            if (s.length() - i - 1 <= maxLength) {
                break;
            }
        }
        return maxLength;
    }

    public static void main(String[] args) {
        String testStr = "aab";
        System.out.println(lengthOfLongestSubstring(testStr));
    }

}
