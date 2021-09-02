package leetcode.dp;

import java.util.ArrayList;
import java.util.List;

public class LC119 {
    public List<Integer> getRow(int rowIndex) {
        List<List<Integer>> r = new ArrayList<>();
        for (int i = 0; i < rowIndex; i++) {
            List<Integer> res = new ArrayList<>();
            for (int j = 0 ; j <= i; j++) {
                if (j == 0 || i == j) {
                    res.add(1);
                }else {
                    res.add(r.get(i - 1).get(j - 1) + r.get(i - 1).get(j));
                }
            }
            r.add(res);
        }
        return r.get(r.size() - 1);
    }
}
