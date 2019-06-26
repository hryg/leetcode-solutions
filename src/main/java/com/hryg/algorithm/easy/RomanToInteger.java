package com.hryg.algorithm.easy;

import java.util.HashMap;

/**
 * 罗马数字转整数
 *
 * @author hryg
 * Created on 2019-06-26
 */
public class RomanToInteger {
    private static HashMap<String, Integer> refMap;

    static {
        refMap = new HashMap<>(11);
        refMap.put("I", 1);
        refMap.put("IV", 4);
        refMap.put("V", 5);
        refMap.put("IX", 9);
        refMap.put("X", 10);
        refMap.put("XL", 40);
        refMap.put("L", 50);
        refMap.put("XC", 90);
        refMap.put("C", 100);
        refMap.put("CD", 400);
        refMap.put("D", 500);
        refMap.put("CM", 900);
        refMap.put("M", 1000);
    }

    /**
     * Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.
     * <p>
     * Symbol       Value
     * I             1
     * V             5
     * X             10
     * L             50
     * C             100
     * D             500
     * M             1000
     * For example, two is written as II in Roman numeral, just two one's added together. Twelve is written as, XII, which is simply X + II. The number twenty seven is written as XXVII, which is XX + V + II.
     * <p>
     * Roman numerals are usually written largest to smallest from left to right. However, the numeral for four is not IIII. Instead, the number four is written as IV. Because the one is before the five we subtract it making four. The same principle applies to the number nine, which is written as IX. There are six instances where subtraction is used:
     * <p>
     * I can be placed before V (5) and X (10) to make 4 and 9.
     * X can be placed before L (50) and C (100) to make 40 and 90.
     * C can be placed before D (500) and M (1000) to make 400 and 900.
     * Given a roman numeral, convert it to an integer. Input is guaranteed to be within the range from 1 to 3999.
     * <p>
     * Example 1:
     * <p>
     * Input: "III"
     * Output: 3
     * Example 2:
     * <p>
     * Input: "IV"
     * Output: 4
     * Example 3:
     * <p>
     * Input: "IX"
     * Output: 9
     * Example 4:
     * <p>
     * Input: "LVIII"
     * Output: 58
     * Explanation: L = 50, V= 5, III = 3.
     * Example 5:
     * <p>
     * Input: "MCMXCIV"
     * Output: 1994
     * Explanation: M = 1000, CM = 900, XC = 90 and IV = 4.
     */
    public static int romanToInt(String s) {
        /// 这个解法比较慢，因为审题没有注意到 "Input is guaranteed to be within the range from 1 to 3999" 这个条件，以至于多了 n - 6 次判断...
        /*
        if (s == null || "".equals(s.trim())) {
            return 0;
        }
        int num = 0;
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length;) {
            if (i < chars.length - 1 && refMap.containsKey(String.valueOf(chars[i]) + chars[i + 1])) {
                num += refMap.get(String.valueOf(chars[i]) + chars[i + 1]);
                i += 2;
            } else {
                num += refMap.get(String.valueOf(chars[i]));
                i++;
            }
        }
        return num;
        */
        /// 更优秀的解法
        int sum=0;
        if(s.contains("IV")) sum-=2;
        if(s.contains("IX")) sum-=2;
        if(s.contains("XL")) sum-=20;
        if(s.contains("XC")) sum-=20;
        if(s.contains("CD")) sum-=200;
        if(s.contains("CM")) sum-=200;

        char c[]=s.toCharArray();
        for(int i=0;i<s.length();i++){
            if(c[i]=='M') sum+=1000;
            if(c[i]=='D') sum+=500;
            if(c[i]=='C') sum+=100;
            if(c[i]=='L') sum+=50;
            if(c[i]=='X') sum+=10;
            if(c[i]=='V') sum+=5;
            if(c[i]=='I') sum+=1;

        }
        return sum;
    }

    public static void main(String[] args) {
        String romanStr = "MCMXCIV";
        System.out.println(romanToInt(romanStr));
    }
}
