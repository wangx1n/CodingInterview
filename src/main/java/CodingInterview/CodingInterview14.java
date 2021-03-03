package CodingInterview;

/**
 * @program: CodingInterview
 * @description:
 * @author: wang xin
 * @create: 2021/3/3 15:51
 **/
public class CodingInterview14 {

    public int cuttingRope(int n) {

        int dp[] = new int[n+1];

        dp[2] = 1;

        for(int i = 3; i <= n ; ++i){
            for(int j = 2; j < i; ++j){
                dp[i] = Math.max(dp[i],Math.max(j*(i-j),j*dp[i-j]));
            }
        }
        return dp[n];
    }

}
