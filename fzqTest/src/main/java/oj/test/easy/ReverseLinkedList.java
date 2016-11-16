package oj.test.easy;

import java.util.List;

/**
 * Reverse a singly linked list.<br/>
 * Definition for singly-linked list.<br/>
 * public class ListNode {<br/>
 *      int val;<br/>
 *      ListNode next;<br/>
 *      ListNode(int x) {
 *          val = x;
 *      }<br/>
 * }
 */
public class ReverseLinkedList {
    public ListNode reverseList(ListNode head) {
        if (null == head) {
            return head;
        }

        return reverseList(null, head);
    }

    private ListNode reverseList(ListNode last, ListNode node) {
        ListNode next = node.next;
        node.next = last;

        if (null == next) {
            return node;
        }
        return reverseList(node, next);
    }

    public ListNode test(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (null != curr) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;
    }

    public ListNode test2(ListNode head) {
        if (null == head || null == head.next) {
            return head;
        }
        ListNode p = test2(head.next);
        p.next = head;
        head.next = null;

        return p;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        node1.next = node2;
        node2.next = node3;

        ListNode re = new ReverseLinkedList().test2(node1);
        while (null != re) {
            System.out.println(re.val);
            re = re.next;
        }
    }
}
