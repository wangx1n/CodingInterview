package NiuKe;

public class NC7 {
    public int maxProfit (int[] prices) {
        // write code here\
        int[][] dp = new int[prices.length][prices.length];

        for (int i = 0;i < prices.length;i++) {
            dp[i][i] = 0;
        }
        int max = 0;
        for (int i = 0;i < prices.length;i++) {
            for (int j = 0;j < prices.length;j++) {
                dp[i][j] = prices[j] - prices[i];
                if (dp[i][j] > max && i != prices.length - 1){
                    max = dp[i][j];
                }
            }
        }

        return max;
    }
}
