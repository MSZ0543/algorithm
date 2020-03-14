package algorithm.linkedlist;

import org.junit.jupiter.api.Test;
import pojo.ListNode;

/**
 * @program: algorithm
 * @description: 旋转链表
 * @author: szm
 * @create: 2020-03-14 21:29
 **/
public class Leetcode61 {

    @Test
    public void test() {
        System.out.println("----------start-----------");
//        -1->5->3->4->0
        ListNode head = new ListNode(1);
        ListNode n1 = new ListNode(2);
        ListNode n2 = new ListNode(3);
        ListNode n3 = new ListNode(4);
        ListNode n4 = new ListNode(5);
        head.next = n1;
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;

        ListNode listNode = rotateRight(head, 5);

        while(listNode != null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }


    public ListNode rotateRight(ListNode head, int k) {
        if (k == 0 || head == null || head.next == null) return head;
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode last = head;
        int len = 1;
        while (last != null && last.next != null) {
            len++;
            last = last.next;
        }
        int n = len - (k % len);
        if (n > 0) {
            ListNode p = head;
            ListNode pre = dummy;
            while (n-- > 0) {
                p = p.next;
                pre = pre.next;
            }
            dummy.next = p;
            last.next = head;
            pre.next = null;
        }

        return dummy.next;
    }
}
