import java.util.ArrayList;
import java.util.List;

/**
 * @created: 2015/2/13
 * @author: nyankosama
 * @description: https://oj.leetcode.com/problems/n-queens/
 */
public class NQueens {

    /**
     * NP问题，直接DFS
     * @param n
     * @return
     */
    public List<String[]> solveNQueens(int n) {
        List<String[]> ret = new ArrayList<String[]>();
        helper(n, 0, new int[n], ret);
        return ret;
    }

    /**
     *
     * @param n N-皇后阶数
     * @param row 目前处理到第几行 0-based
     * @param columnForRow 数组，index row下第几行被占用
     * @param ret
     */
    private void helper(int n, int row, int[] columnForRow, List<String[]> ret) {
        if (row == n) {
            String[] item = new String[n];
            for (int i = 0; i < n; i++) {
                StringBuilder rowSb = new StringBuilder(n);
                for (int j = 0; j < n; j++) {
                    if (columnForRow[i] == j)
                        rowSb.append('Q');
                    else
                        rowSb.append('.');
                }
                item[i] = rowSb.toString();
            }
            ret.add(item);
            return;
        }
        for (int i = 0; i < n; i++) {
            columnForRow[row] = i;
            if (check(row, columnForRow)) helper(n, row + 1, columnForRow, ret);
        }
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
        NQueens s = new NQueens();
        List<String[]> ret = s.solveNQueens(8);
        System.out.println("*************");
        for (String[] lines : ret) {
            for (String line : lines) {
                System.out.println(line);
            }
            System.out.println("===============");
        }
    }
}
