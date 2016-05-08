

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sisyphuspan on 16/4/18.
 */
public class PalindromePartitioning_II_132 {

    public static void main(String[] args) {
        int result = minCut("aabb");
        System.out.print(result);
    }

    public static int minCut(String s) {
        if(s==null || s.length()==0)
            return 0;

        int[][] dp = new int[s.length()][s.length()];
        int cut[] = new int[s.length()];
        for(int i=s.length()-1; i>=0; i--)
            cut[i] = s.length()-1-i;
        // 倒着开始, dp[i+1][j-1]会先算出来
        for(int i=s.length()-1; i>=0; i--) {
            for(int j=i; j<s.length(); j++) {
                if(j==i) {
                    dp[i][j] = 1; // 一个字母是回文串
                } else {
                    if(s.charAt(i)==s.charAt(j)) { // 两头字符相等, 中间没有字符或中间是回文串, 则为回文
                        if(j == i+1 || dp[i+1][j-1] == 1)
                            dp[i][j] = 1;
                    }
                }

                if(dp[i][j] == 1) {
                    cut[i] = cut[j];
                }
            }
        }
        return cut[0];
    }
}
