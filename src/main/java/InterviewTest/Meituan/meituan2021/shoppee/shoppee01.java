package InterviewTest.Meituan.meituan2021.shoppee;

public class shoppee01 {
    public static void main(String[] args) {
        String[] s = new String[]{
                "horse"
        };
        System.out.println(
                didYouMean(s, "ros")
        );
    }
    public static String didYouMean(String[] commands, String input) {
        // write code here
        // write code here
        int max = Integer.MAX_VALUE;
        int maxlength = Integer.MAX_VALUE;
        // write code here
        for (int i = 0; i < commands.length;i++) {
            String s = commands[i];
            int n = s.length();
            int m = input.length();
            int[][] dp = new int[n + 1][m + 1];

            for (int j = 0; j < n + 1; j++) {
                dp[j][0] = j;
            }
            for (int k = 0; k < m + 1; k++) {
                dp[0][k] = k;
            }

            for (int j = 1; j < n + 1; j++) {
                for (int k = 1; k < m + 1; k++) {
                    if (s.charAt(j - 1) == input.charAt(k - 1)) {
                        dp[j][k] = dp[j-1][k-1];
                    } else {
                        dp[j][k] = Math.min(dp[j-1][k], Math.min(dp[j][k-1],dp[j-1][k-1])) + 1;
                    }
                }
            }
            if (dp[n][m] < maxlength) {
                maxlength = dp[n][m];
                max = i;
            }
        }
        return commands[max];
    }
}
