package leetcode;

import java.util.ArrayList;
import java.util.List;

public class _ {
    List<String> res = new ArrayList<>();
    public List<String> generateParenthesis(int n) {
        StringBuilder b = new StringBuilder();
        if (n == 0) return res;
        recur(n * 2, 0,b);
        return res;
    }
    private void recur(int target, int index, StringBuilder b) {
        if (b.length() == target) {
            if (match(b.toString())){
                res.add(b.toString());
                return;
            }
            return;
        }
        b.append("(");
        recur(target,index,b);
        b.deleteCharAt(b.length() - 1);
        b.append(")");
        recur(target,index,b);
        b.deleteCharAt(b.length() - 1);
    }

    private boolean match(String s) {
        int isMatch = 0;
        for (int i = 0;i < s.length();i++) {
            if (s.charAt(i) == ')') {
                isMatch--;
            }else{
                isMatch++;
            }
            if(isMatch < 0) return false;
        }
        if (isMatch != 0) return false;
        return true;
    }
}
