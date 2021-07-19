package leetcode.recur_LC;

import java.lang.reflect.Array;
import java.util.*;

public class LC22 {

    public static void main(String[] args) {
        LC22 lc22 = new LC22();
        lc22.generateParenthesis(3);
        ArrayList list = new ArrayList();
        ArrayList list2 = (ArrayList)list.clone();
    }
    public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();
        if (n == 0) {
            return list;
        }

        Map<Integer, String> map = new HashMap<Integer, String>(){{
            put(1, "(");
            put(2, ")");
        }};

        StringBuilder str = new StringBuilder();
        recur(map, n, 0, list, str);

        return list;
    }

    private void recur(Map<Integer, String> map, int count, int index, List<String> list, StringBuilder res) {
        if (index > count * 2) return;
        if (index == count * 2) {
            if (match(res.toString())) {
                list.add(res.toString());
            } else {
                return;
            }
        }
        for (int i = 1; i <= 2; i++) {
            res.append(map.get(i));
            recur(map, count, index + 1, list, res);
            res.deleteCharAt(index);
        }
    }

    private boolean match(String s) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            Character c = s.charAt(i);
            if (c == '(') {
                count ++;
            } else if (c == ')') {
                if (count <= 0) {
                    return false;
                } else {
                    count--;
                }
            }
        }
        if (count == 0) {
            return true;
        } else {
            return false;
        }
    }
}
