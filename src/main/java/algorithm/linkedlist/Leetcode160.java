package algorithm.linkedlist;

import pojo.ListNode;

/**
 * @program: algorithm
 * @description: 相交链表
 * @author: szm
 * @create: 2020-03-14 17:59
 **/
public class Leetcode160 {


    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;
        ListNode a = headA;
        ListNode b = headB;
        while (a != b) {
            a = a == null ? headB : a.next;
            b = b == null ? headA : b.next;
        }
        return a;
    }
}
