package oj;

import java.util.List;

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
public class OJ25 {
    public static ListNode reverseKGroup(ListNode head, int k)  {
        ListNode hair = new ListNode(0, head);
        ListNode pre = hair;

        while(head != null) {
            ListNode tail = pre;

            for(int i = k;i > 0;i--){
                tail = tail.next;
                if(tail == null){
                    return hair.next;
                }
            }

            ListNode nex = tail.next;
            ListNode[] nodes = ReverseGroup(head,tail);
            head = nodes[0];
            tail = nodes[1];

            pre.next = head;
            tail.next = nex;
            pre = tail;
            head = tail.next;
        }

        return hair.next;
    }

    public static ListNode[] ReverseGroup(ListNode head, ListNode tail){
        ListNode curr = head;
        ListNode prev = tail.next;

        while(prev != tail){
            ListNode nex = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nex;
        }

        return new ListNode[]{tail, head};
    }

    public static void main(String[] args) {
        ListNode node7 = new ListNode(7,null);
        ListNode node6 = new ListNode(6,node7);
        ListNode node5 = new ListNode(5,node6);
        ListNode node4 = new ListNode(4,node5);
        ListNode node3 = new ListNode(3,node4);
        ListNode node2 = new ListNode(2,node3);
        ListNode node1 = new ListNode(1,node2);
        ListNode node10 = reverseKGroup(node1,3);
        while(node10 != null){
            System.out.println(node10.val);
            node10 = node10.next;
        }
    }
}
