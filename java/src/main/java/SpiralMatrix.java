import java.util.ArrayList;
import java.util.List;

/**
 * @created: 2015/2/15
 * @author: nyankosama
 * @description: https://oj.leetcode.com/problems/spiral-matrix/
 */
public class SpiralMatrix {

    public List<Integer> spiralOrder(int[][] matrix) {
        ArrayList<Integer> result = new ArrayList<Integer>();

        if(matrix == null || matrix.length == 0) return result;
        int m = matrix.length;
        int n = matrix[0].length;
        int x=0;
        int y=0;

        while(m>0 && n>0){
            //如果只有一行或者一列留下，单独处理
            if(m==1){
                for(int i=0; i<n; i++){
                    result.add(matrix[x][y++]);
                }
                break;
            }else if(n==1){
                for(int i=0; i<m; i++){
                    result.add(matrix[x++][y]);
                }
                break;
            }

            //下面，处理环

            //左上到右上
            for(int i=0;i<n-1;i++){
                result.add(matrix[x][y++]);
            }
            //右上到右下
            for(int i=0;i<m-1;i++){
                result.add(matrix[x++][y]);
            }
            //右下到左下
            for(int i=0;i<n-1;i++){
                result.add(matrix[x][y--]);
            }
            //左下到左上
            for(int i=0;i<m-1;i++){
                result.add(matrix[x--][y]);
            }
            x++;
            y++;
            m=m-2;
            n=n-2;
        }
        return result;
    }
}
