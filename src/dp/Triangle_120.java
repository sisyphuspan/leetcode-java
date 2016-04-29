package dp;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sisyphuspan on 16/4/17.
 */
public class Triangle_120 {

    public static void main(String[] args) {
        List<List<Integer>> triangle = new ArrayList<List<Integer>>();
        List<Integer> temp = new ArrayList<Integer>();
        temp.add(-1); triangle.add(temp);
        temp = new ArrayList<Integer>();
        temp.add(-2); temp.add(-3); triangle.add(temp);
        int min = minimumTotal(triangle);
        System.out.print(min);
    }

    public static int minimumTotal(List<List<Integer>> triangle) {
        if(triangle == null || triangle.size() == 0)
            return 0;
        int[][] dp = new int[triangle.size()][triangle.size()];
        dp[0][0] = triangle.get(0).get(0);
        for(int i=1; i< triangle.size(); i++) {
            dp[i][0] = dp[i-1][0] + triangle.get(i).get(0);
            dp[i][i] = dp[i-1][i-1] + triangle.get(i).get(i);
            for(int j=1; j<i; j++) {
                dp[i][j] = Math.min(dp[i-1][j-1], dp[i-1][j]) + triangle.get(i).get(j);
            }
        }
        int minPath = Integer.MAX_VALUE;
        for(int i=0; i<triangle.size(); i++) {
            if(dp[triangle.size()-1][i] < minPath)
                minPath = dp[triangle.size()-1][i];
        }

        return minPath;
    }
}
