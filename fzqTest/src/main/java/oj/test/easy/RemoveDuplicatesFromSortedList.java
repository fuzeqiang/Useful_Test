package oj.test.easy;


/**
 * Given a sorted linked list, delete all duplicates such that each element appear only once.
 * <p/>
 * For example,<br/>
 * Given 1->1->2, return 1->2.<br/>
 * Given 1->1->2->3->3, return 1->2->3.
 */
public class RemoveDuplicatesFromSortedList {
    public static ListNode deleteDuplicates(ListNode head) {
        if (null == head) {
            return head;
        }

        int prevVal = head.val;
        ListNode prevNode = head;
        ListNode currNode = head.next;
        while (null != currNode) {
            ListNode next = currNode.next;
            if (prevVal == currNode.val) {//delete currNode
                prevNode.next = next;
                currNode.next = null;
            } else {
                prevVal = currNode.val;
                prevNode = currNode;
            }
            currNode = next;
        }

        return head;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(1);
        ListNode node3 = new ListNode(1);
        node1.next = node2;
        node2.next = node3;
        System.out.println(deleteDuplicates(node1).next);
    }
}
