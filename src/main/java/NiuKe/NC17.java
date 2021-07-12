package NiuKe;

public class NC17 {
    public static void main(String[] args) {
        NC17 nc17 = new NC17();
        nc17.getLongestPalindrome("baabccc",7);
    }
    public int getLongestPalindrome(String A, int n) {
        boolean[][] dp = new boolean[n][n];

        for (int i = 0; i < n ; i++) {
            dp[i][i] = true;
        }

        int maxLen = 0;

        for (int j = 1; j < n ; j++) {
            for (int i = 0; i <= j ; i++) {
                if (A.charAt(i) != A.charAt(j)) {
                    dp[i][j] = false;
                }else {
                    if (j - i < 3) {
                        dp[i][j] = true;
                    } else {
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                }

                if (dp[i][j] && j - i + 1 > maxLen) {
                    maxLen = j - i + 1;
                }
            }
        }

        return maxLen;
    }

}
