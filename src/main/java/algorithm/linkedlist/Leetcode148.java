package algorithm.linkedlist;

import org.junit.jupiter.api.Test;
import pojo.ListNode;

/**
 * @program: algorithm
 * @description: 排序链表
 * @author: szm
 * @create: 2020-02-16 20:08
 **/
public class Leetcode148 {

    @Test
    public void test() {
        System.out.println("----------start-----------");
//        -1->5->3->4->0
        ListNode head = new ListNode(-1);
        ListNode n1 = new ListNode(5);
        ListNode n2 = new ListNode(3);
        ListNode n3 = new ListNode(4);
        ListNode n4 = new ListNode(0);
        head.next = n1;
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;

        ListNode listNode = sortList(head);

        while(listNode != null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }

    public ListNode sortList(ListNode head) {
        if (head == null) {
            return null;
        }
        if(head.next == null) return head;
        ListNode zhongPre = findZhongPre(head);
        ListNode zhongHead = zhongPre.next;
        zhongPre.next = null;
        // 递归二分归并排序，返回的每一步都是有序链表
        return merge(sortList(head), sortList(zhongHead));
    }

    // 二分定位
    private ListNode findZhongPre(ListNode node) {
        if(node == null) return node;
        ListNode slow = node;
        ListNode fast = node;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    // merge 归并排序有序链表
    private ListNode merge(ListNode l1, ListNode l2) {
        ListNode resHead = new ListNode(0);
        ListNode p = resHead;
        while (l1 != null || l2 != null) {
            if (l1 != null && (l2 == null || l1.val <= l2.val)) {
                p.next = l1;
                p = p.next;
                l1 = l1.next;
            } else {
                p.next = l2;
                p = p.next;
                l2 = l2.next;
            }
        }
        return resHead.next;
    }
}
