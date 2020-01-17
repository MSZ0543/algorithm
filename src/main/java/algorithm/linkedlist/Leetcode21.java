package algorithm.linkedlist;

import pojo.ListNode;

/**
 * @program: algorithm
 * @description: 合并两个有序链表
 * @author: szm
 * @create: 2020-01-17 18:14
 **/
public class Leetcode21 {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        // 通过
        ListNode res = new ListNode(-1);
        ListNode resLast = res;
        while(l1 != null || l2 != null) {
            // 条件包含l2不为null条件
            if(l1 != null && (l2 == null || l2.val >= l1.val)) {
                resLast.next = l1;
                l1 = l1.next;
                resLast = resLast.next;
            } else {
                resLast.next = l2;
                l2 = l2.next;
                resLast = resLast.next;
            }
        }
        return res.next;
    }
}
