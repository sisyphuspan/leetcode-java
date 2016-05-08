

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sisyphuspan on 16/4/18.
 */
public class PalindromePartitioning_131 {

    public static void main(String[] args) {
        List<List<String>> result = partition("aabb");
        System.out.print(result.size());
    }

    public static List<List<String>> partition(String s) {
        if(s==null || s.length()==0)
            return null;
        List<List<String>> result = new ArrayList<List<String>>();
        List<String> temp = new ArrayList<String>();
        int[][] dp = dp(s);
        dfs(dp, 0, temp, s, result);
        return result;
    }

    // dp[i][j]: i~j是否是回文, 依赖于dp[i+1][j-1]
    public static int[][] dp(String s) {
        if(s==null || s.length()==0)
            return null;
        int[][] dp = new int[s.length()][s.length()];
        // 倒着开始, dp[i+1][j-1]会先算出来
        for(int i=s.length()-1; i>=0; i--) {
            for(int j=i; j<s.length(); j++) {
                if(j==i)
                    dp[i][j] = 1; // 一个字母是回文串
                else {
                    if(s.charAt(i)==s.charAt(j)) { // 两头字符相等, 中间没有字符或中间是回文串, 则为回文
                        if(j == i+1 || dp[i+1][j-1] == 1)
                            dp[i][j] = 1;
                    }
                }
            }
        }
        return dp;
    }

    // 需要递归
    public static void dfs(int[][] dp, int begin, List<String> temp, String s, List<List<String>> result) {
        if(begin == s.length()) {
            result.add(new ArrayList<String>(temp)); // 注意List<>中的是引用, 不深拷贝, 后面会改变
            return; // 不用return, 符合该条件,后面的for循环不会执行
        }

        for(int i=begin; i<s.length(); i++) {
            List<String> item = new ArrayList<String>(temp); // 记录当前temp值, 后续的递归会改变temp
            if(dp[begin][i] == 1) {
                item.add(s.substring(begin, i+1));
                dfs(dp, i+1, item, s, result);
            }
        }

    }
}
