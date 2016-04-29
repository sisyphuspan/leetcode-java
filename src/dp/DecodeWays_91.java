package dp;

/**
 * Created by sisyphuspan on 16/4/14.
 */
public class DecodeWays_91 {

    /*
        基本dp + 细节剪枝
        细节注意点:  由于0没有对应的字母, 因此 10 和 01 这两种形式要注意(两位组合首位不能为0, 单个数字编码不能为0)

        基本转化方程式: dp[i] = dp[i-2] + dp[i-1]
    */
    public static void main(String[] args) {
        int count = numDecodings("100");
        System.out.println(count);
    }

    public static int numDecodings(String s) {
        if(s == null || s.length() == 0)
            return 0;
        if(s.startsWith("0"))
            return 0;
        if(s.length() == 1)
            return 1;
        int len = s.length();
        int[] dp = new int[len];
        dp[0] = 1;

        for(int i=1; i<len; i++) {
            if(s.charAt(i-1) == '0') {
                if(s.charAt(i) != '0')
                    dp[i] = dp[i-1];
                else
                    return 0;
            }else {
                int lastTwo = Integer.parseInt(s.substring(i - 1, i + 1));
                if (lastTwo == 0)
                    return 0;
                if (lastTwo > 26) {
                    if (s.charAt(i) != '0')
                        dp[i] = dp[i - 1];
                    else
                        return 0;
                } else if (lastTwo == 0) {
                    return 0;
                } else {
                    if (s.charAt(i) != '0')
                        if (i - 2 < 0)
                            dp[i] = 1 + dp[i - 1];
                        else
                            dp[i] = dp[i - 2] + dp[i - 1];
                    else {
                        if (i - 2 < 0)
                            dp[i] = 1;
                        else
                            dp[i] = dp[i - 2];
                    }

                }
            }

            if(dp[i] == 0)
                return 0;
        }
        return dp[len-1];
    }
}
