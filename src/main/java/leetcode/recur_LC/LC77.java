package leetcode.recur_LC;

import java.util.ArrayList;
import java.util.List;

public class LC77 {
    public static void main(String[] args) {
        LC77 l = new LC77();
        l.combine(4,2);
    }
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> combine(int n, int k) {
        if (n == 0) return res;
        List<Integer> result = new ArrayList<>();
        recur(n, k, 1, result);
        return res;
    }

    private void recur(int n, int k, int index, List<Integer> result) {
        if (result.size() == k) {
            res.add(new ArrayList<>(result));
            return;
        }
        if (result.size() > k) return;

        for (int i = index;i <= n; i++) {
            result.add(i);
            recur(n,k,i + 1,result);
            result.remove(result.size() - 1);
        }
    }
}
