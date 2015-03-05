import java.util.Set;

/**
 * @created: 2015/3/5
 * @author: nyankosama
 * @description:
 */
public class WordBreak {

    /**
     * DP, dp[i]表示0..i-1的子串能否被分割
     * @param s
     * @param dict
     * @return
     */
    public boolean wordBreak(String s, Set<String> dict) {
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true; //初始化
        int size = s.length();
        for (int i = 0; i < size; i++) {
            if (!dp[i]) continue; //如果这个位置之前的子串不能被分割，则直接跳过
            for (String dStr : dict) {
                int len = dStr.length();
                int end = i + len;
                if (end > s.length()) continue; //不能超过range
                if (dp[end]) continue; //已经判断过就continue
                if (s.substring(i, end).equals(dStr)) dp[end] = true;
            }
        }
        return dp[s.length()];
    }
}
