package dp;

/**
 * Created by sisyphuspan on 16/4/16.
 */
public class InterleavingString_97 {

    public boolean isInterleave(String s1, String s2, String s3) {
        if(s1 == null || s2 == null || s3 == null)
            return false;
        if(s1.length() + s2.length() != s3.length())
            return false;

        boolean dp[][] = new boolean[s1.length()+1][s2.length()+1];
        dp[0][0] = true;
        for(int i=1; i<=s1.length(); i++) {
            if(s3.charAt(i-1) == s1.charAt(i-1) && dp[i-1][0] == true)
                dp[i][0] = true;
        }
        for(int j=1; j<=s2.length(); j++) {
            if(s3.charAt(j-1) == s2.charAt(j-1) && dp[0][j-1] == true)
                dp[0][j] = true;
        }


        for(int i=1; i<=s1.length(); i++) {
            for(int j=1; j<=s2.length(); j++) {

                if(s3.charAt(i+j-1) == s1.charAt(i-1)) {
                    dp[i][j] = dp[i-1][j];
                }

                if(s3.charAt(i+j-1) == s2.charAt(j-1)) {
                    dp[i][j] = dp[i][j] || dp[i][j-1];  // 防止前面dp[i][j] == true 被覆盖掉了
                }
            }


        }
        return dp[s1.length()][s2.length()];
    }
}
