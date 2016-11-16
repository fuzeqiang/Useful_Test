package oj.test.easy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Given a linked list, determine if it has a cycle in it.
 * <p/>
 * Follow up: Can you solve it without using extra space?
 * <p/>
 * Definition for singly-linked list:
 * <pre>
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 * </pre>
 */
public class LinkedListCycle {
    public boolean hasCycle(ListNode head) {
        Map<ListNode, Object> map = new HashMap<ListNode, Object>();
        while (null != head) {
            if (map.containsKey(head)) {
                return true;
            }
            map.put(head, null);
            head = head.next;
        }

        return false;
    }

    public boolean test(ListNode head) {
        if (null == head) {
            return false;
        }
        ListNode next = head.next;
        if (null == next) {
            return false;
        }
        ListNode next2 = next.next;
        while (null != head) {
            if (head == next2) {
                return true;
            }
            next2 = next2.next;
            head = next;
        }
        return false;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(0);
        ListNode node2 = new ListNode(3);
        ListNode node3 = new ListNode(2);
        ListNode node4 = new ListNode(-4);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        System.out.println(new LinkedListCycle().test(node1));
    }
}
