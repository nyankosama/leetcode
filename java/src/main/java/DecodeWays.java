/**
 * @created: 2015/2/16
 * @author: nyankosama
 * @description: https://oj.leetcode.com/problems/decode-ways/
 */
public class DecodeWays {

    /**
     * 动态规划
     * @param s
     * @return
     */
    public int numDecodings(String s) {
        int n = s.length();
        if (n == 0) return 0;
        int[] dp = new int[n + 1];
        dp[0] = 1;
        if (isValid(s.substring(0, 1))) dp[1] = 1;
        else dp[1] = 0;
        for (int i = 2; i <= n; i++) {
            if (isValid(s.substring(i - 1, i)))
                dp[i] = dp[i - 1];
            if (isValid(s.substring(i - 2, i)))
                dp[i] += dp[i - 2];
        }
        return dp[n];
    }

    public boolean isValid(String s) {
        if (s.charAt(0) == '0') return false;
        int code = Integer.parseInt(s);
        return code >= 1 && code <= 26;
    }

    /**
     * 直接用dfs
     *
     * @param s
     * @return
     */
    public int numDecodingsNaive(String s) {
        if (s.length() == 0) {
            return 1;
        }
        int ret = 0;
        char cur = s.charAt(0);
        if (cur == '1') {
            if (s.length() > 1) {
                ret += numDecodingsNaive(s.substring(2, s.length()));
            }
            if (s.length() == 1 || (s.length() > 1 && s.charAt(1) != '0'))
                ret += numDecodingsNaive(s.substring(1, s.length()));
        } else {
            if (s.length() > 1 && s.charAt(1) >= '0' && s.charAt(1) <= '6') {
                ret += numDecodingsNaive(s.substring(2, s.length()));
            }
            if (s.length() == 1 || (s.length() > 1 && s.charAt(1) != '0'))
                ret += numDecodingsNaive(s.substring(1, s.length()));
        }
        return ret;
    }

    public static void main(String args[]) {
        DecodeWays s = new DecodeWays();
        System.out.println(s.numDecodings("121"));
    }
}
