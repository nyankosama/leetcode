/**
 * @created: 2015/2/15
 * @author: nyankosama
 * @description: https://oj.leetcode.com/problems/set-matrix-zeroes/
 */
public class SetMatrixZeroes {

    /**
     * 使用第一行和第一列来进行记录，如果有该列或该行需要全部变为0，则第一行和第一列对应位置的元素置为0
     * @param matrix
     */
    public void setZeroes(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        boolean firstRowZero = false;
        boolean firstColumnZero = false;

        for (int i = 0; i < n; i++) {
            if (matrix[i][0] == 0) {
                firstColumnZero = true;
            }
        }
        for (int i = 0; i < m; i++) {
            if (matrix[0][i] == 0) {
                firstRowZero = true;
            }
        }

        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                if (matrix[i][j] == 0) {
                    matrix[0][j] = 0;
                    matrix[i][0] = 0;
                }
            }
        }

        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }
        if (firstColumnZero) {
            for (int i = 0; i < matrix.length; i++)
                matrix[i][0] = 0;
        }

        if (firstRowZero) {
            for (int i = 0; i < matrix[0].length; i++)
                matrix[0][i] = 0;
        }
    }
}
