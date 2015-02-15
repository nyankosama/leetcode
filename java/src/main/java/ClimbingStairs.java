/**
 * @created: 2015/2/15
 * @author: nyankosama
 * @description: https://oj.leetcode.com/problems/climbing-stairs/
 */
public class ClimbingStairs {

    /**
     * 典型DP
     * @param n
     * @return
     */
    public int climbStairs(int n) {
        if (n == 0) return 0;
        int[] s = new int[n];
        if (n >= 1) s[0] = 1;
        if (n >= 2) s[1] = 2;
        for (int i = 2; i < n; i++)
            s[i] = s[i - 1] + s[i - 2];
        return s[n - 1];
    }
}
