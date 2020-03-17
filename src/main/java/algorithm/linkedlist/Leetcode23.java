package algorithm.linkedlist;

import pojo.ListNode;

/**
 * @program: algorithm
 * @description: 合并K个排序链表
 * @author: szm
 * @create: 2020-03-15 08:57
 **/
public class Leetcode23 {


    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        int l = lists.length;
        while (l > 0) {
            int d = l / 2;
            for (int i = 1; i < d; i++) {
                lists[i] = merge(lists[i], lists[i + d]);
            }
            if ((d & 1) == 1) {
                lists[0] = merge(lists[0], lists[l - 1]);
            }
            l = d;
        }
        return lists[0];
    }

    private ListNode merge(ListNode h1, ListNode h2) {
        ListNode dummy = new ListNode(0);
        ListNode last = dummy;
        while (h1 != null && h2 != null) {
            if (h1.val < h2.val) {
                last.next = h1;
                h1 = h1.next;
            } else {
                last.next = h2;
                h2 = h2.next;
            }
            last = last.next;
        }
        last.next = h1 != null ? h1 : h2;
        return dummy.next;
    }
}
