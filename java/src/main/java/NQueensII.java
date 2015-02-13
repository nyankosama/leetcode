/**
 * @created: 2015/2/13
 * @author: nyankosama
 * @description: https://oj.leetcode.com/problems/n-queens-ii/
 */
public class NQueensII {

    public int totalNQueens(int n) {
        return helper(n, 0, new int[n]);
    }

    /**
     *
     * @param n N-皇后阶数
     * @param row 目前处理到第几行 0-based
     * @param columnForRow 数组，index row下第几行被占用
     */
    private int helper(int n, int row, int[] columnForRow) {
        if (row == n) {
            return 1;
        }
        int count = 0;
        for (int i = 0; i < n; i++) {
            columnForRow[row] = i;
            if (check(row, columnForRow)) count += helper(n, row + 1, columnForRow);
        }
        return count;
    }

    private boolean check(int row, int[] columnForRow) {
        for (int i = 0; i < row; i++) {
            if (columnForRow[row] == columnForRow[i]
                    || Math.abs(columnForRow[row] - columnForRow[i]) == row - i) {
                return false;
            }
        }
        return true;
    }

    public static void main(String args[]) {
        NQueensII s = new NQueensII();
        System.out.println(s.totalNQueens(12));
    }
}
