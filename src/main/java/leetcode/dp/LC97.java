package leetcode.dp;

public class LC97 {
    public boolean isInterleave(String s1, String s2, String s3) {
        int n = s1.length();
        int m = s2.length();
        int t = s3.length();

        if(m + n != t) return false;

        boolean[][] dp = new boolean[n + 1][m + 1];

        dp[0][0] = true;

        for (int i = 0;i <= n; i++) {
            for (int j = 0;j <= m; j++) {
                int p = i - j + 1;

                if (i > 0) {
                    dp[i][j] = dp[i][j] || ( dp[i - 1][j] && s3.charAt(p) == s1.charAt(i - 1));
                }
                if (j > 0) {
                    dp[i][j] = dp[i][j] || ( dp[i][j - 1] && s3.charAt(p) == s2.charAt(j - 1));
                }
            }
        }

        return dp[n][m];
    }
}
