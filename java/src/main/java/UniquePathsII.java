/**
 * @created: 2015/2/15
 * @author: nyankosama
 * @description: https://oj.leetcode.com/problems/unique-paths-ii/
 */
public class UniquePathsII {

    /**
     * 简单DP
     * @param obstacleGrid
     * @return
     */
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] s = new int[m][n];
        for (int i = 0; i < m; i++) {
            if (obstacleGrid[i][0] == 0) s[i][0] = 1;
            else {
                for (int j = i; j < m; j++) {
                    s[j][0] = 0;
                }
                break;
            }
        }
        for (int i = 0; i < n; i++) {
            if (obstacleGrid[0][i] == 0) s[0][i] = 1;
            else {
                for (int j = i; j < n; j++) {
                    s[0][j] = 0;
                }
                break;
            }
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (obstacleGrid[i][j] == 0)
                    s[i][j] = (obstacleGrid[i - 1][j] == 0 ? s[i - 1][j] : 0) + (obstacleGrid[i][j - 1] == 0 ? s[i][j - 1] : 0);
            }
        }
        return s[m - 1][n - 1];
    }

    public static void main(String args[]) {
        int[][] tmp = {{1, 0}};
        UniquePathsII s = new UniquePathsII();
        System.out.println(s.uniquePathsWithObstacles(tmp));
    }
}
