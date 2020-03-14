package algorithm.linkedlist;

import pojo.ListNode;

/**
 * @program: algorithm
 * @description: 删除链表的倒数第N个节点
 * @author: szm
 * @create: 2020-03-14 22:39
 **/
public class Leetcode19 {


    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null || (head.next == null && n > 0)) {
            return null;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        helper(dummy, head, n);
        return dummy.next;
    }

    private int helper(ListNode pre, ListNode node, int n) {
        if (node == null) return n - 1;
        int index = helper(node, node.next, n);
        if (index == 0) {
            pre.next = node.next;
            node.next = null;
        }
        return index - 1;
    }
}
