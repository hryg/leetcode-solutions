package com.hryg.algorithm.easy;

/**
 * 合并两个有序链表
 *
 * @author: hrygddv
 * Created on 2019/6/29
 */
public class MergeTwoSortedLists {
    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode(int x) { val = x; }
     * }
     */
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    /**
     * Merge two sorted linked lists and return it as a new list. The new list should be made by splicing together the nodes of the first two lists.
     *
     * Example:
     *
     * Input: 1->2->4, 1->3->4
     * Output: 1->1->2->3->4->4
     */
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        ListNode result = new ListNode(0);
        ListNode iterator = result;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                iterator.next = new ListNode(l1.val);
                l1 = l1.next;
            } else {
                iterator.next = new ListNode(l2.val);
                l2 = l2.next;
            }
            iterator = iterator.next;
        }
        iterator.next = l1 == null ? l2 : l1;
        return result.next;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(4);

        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(3);
        l2.next.next = new ListNode(4);

        ListNode result = mergeTwoLists(l1, l2);
        while (result != null) {
            System.out.println(result.val);
            result = result.next;
        }
    }

}
