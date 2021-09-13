package InterviewTest.Meituan.meituan2021.tencent;

import java.util.Arrays;
import java.util.Stack;

public class tencent202102 {
    public static void main(String[] args) {
        findBuilding(new int[]{5,3,8,3,2,5});
    }
    public static int[] findBuilding (int[] heights) {
        // write code here
        Stack<Integer> stack1 = new Stack<>();
        int n = heights.length;
        int[] res = new int[n];
        Arrays.fill(res,1);       //最起码能看到自己所在的这栋楼
        for(int i=0;i<n-1;i++){   //首先向左边看
            //只要当前楼大于等于前面遍历过的楼，就把前面的矮楼丢掉，因为我站在该楼右边是看不到的
            while(!stack1.isEmpty() && heights[i]>=stack1.peek()){
                stack1.pop();
            }
            stack1.push(heights[i]);
            //这里i+1才是核心，因为我已经通过while循环把比当前楼矮的都去掉了，所以栈里剩下的都比当前楼高
            //也就是说当我站在该楼的右边一栋楼，栈里的楼我都能看到
            res[i+1]+=stack1.size();
        }
        Stack<Integer> stack2 = new Stack<>();
        for(int i=n-1;i>0;i--){   //然后向右边看
            while(!stack2.isEmpty() && heights[i]>=stack2.peek()){
                stack2.pop();
            }
            stack2.push(heights[i]);
            res[i-1]+=stack2.size();  //同理
        }
        return res;
    }
}
