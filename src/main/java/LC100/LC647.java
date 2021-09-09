package LC100;

import java.util.ArrayList;
import java.util.List;

public class LC647 {
    public int countSubstrings(String s) {
        return longestPalindrome(s);
    }

    public int longestPalindrome(String s) {
        int len= s.length();
        //长度小于2，则不需要判断，直接返回
        if(len<2){
            return s.length();
        }
        //最小长度为1
        int maxLen= 1;
        int begin= 0;

        char[] charArray= s.toCharArray();

        boolean[][] dp= new boolean[len][len];

        for(int i=0;i<len;i++)
        {
            dp[i][i]=true;
        }

        for(int j=1;j<len;j++)
        {
            for(int i=0;i<j;i++)
            {
                if(charArray[j]!=charArray[i])
                {
                    dp[i][j]=false;
                }
                else{
                    if(j-i<3)
                        dp[i][j]=true;
                    else
                        dp[i][j]=dp[i+1][j-1];
                }
            }
        }
        int result = 0;

        for (int i = 0; i < len; i++) {
            for(int j = 0;i < len; j++) {
                if (dp[i][j]){
                    result ++;
                }
            }
        }
        return result;
    }
}
