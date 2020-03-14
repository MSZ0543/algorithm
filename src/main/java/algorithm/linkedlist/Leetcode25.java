package algorithm.linkedlist;

import pojo.ListNode;

/**
 * @program: algorithm
 * @description: K 个一组翻转链表
 * @author: szm
 * @create: 2020-03-14 23:42
 **/
public class Leetcode25 {


    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode pre = dummy;
        ListNode end = dummy;

        while (end.next != null) {
            for (int i = 0; i < k && end != null; i++) {
                end = end.next;
            }
            if (end == null) break;
            ListNode start = pre.next;
            ListNode next = end.next;
            end.next = null;
            pre.next = reverse(start);
            start.next = next;
            pre = start;

            end = pre;
        }
        return dummy.next;
    }

    private ListNode reverse(ListNode start) {
        ListNode pre = null;
        ListNode p = start;
        while (p != null) {
            ListNode last = p.next;
            p.next = pre;
            pre = p;
            p = last;
        }
        return pre;
    }
}
