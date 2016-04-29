package dp;

/**
 * Created by sisyphuspan on 16/4/15.
 */
public class DistinctSubsequences_115 {

    public int numDistinct(String S, String T) {
        if(S == null || T == null)
            return 0;
        if(S.length() < T.length())
            return 0;

        int dp[][] = new int[S.length()+1][T.length()+1];
        for(int i=0; i<=S.length(); i++) // 变成空字符串只有1种方式
            dp[i][0] = 1;
        for(int j=1; j<=T.length(); j++) // 空字符串变为非空字符串为0
            dp[0][j] = 0;

        for(int i=1; i<=S.length(); i++) {
            for(int j=1; j<=T.length(); j++) {
                if(S.charAt(i-1) == T.charAt(j-1))
                    dp[i][j] = dp[i-1][j] + dp[i-1][j-1]; // dp[i-1][j-1]: 保留S(i)
                else
                    dp[i][j] = dp[i-1][j]; // dp[i-1][j]: 删除S(i)

            }
        }
        return dp[S.length()][T.length()];

    }
}
