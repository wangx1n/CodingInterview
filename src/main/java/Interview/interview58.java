package Interview;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

public class interview58 {

    public static void main(String[] args) {
        System.out.println(decodeString("3[2[3[a]c]d]e"));
    }
    public static Stack<Integer> mul = new Stack<>();
    public static int num;

    public static String decodeString (String Str) {
        // write code here
        char[] str = Str.toCharArray();
        int n = str.length;
        Deque<Integer> mulStack = new ArrayDeque<>();
        Deque<StringBuilder> stringStack = new ArrayDeque<>();
        int num = 0;
        StringBuilder temp = new StringBuilder();
        StringBuilder result = new StringBuilder();
        for(char cur : str){
            if(cur >= '0' && cur <= '9') {
                num = num * 10 + cur - '0';
            }else if(cur == '[') {
                mulStack.offerLast(num);
                stringStack.offerLast(temp);
                num = 0;
                temp = new StringBuilder();
            }else if (cur == ']') {
                int size = mulStack.pollLast();
                StringBuilder top = stringStack.pollLast();
                for (int i = 0; i < size;++i) {
                    top.append(temp);
                }
                temp = top;
            }else {
                temp.append(cur);
            }
        }
        return temp.toString();
    }
}
