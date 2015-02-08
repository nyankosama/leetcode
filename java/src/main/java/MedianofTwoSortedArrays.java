import java.util.Arrays;

/**
 * @created: 2015/2/8
 * @author: nyankosama
 * @description: https://oj.leetcode.com/problems/median-of-two-sorted-arrays/
 */
public class MedianofTwoSortedArrays {

    /**
     * 解法参见 http://www.acmerblog.com/leetcode-median-of-two-sorted-arrays-5330.html
     * @param A
     * @param B
     * @return
     */
    public double findMedianSortedArrays(int A[], int B[]) {
        int total = A.length + B.length;
        if ((total & 0x01) == 1) {
            return findKth(A, A.length, B, B.length, total / 2 + 1);
        } else {
            return (findKth(A, A.length, B, B.length, total / 2)
                    + findKth(A, A.length, B, B.length, total / 2 + 1)) / 2;
        }
    }

    private double findKth(int a[], int m, int b[], int n, int k) {
        if (m > n) {
            return findKth(b, n, a, m, k);
        }
        if (m == 0) return b[k - 1];
        if (k == 1) return Math.min(a[0], b[0]);

        int pa = Math.min(k / 2, m), pb = k - pa;
        if (a[pa - 1] < b[pb - 1]) {
            return findKth(Arrays.copyOfRange(a, pa, a.length), m - pa, b, n, k - pa);
        } else if (a[pa - 1] > b[pb - 1]) {
            return findKth(a, m, Arrays.copyOfRange(b, pb, b.length), n - pb, k - pb);
        } else {
            return a[pa - 1];
        }
    }

    public static void main(String args[]) {
        MedianofTwoSortedArrays s = new MedianofTwoSortedArrays();
        int a[] = {1, 2, 5, 6, 7};
        int b[] = {};
        System.out.println(s.findMedianSortedArrays(a, b));
    }
}
