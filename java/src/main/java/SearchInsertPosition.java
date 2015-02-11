/**
 * @created: 2015/2/11
 * @author: nyankosama
 * @description: https://oj.leetcode.com/problems/search-insert-position/
 */
public class SearchInsertPosition {

    /**
     * 参考SearchForARange
     * 相当于找左边界
     * @param A
     * @param target
     * @return
     */
    public int searchInsert(int[] A, int target) {
        int lo = 0, hi = A.length;
        int mid;
        while (lo < hi) {
            mid = (lo + hi) / 2;
            if (A[mid] < target)
                lo = mid + 1;
            else
                hi = mid;
        }
        return lo;
    }

    public static void main(String args[]) {
        SearchInsertPosition s = new SearchInsertPosition();
        int num[] = {1, 3, 5, 6};
        System.out.println(s.searchInsert(num, 5));
        System.out.println(s.searchInsert(num, 2));
        System.out.println(s.searchInsert(num, 7));
        System.out.println(s.searchInsert(num, 0));
    }
}
