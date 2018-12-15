package com.hryg.algorithm.medium;

/**
 * 两数之和
 *
 * @author hryg
 * Created on 2018-12-14
 */
public class AddTwoNumbers {

    /**
     * Definition for singly-linked list.
     */
    private static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    /**
     * You are given two non-empty linked lists representing two non-negative integers.
     * The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.
     *
     * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
     *
     * Example:
     *
     * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
     * Output: 7 -> 0 -> 8
     * Explanation: 342 + 465 = 807.
     */
    private static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // 更优秀的写法
        ListNode head = new ListNode(0);
        ListNode result = head;
        int sum = 0;
        while (l1 != null || l2 != null) {
            sum /= 10;
            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }
            result.next = new ListNode(sum % 10);
            result = result.next;
        }
        if (sum / 10 != 0) {
            result.next = new ListNode(1);
        }
        return head.next;

        // 自己写的，时间复杂度为 O(n)，判断太多了，只击败了百分之十的人
        /*ListNode result = null;
        ListNode head = null;
        while (l1 != null && l2 != null) {
            int sum = l1.val + l2.val;

            if (result == null) {
                result = new ListNode(sum % 10);
            } else {
                sum += result.val;
                result.val = sum % 10;
            }

            if (head == null) {
                head = result;
            }

            if (sum >= 10) {
                result.next = new ListNode(1);
            }
            if (l1.next != null || l2.next != null) {
                if (result.next == null) {
                    result.next = new ListNode(0);
                }
                if (l1.next == null) {
                    l1.next = new ListNode(0);
                }
                if (l2.next == null){
                    l2.next = new ListNode(0);
                }
            }

            l1 = l1.next;
            l2 = l2.next;
            result = result.next;
        }
        return head;*/
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(9);
        l1.next = new ListNode(9);

        ListNode l2 = new ListNode(1);

        ListNode result = addTwoNumbers(l1, l2);
        do {
            System.out.println(result.val);
            result = result.next;
        } while (result != null);
    }
}
