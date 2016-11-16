package oj.test.easy;

import java.util.List;

/**
 * Merge two sorted linked lists and return it as a new list. The new list should be made by splicing together the nodes of the first two lists.
 * <p/>
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class MergeTwoSortedLists {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (null == l1) {
            return l2;
        }
        if (null == l2) {
            return l1;
        }
        ListNode head = l1.val > l2.val ? l2 : l1;
        ListNode prev1 = null;
        while (null != l1) {
            while (null != l2 && l2.val < l1.val) {
                ListNode temp = l2.next;
                l2.next = l1;
                if (null != prev1) {
                    prev1.next = l2;
                }
                prev1 = l2;
                l2 = temp;
            }
            prev1 = l1;
            l1 = l1.next;
        }

        while (null != l2) {
            prev1.next = l2;
            prev1 = l2;
            l2 = l2.next;
        }

        return head;
    }

    //优化算法，在需要插入的链表是连续的时候性能较高
    public ListNode test(ListNode l1, ListNode l2) {
        if (null == l1) {
            return l2;
        }
        if (null == l2) {
            return l1;
        }

        ListNode head = l1.val > l2.val ? l2 : l1;
        ListNode prev = null;
        while (null != l1) {
            ListNode start = null;
            ListNode end = null;
            int count = 0;
            while (null != l2 && l1.val > l2.val) {
                if (0 == count) {
                    start = l2;
                } else {
                    end = l2;
                }
                l2 = l2.next;
                count++;
            }
            if (null != start) {
                if (1 == count) {
                    end = start;
                }
                if (null != prev) {
                    prev.next = start;
                }
                end.next = l1;
            }
            prev = l1;
            l1 = l1.next;
        }

        while (null != l2) {
            prev.next = l2;
            prev = l2;
            l2 = l2.next;
        }

        return head;
    }

    public static void main(String[] args) {
        ListNode n0 = new ListNode(0);
        ListNode n01 = new ListNode(0);
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);
        ListNode n6 = new ListNode(6);
        ListNode n61 = new ListNode(6);
        ListNode n7 = new ListNode(7);
        ListNode n8 = new ListNode(8);
        ListNode n9 = new ListNode(9);

        n2.next = n3;
        n3.next = n6;
        n6.next = n8;

        n0.next = n01;
        n01.next = n1;
        n1.next = n4;
        n4.next = n5;
        n5.next = n61;
        n61.next = n7;
        n7.next = n9;

        MergeTwoSortedLists test = new MergeTwoSortedLists();
        test.test(n2, n0);
        while (null != n0) {
            System.out.print(n0.val + ",");
            n0 = n0.next;
        }
    }
}
