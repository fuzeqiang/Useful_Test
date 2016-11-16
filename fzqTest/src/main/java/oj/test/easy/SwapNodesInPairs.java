package oj.test.easy;

import java.util.List;

/**
 * Given a linked list, swap every two adjacent nodes and return its head.
 * <p/>
 * For example, Given 1->2->3->4, you should return the list as 2->1->4->3.
 * <p/>
 * Your algorithm should use only constant space. You may not modify the values in the list, only nodes itself can be changed.
 * <p/>
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class SwapNodesInPairs {

    public ListNode swapPairs(ListNode head) {
        if (null == head || null == head.next) {
            return head;
        }
        ListNode next = head.next;
        ListNode re = head.next;
        ListNode prev = null;

        while (null != head && null != next) {
            ListNode tempNext2 = next.next;
            next.next = head;
            head.next = tempNext2;
            if (null != prev) {
                prev.next = next;
            }

            prev = head;
            head = head.next;
            if (null != head) {
                next = head.next;
            }
        }

        return re;
    }

    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;

        ListNode head = new SwapNodesInPairs().swapPairs(n1);
        while (null != head) {
            System.out.print(head.val + ",");
            head = head.next;
        }
    }

}
