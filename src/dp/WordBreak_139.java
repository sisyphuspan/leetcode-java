package dp;

import java.util.Set;

/**
 * Created by sisyphuspan on 16/4/15.
 */
public class WordBreak_139 {
    public boolean wordBreak(String s, Set<String> wordDict) {
        if(s == null || wordDict == null || wordDict.size() == 0)
            return false;
        boolean dp[] = new boolean[s.length()+1]; // 默认的初始化都是false
        dp[0] = true;
        for(int i=1; i<=s.length(); i++) {
            for(int j=0; j<i; j++) {
                // 前部分可以,后部分又在字典中,则整个可以
                if(dp[j] && wordDict.contains(s.substring(j, i))) {
                    dp[i] = true;
                }
            }
        }
        return dp[s.length()];
    }
}
