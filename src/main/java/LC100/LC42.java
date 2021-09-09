package LC100;

import java.util.Deque;
import java.util.LinkedList;

public class LC42 {
    public static void main(String[] args) {
        int[] h = {0,1,0,2,1,0,1,3,2,1,2,1};
        LC42 l = new LC42();
        l.trap(h);
    }
    public int trap(int[] height) {
        int ans = 0;
        Deque<Integer> stack = new LinkedList<Integer>();
        int n = height.length;
        for (int i = 0; i < n; ++i) {
            while (!stack.isEmpty() && height[i] > height[stack.peek()]) { // 1. 找到最左边的能接雨水的隔板
                int top = stack.pop();                           // 2. 计算完了才能把i push进栈
                if (stack.isEmpty()) {
                    break;
                }
                int left = stack.peek(); // 3.因为left不一定够当挡板，所以这里一直用的是left
                int currWidth = i - left - 1;
                int currHeight = Math.min(height[left], height[i]) - height[top];
                ans += currWidth * currHeight;
            }
            stack.push(i);
        }
        return ans;
    }
}
