/**
 * @created: 2015/2/15
 * @author: nyankosama
 * @description: https://oj.leetcode.com/problems/minimum-path-sum/
 */
public class MinimumPathSum {

    /**
     * 典型DP
     * @param grid
     * @return
     */
    public int minPathSum(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] sum = new int[n][m];
        sum[0][0] = grid[0][0];
        //更新上边缘和左边缘
        for (int i = 1; i < n; i++) {
            sum[i][0] = sum[i - 1][0] + grid[i][0];
        }
        for (int i = 1; i < m; i++) {
            sum[0][i] = sum[0][i - 1] + grid[0][i];
        }
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                sum[i][j] = Math.min(sum[i - 1][j], sum[i][j - 1]) + grid[i][j];
            }
        }
        return sum[n - 1][m - 1];
    }

    public static void main(String args[]) {
        MinimumPathSum s = new MinimumPathSum();
        int[][] tmp = {{1, 2}, {1, 1}};
        System.out.println(s.minPathSum(tmp));
    }
}
