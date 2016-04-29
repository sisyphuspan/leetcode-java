package dp;

/**
 * Created by sisyphuspan on 16/4/12.
 */
public class UniquePath_62 {

    public static void main(String[] args) {


    }

    public static int uniquePaths(int m, int n) {
        // 还可以将空间复杂度优化为O(n), 用一行或一列替换整个dp[][]
        int[][] dp = new int[m][n];
        for(int i=0; i<m; i++)
            dp[i][0] = 1;
        dp[0][0] = 1;
        for(int i=0; i<m; i++) {
            for(int j=1; j<n; j++) {
                int left = 0;
                int up = 0;
                if(j-1 >= 0) left = dp[i][j-1];
                if(i-1 >=0) up = dp[i-1][j];
                dp[i][j] = left + up;
            }
        }
        return dp[m-1][n-1];
    }
}
