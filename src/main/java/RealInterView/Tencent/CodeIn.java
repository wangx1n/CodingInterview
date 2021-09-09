package RealInterView.Tencent;

import java.util.Deque;
import java.util.LinkedList;

public class CodeIn {
    public static void main(String[] args) {
        CodeIn c = new CodeIn();
        System.out.println(c.isValid("(){}()"));
    }
    public boolean isValid(String s) {
        char[] res = s.toCharArray();
        Deque<Character> stack = new LinkedList<>();
        stack.push(res[0]);
        for(int i = 1;i < res.length;i++) {
            if(res[i] == '{') {
                if (stack.peek() == '(' || stack.peek() == '[')
                    return false;
                stack.push(res[i]);
            } else if (res[i] == '['){
                if (stack.peek() == '(' )
                    return false;
                stack.push(res[i]);
            } else if (res[i] == '('){
                stack.push(res[i]);
            } else{
                if (stack.isEmpty()) {
                    return false;
                }
                if (res[i] == '}') {
                    char c = stack.pop();
                    if (c != '{') return false;
                }
                else if (res[i] == ']') {
                    char c = stack.pop();
                    if (c != '[') return false;
                } else if (res[i] == ')'){
                    char c = stack.pop();
                    if (c != '(') return false;
                }
            }
        }
        if (!stack.isEmpty()) {
            return false;
        }
        return true;
    }
}
