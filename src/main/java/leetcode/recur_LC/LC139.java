package leetcode.recur_LC;

import java.util.ArrayList;
import java.util.List;

public class LC139 {
    List<List<String>> result = new ArrayList<>();
    List<String> r = new ArrayList<>();
    int n;
    boolean[][] res;
    public List<List<String>> partition(String s) {
        n = s.length();
        res = new boolean[s.length()][s.length()];

        for (int i = 0;i < s.length();i++) {
            res[i][i] = true;
        }

        for (int j = 1; j < s.length();j++) {
            for (int i = 0;i < j;i++) {
                if (s.charAt(i) != s.charAt(j)) {
                    res[i][j] = false;
                }else {
                    if (j - i < 3) {
                        res[i][j] = true;
                    } else {
                        res[i][j] = res[i + 1][j - 1];
                    }
                }
            }
        }

        dfs(s, 0);

        return result;
    }
    private void dfs(String s, int index) {
        if (index == n) {
            result.add(new ArrayList(r));
            return;
        }

        for (int i = index; i < n; i++) {
            if (res[i][index]) {
                r.add(s.substring(index, i + 1));
                dfs(s, i + 1);
                r.remove(r.size() - 1);
            }
        }
    }
}
