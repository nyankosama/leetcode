/**
 * @created: 2015/2/11
 * @author: nyankosama
 * @description: https://oj.leetcode.com/problems/search-for-a-range/
 */
public class SearchForARange {

    /**
     * 两道二分搜索，一次找左边界，一次找右边界
     * 这里找边界的二分搜索去掉==的条件，在else中来调整即可
     * 即找左边界的话，else中要调整hi
     * 找右边界的话，else中要调整lo
     * @param A
     * @param target
     * @return
     */
    public int[] searchRange(int[] A, int target) {
        int ret[] = new int[]{-1, -1};
        int lo = 0, hi = A.length;
        int mid;

        //找到左边界
        while (lo < hi) {
            mid = (lo + hi) / 2;
            if (A[mid] < target)
                lo = mid + 1;
            else
                hi = mid;
        }

        if (lo >= A.length || A[lo] != target) return ret;
        ret[0] = lo;
        hi = A.length;

        //找出右边界
        while (lo < hi) {
            mid = (lo + hi) / 2;
            if (A[mid] > target)
                hi = mid;
            else
                lo = mid + 1;
        }
        ret[1] = hi - 1;
        return ret;
    }

    public static void main(String args[]) {
        int num[] = {2, 2};
        SearchForARange s = new SearchForARange();
        int ret[] = s.searchRange(num, 3);
        for (int i : ret) {
            System.out.print(i + " ");
        }
    }
}
