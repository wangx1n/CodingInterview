package NiuKe;

import org.junit.Test;

import java.util.*;


/**
 * @program: CodingInterview
 * @description:
 * @author: wang xin
 * @create: 2021/3/26 21:10
 **/
public class NC50 {

    @Test
    public void test2(){
    }

    @Test
    public void test(){
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        ListNode node6 = new ListNode(6);
        ListNode node7 = new ListNode(7);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = node7;

        ListNode node = reverseKGroup(node1,3);
    }

    public static ListNode reverseKGroup(ListNode head, int k) {
        if (head == null) {
            return head;
        }
        // write code here
        ListNode res = new ListNode(0), pre = res, temp, curr = head;
        res.next = head;

        int len = 0;
        while (head != null) {
            head = head.next;
            len++;
        }

        for (int i = 0; i < len / k; i++) {
            for (int j = 1; j < k; j++) {
                temp = curr.next;
                curr.next = temp.next;
                temp.next = pre.next;
                pre.next = temp;
            }
            pre = curr;
            curr = curr.next;
        }

        return res.next;
    }

    public static class ListNode {
        public ListNode(int val) {
            this.val = val;
        }

        public ListNode() {
        }

        int val;
        ListNode next = null;
    }
}
