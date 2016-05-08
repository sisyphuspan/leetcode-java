

import java.io.IOException;

/**
 * Created by sisyphuspan on 16/4/12.
 */
public class MinPathGrid_64 {


    public  static void main(String[] args) throws IOException {

    }

    public int minPathSum(int[][] grid) {
        if(grid == null || grid.length == 0 || grid[0].length == 0)
            return 0;
        int row = grid.length;
        int col = grid[0].length;
        int[][] dp = new int[row][col];
        dp[0][0] = grid[0][0];
        for(int i=1; i<row; i++)
            dp[i][0] = dp[i-1][0] + grid[i][0];
        for(int i=0; i<row; i++) {
            for(int j=1; j<col; j++) {
                int left = Integer.MAX_VALUE;
                int up = Integer.MAX_VALUE;
                if(j-1 >= 0) left = dp[i][j-1];
                if(i-1 >=0) up = dp[i-1][j];
                dp[i][j] = Math.min(left, up) + grid[i][j];
            }
        }
        return dp[row-1][col-1];
    }
}
