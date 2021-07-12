package NiuKe;

import java.util.List;

public class NC21 {
    public ListNode reverseBetween (ListNode head, int m, int n) {
        ListNode newHead = new ListNode(0);
        newHead.next = head;
        ListNode curr = newHead;
        // write code here
        for (int i = 1; i < m  ; i++) {
            curr = curr.next;
        }

        ListNode tempHead = curr.next;

        for (int i = m; i < n; i++) {
            ListNode next = tempHead.next;
            tempHead.next = next.next;
            next.next = curr.next;
            curr.next = next;
        }

        return newHead.next;
    }
}
