package leetcode.dp;

import java.util.ArrayList;
import java.util.List;

public class LC118 {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0;i < numRows; i++) {
            List<Integer> result = new ArrayList<>();
            for (int j = 0;j <= i;j++) {
                if (j == 0 || j == i) {
                    result.add(1);
                }else {
                    result.add(res.get(i - 1).get(j - 1) + res.get(i - 1).get(j));
                }
            }
            res.add(result);
        }
        return res;
    }
}
