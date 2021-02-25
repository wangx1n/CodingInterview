package CodingInterview;

import java.util.Stack;

/**
 * @program: CodingInterview.CodingInterview
 * @description:
 * @author: wang xin
 * @create: 2021-01-31 10:31
 *
 * 输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：head = [1,3,2]
 * 输出：[2,3,1]
 *  
 *
 * 限制：
 *
 * 0 <= 链表长度 <= 10000
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/cong-wei-dao-tou-da-yin-lian-biao-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 **/
public class CodingInterview06 {

    public int[] reversePrint(ListNode head) {
        Stack stack = new Stack();
        while(head != null){
            stack.push(head.val);
            head = head.next;
        }
        int[] arrays = new int[stack.size()];
        int i = 0;
        while(!stack.isEmpty()){
            arrays[i] = (int)stack.pop();
            i++;
        }

        return arrays;
    }
}
class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}
