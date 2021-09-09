package LC100;

public class LC148 {
    public static void main(String[] args) {
        ListNode node3 = new ListNode(3);
        ListNode node2 = new ListNode(5);
        ListNode node1 = new ListNode(7);
        node1.next = node2;
        node2.next = node3;
        node3.next = null;
        LC148 l = new LC148();
        l.sortList(node1);
    }
    public ListNode sortList(ListNode head) {
        return sort(head, null);
    }
    public ListNode sort(ListNode head, ListNode tail) {
        if (head == null) {
            return head;
        }
        if (head.next == tail){ // 3. 这一步保证了拆分后的第一个链表后面不会跟其他元素，而是单独成为一个链表
            head.next = null;   // 4. 对于拆分后的第二个链表，由于tail = null， 所以后面一个元素必定为null
            return head;
        }
        ListNode fast = head, slow = head;
        while(fast != tail) { // 1. dump为头时才是中点
            slow = slow.next;
            fast = fast.next;
            if (fast != tail) {
                fast = fast.next;
            }
        }
        ListNode left = sort(head, slow);
        ListNode right = sort(slow, tail);
        ListNode res = merge(left, right);
        return res;
    }

    public ListNode merge(ListNode head1, ListNode head2) {
        ListNode dumpHead = new ListNode(0);
        ListNode temp1 = head1;
        ListNode temp2 = head2;
        ListNode temp = dumpHead;
        while(temp1 != null && temp2 != null) { // 2. 为什么Mid进来之后，后面的元素是null？
            if (temp1.val <= temp2.val) {
                temp.next = temp1;
                temp1 = temp1.next;
            } else {
                temp.next = temp2;
                temp2 = temp2.next;
            }
            temp = temp.next;
        }
        if(temp1 != null) {
            temp.next = temp1;
        }else if(temp2 != null) {
            temp.next = temp2;
        }
        return dumpHead.next;
    }
}
