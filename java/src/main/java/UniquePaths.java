/**
 * @created: 2015/2/15
 * @author: nyankosama
 * @description: https://oj.leetcode.com/problems/unique-paths/
 */
public class UniquePaths {

    /**
     * 典型DP
     * @param m
     * @param n
     * @return
     */
    public int uniquePaths(int m, int n) {
        int[][] s = new int[m][n];
        for (int i = 0; i < m; i++) {
            s[i][0] = 1;
        }
        for (int i = 0; i < n; i++) {
            s[0][i] = 1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                s[i][j] = s[i - 1][j] + s[i][j - 1];
            }
        }
        return s[m - 1][n - 1];
    }

    public static void main(String args[]) {
        UniquePaths s = new UniquePaths();
        System.out.println(s.uniquePaths(3, 3));
    }
}
