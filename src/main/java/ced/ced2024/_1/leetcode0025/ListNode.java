package ced.ced2024._1.leetcode0025;


import java.util.ArrayList;
import java.util.List;

// Definition for singly-linked list.
public class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode hair = new ListNode(0, head);
        ListNode prev = hair;

        while (head != null) {
            ListNode tail = prev;
            for (int i = 0; i < k; i++) {
                tail = tail.next;
                if (tail == null) {
                    return hair.next;
                }
            }
            ListNode next = tail.next;
            List<ListNode> ll = reverse(head, tail);
            head = ll.get(0);
            tail = ll.get(1);

            tail.next = next;
            prev.next = head;
            prev = tail;
            head = next;
        }
        return hair.next;
    }

    public List<ListNode> reverse(ListNode head, ListNode tail) {
        ListNode prev = new ListNode(0, head);
        ListNode tp = head;

        while(prev != tail) {
            ListNode next = tp.next;
            tp.next = prev;
            prev = tp;
            tp = next;
        }
        List<ListNode> ret = new ArrayList<>();
        ret.add(tail);
        ret.add(head);
        return ret;
    }
}