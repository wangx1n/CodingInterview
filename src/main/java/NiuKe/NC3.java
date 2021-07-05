package NiuKe;

import java.util.HashSet;
import java.util.Set;

public class NC3 {
    public ListNode EntryNodeOfLoop(ListNode pHead) {
        HashSet<Integer> hashSet = new HashSet<>();
        ListNode node = pHead;
        while (!hashSet.contains(node.val)) {
            hashSet.add(node.val);
            node = node.next;
            if(node == null) {
                return null;
            }
        }
        return node;
    }
}
