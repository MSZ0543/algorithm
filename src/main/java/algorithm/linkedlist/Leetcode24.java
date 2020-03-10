package algorithm.linkedlist;

import pojo.ListNode;

/**
 * @program: algorithm
 * @description: 两两交换链表中的节点
 * @author: szm
 * @create: 2020-03-09 16:01
 **/
public class Leetcode24 {

    public ListNode swapPairs(ListNode head) {

        if (head == null || (head != null && head.next == null)) {
            return head;
        }
        ListNode pre = new ListNode(0);
        ListNode headr = null;
        pre.next = head;
        while (pre.next != null && pre.next.next != null) {
            ListNode a = pre.next;
            ListNode b = pre.next.next;
            a.next = b.next;
            b.next = a;
            pre.next = b;
            if (headr == null) {
                headr = b;
            }
            pre = a;
        }
        return headr;
    }
}
