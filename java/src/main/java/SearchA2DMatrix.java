/**
 * @created: 2015/2/15
 * @author: nyankosama
 * @description: https://oj.leetcode.com/problems/search-a-2d-matrix/
 */
public class SearchA2DMatrix {

    /**
     * 二分搜索，把一维转换成二维
     * @param matrix
     * @param target
     * @return
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        int n = matrix.length;
        int m = matrix[0].length;
        int lo = 0, hi = m * n;
        while (lo < hi) {
            int mid = (lo + hi) / 2;
            int i = mid / m;
            int j = mid % m;
            if (matrix[i][j] < target)
                lo = mid + 1;
            else if (matrix[i][j] > target)
                hi = mid;
            else
                return true;
        }
        return false;
    }

    public static void main(String args[]) {
        int[][] tmp = {{1, 1}};
        SearchA2DMatrix s = new SearchA2DMatrix();
        System.out.println(s.searchMatrix(tmp, 0));
    }
}
