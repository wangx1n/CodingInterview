package leetcode;


public class LC25 {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode pre = new ListNode(-1);
        pre.next = head;
        ListNode tempHead = pre.next;
        for (int i = 1; i < k; i++) {
            ListNode next = tempHead.next;
            tempHead.next = next.next;
            next.next = pre.next;
            pre.next = next;
        }

        return pre.next;
    }
}
class ListNode {
    public ListNode(int val) {
        this.val = val;
    }

    public ListNode() {
    }

    int val;
    ListNode next = null;
}