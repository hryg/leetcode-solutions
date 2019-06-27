package com.hryg.algorithm.easy;

import java.util.Stack;

/**
 * 有效括号
 *
 * @author hryg
 * Created on 2019-06-27
 */
public class ValidParentheses {

    /**
     * Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
     *
     * An input string is valid if:
     *
     * Open brackets must be closed by the same type of brackets.
     * Open brackets must be closed in the correct order.
     * Note that an empty string is also considered valid.
     *
     * Example 1:
     *
     * Input: "()"
     * Output: true
     * Example 2:
     *
     * Input: "()[]{}"
     * Output: true
     * Example 3:
     *
     * Input: "(]"
     * Output: false
     * Example 4:
     *
     * Input: "([)]"
     * Output: false
     * Example 5:
     *
     * Input: "{[]}"
     * Output: true
     */
    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        char[] cs = s.toCharArray();
        char top;
        char pending;
        for (int i = 0; i < cs.length; i++) {
            pending = cs[i];
            if (stack.empty()) {
                stack.push(pending);
                continue;
            }
            top = stack.peek();
            if (top == '(' && pending == ')' || top == '{' && pending == '}' || top == '[' && pending == ']') {
                stack.pop();
            } else {
                stack.push(pending);
            }
        }
        return stack.empty();

        /// 奇技淫巧的解法
        /*
        Stack<Character> stack = new Stack<Character>();
        for (char c : s.toCharArray()) {
            if (c == '(')
                stack.push(')');
            else if (c == '{')
                stack.push('}');
            else if (c == '[')
                stack.push(']');
            else if (stack.isEmpty() || stack.pop() != c)
                return false;
        }
        return stack.isEmpty();
        */
    }

    public static void main(String[] args) {
        String s = "{[]}";
        System.out.println(isValid(s));
    }
}
