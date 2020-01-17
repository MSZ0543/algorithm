package algorithm.linkedlist;

import org.junit.jupiter.api.Test;
import pojo.ListNode;

/**
 * @program: algorithm
 * @description: 反转链表
 * @author: szm
 * @create: 2020-01-17 16:03
 **/
public class Leetcode206 {

    @Test
    public void test() {
        System.out.println("----------start-----------");

    }

    public ListNode reverseList(ListNode head) {
        // 通过
        ListNode pre = null;
        ListNode p = head;
        ListNode last = null;
        while (p != null) {
            last = p.next;
            p.next = pre;
            pre = p;
            p = last;
        }
        return pre;
    }
}
