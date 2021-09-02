package leetcode.dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC120 {
    public int minimumTotal(List<List<Integer>> triangle) {
        int[][] dp = new int[triangle.size()][triangle.size()];

        dp[0][0] = triangle.get(0).get(0);

        for (int i = 1; i < triangle.size();i++) {
            for(int j = 0; j < triangle.get(i).size();j++) {
                if (j == 0) {
                    dp[i][j] = dp[i - 1][0] + triangle.get(i).get(j);
                } else if (j == triangle.get(i).size() - 1) {
                    dp[i][j] = dp[i - 1][j - 1] + triangle.get(i).get(j);
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j], dp[i - 1][j - 1]) + triangle.get(i).get(j);
                }
            }
        }

        int[] result = dp[triangle.size()];
        Arrays.sort(result);
        return result[result.length - 1];
    }
}
