package Interview.tencent;

import LC100.ListNode;

public class tencent20211001 {
    /**
     * 去除单链表中相邻的重复节点， 比如 1->2->2->5->3->3->3-7，去重之后 1->2->5->3->7￼
     */

    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(1);
        ListNode n3 = new ListNode(2);
        ListNode n4 = new ListNode(2);
        ListNode n5 = new ListNode(3);
        ListNode n6 = new ListNode(4);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n6;
        ListNode head = deleteNode(n1);
        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }
    }

    public static ListNode deleteNode(ListNode head) {
        ListNode slow = head;
        if (slow == null) {
            return null;
        }
        ListNode fast = head.next;
        while (fast != null) {
            if (slow.val == fast.val) {
                slow.next = fast.next;
                fast = slow.next;
            }else {
                fast = fast.next;
                slow = slow.next;
            }
        }
        return head;
    }
}
