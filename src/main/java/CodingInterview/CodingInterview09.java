package CodingInterview;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @program: CodingInterview.CodingInterview
 * @description: 剑指offer09
 * @author: wang xin
 * @create: 2021-02-14 15:00
 *
 * 用两个栈实现一个队列。队列的声明如下，请实现它的两个函数 appendTail 和 deleteHead ，分别完成在队列尾部插入整数和在队列头部删除整数的功能。(若队列中没有元素，deleteHead 操作返回 -1 )
 *
 *
 * 示例 1：
 *
 * 输入：
 * ["CodingInterview.CQueue","appendTail","deleteHead","deleteHead"]
 * [[],[3],[],[]]
 * 输出：[null,null,3,-1]
 * 示例 2：
 *
 * 输入：
 * ["CodingInterview.CQueue","deleteHead","appendTail","appendTail","deleteHead","deleteHead"]
 * [[],[],[5],[2],[],[]]
 * 输出：[null,-1,null,null,5,2]
 * 提示：
 *
 * 1 <= values <= 10000
 * 最多会对 appendTail、deleteHead 进行 10000 次调用
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/yong-liang-ge-zhan-shi-xian-dui-lie-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 **/
public class CodingInterview09 {
    public static void main(String[] args) {

    }
}

class CQueue {
    Deque<Integer> stack1;
    Deque<Integer> stack2;

    public CQueue() {
        stack1 = new ArrayDeque<>();
        stack2 = new ArrayDeque<>();
    }

    public void appendTail(int value) {
        stack1.push(value);
    }

    public int deleteHead() {
        //1.当stack2为空时，将stack1中的元素都倒入stack2中
        if(stack2.isEmpty()){
            while(!stack1.isEmpty()){
                stack2.push(stack1.pop());
            }
        }
        //2.如果stack2仍然为空，当前队列为空
        if(stack2.isEmpty()){
            return -1;
        }else{//3.如果stack不为空，弹出第一个元素
            int element = stack2.pop();
            return element;
        }
    }
}
