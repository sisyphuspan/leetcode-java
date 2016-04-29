package dp;

/**
 * Created by sisyphuspan on 16/4/12.
 */
public class UniquePathII_63 {

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if(obstacleGrid == null || obstacleGrid.length == 0
                || obstacleGrid[0].length == 0 || obstacleGrid[0][0] == 1)
            return 0;
        int row = obstacleGrid.length;
        int col = obstacleGrid[0].length;
        int[][] dp = new int[row][col];

        for(int i=0; i<row; i++) {
            if(obstacleGrid[i][0] == 1)
                dp[i][0] = 0;
            else
                dp[i][0] = 1;
        }


        for(int i = 0; i<row; i++) {
            for(int j=0; j<col; j++) {
                if(obstacleGrid[i][j] == 1)
                    dp[i][j] = 0;
                else {
                    int left = 0;
                    int up = 0;
                    if (j - 1 >= 0) left = dp[i][j - 1];
                    if (i - 1 >= 0) up = dp[i - 1][j];
                    dp[i][j] = left + up;
                }
            }
        }
        return dp[row-1][col-1];
    }
}
