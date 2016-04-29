package dp;

/**
 * Created by sisyphuspan on 16/4/15.
 */


public class EditDistance_72 {
    public int minDistance(String word1, String word2) {
        if(word1 == null || word2 == null)
            return -1;
        int dp[][] = new int[word1.length()+1][word2.length()+1];
        for(int i=0; i<=word1.length(); i++)
            dp[i][0] = i;
        for(int j=0; j<=word2.length(); j++)
            dp[0][j] = j;

        for(int i=1; i<=word1.length(); i++) {
            for(int j=1; j<=word2.length(); j++) {
                if(word1.charAt(i-1) == word2.charAt(j-1))
                    dp[i][j] = dp[i-1][j-1];
                else {
                    int replace = dp[i - 1][j - 1] + 1;
                    int delete = dp[i-1][j] + 1;
                    int insert = dp[i][j-1] + 1;
                    dp[i][j] = Math.min(replace, Math.min(insert, delete));
                }
            }
        }
        return dp[word1.length()][word2.length()];
    }
}
