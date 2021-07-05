package NiuKe;

public class NC2 {

    public void reorderList(ListNode head) {
        if (head == null || head.next == null || head.next.next == null) {
            return;
        }
        ListNode mid = findmid(head);

        ListNode newNode = reverse(mid.next);
        mid.next = null;

        head = AppendLinkedList(head, newNode);
    }

    public ListNode findmid(ListNode node) {
        ListNode fast = node;
        ListNode slow = node;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        if(fast.next != null) {
            return slow.next;
        } else {
            return slow;
        }
    }

    public ListNode reverse(ListNode node) {
        ListNode newNode = null;
        while (node != null) {
            ListNode temp = node.next;
            node.next = newNode;
            newNode = node;
            node = temp;
        }

        return newNode;
    }

    public ListNode AppendLinkedList(ListNode head, ListNode newNode) {
        ListNode head1 = head;
        while(newNode != null) {
            ListNode temp = newNode.next;
            newNode.next = head.next;
            head.next = newNode;
            head = newNode.next;
            newNode = temp;
        }
        return head1;
    }
}
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
        next = null;
    }
}
