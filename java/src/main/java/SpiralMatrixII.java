/**
 * @created: 2015/2/15
 * @author: nyankosama
 * @description: https://oj.leetcode.com/problems/spiral-matrix-ii/
 */
public class SpiralMatrixII {

    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];

        int x = 0;
        int y = 0;
        int num = 1;


        while (n > 0) {
            //如果只有一行或者一列留下，单独处理
            if (n == 1) {
                for (int i = 0; i < n; i++) {
                    matrix[x][y++] = num++;
                }
                break;
            }

            //左上到右上
            for (int i = 0; i < n - 1; i++) {
                matrix[x][y++] = num++;
            }
            //右上到右下
            for (int i = 0; i < n - 1; i++) {
                matrix[x++][y] = num++;
            }
            //右下到左下
            for (int i = 0; i < n - 1; i++) {
                matrix[x][y--] = num++;
            }
            //左下到左上
            for (int i = 0; i < n - 1; i++) {
                matrix[x--][y] = num++;
            }
            x++;
            y++;
            n = n - 2;
        }
        return matrix;
    }

    public static void main(String args[]) {
        SpiralMatrix s = new SpiralMatrix();
        SpiralMatrixII s2 = new SpiralMatrixII();
        for (Integer integer : s.spiralOrder(s2.generateMatrix(3))) {
            System.out.print(integer + " ");
        }
    }
}
