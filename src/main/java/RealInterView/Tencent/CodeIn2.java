package RealInterView.Tencent;

import javax.xml.soap.Node;

public class CodeIn2 {
    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2= new ListNode(2);
        ListNode node3 = new ListNode(3);
        node1.next = node2;
        node2.next = node3;

        CodeIn2 c = new CodeIn2();
        ListNode newNode = c.reverse(node1);
    }
    public ListNode reverse(ListNode head) {
        ListNode temp = head.next;
        head.next = null;
        while(temp != null) {
            ListNode newHead = temp.next;
            temp.next = head;
            head = temp;
            temp = newHead;
        }
        return head;
    }
}
