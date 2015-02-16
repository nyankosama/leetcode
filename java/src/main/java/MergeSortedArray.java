/**
 * @created: 2015/2/16
 * @author: nyankosama
 * @description: https://oj.leetcode.com/problems/merge-sorted-array/
 */
public class MergeSortedArray {

    /**
     * 先把A数组向右rotate n步，然后前面空出来n个位置用来做merge即可
     * @param A
     * @param m
     * @param B
     * @param n
     */
    public void merge(int A[], int m, int B[], int n) {
        moveRight(A, n);
        int iter = 0, low = n, hi = 0;
        while (low < m + n || hi < n) {
            if (hi == n) low = m + n;
            else if (low == m + n) while (hi < n) A[iter++] = B[hi++];
            else if (A[low] < B[hi]) A[iter++] = A[low++];
            else A[iter++] = B[hi++];
        }
    }

    private void moveRight(int a[], int step) {
        reverse(a, 0, a.length - step);
        reverse(a, a.length - step, a.length);
        reverse(a, 0, a.length);
    }

    private void reverse(int a[], int begin, int end) {
        int i = begin, j = end - 1;
        while (i < j) {
            int tmp = a[i];
            a[i] = a[j];
            a[j] = tmp;
            i++;
            j--;
        }
    }


    public static void main(String args[]) {
        int[] a = {1, 4, 5, 6, 7, 0, 0, 0, 0};
        int[] b = {2, 3, 8, 9};
        MergeSortedArray s = new MergeSortedArray();
        s.merge(a, 5, b, 4);
        for (int i : a) {
            System.out.print(i + " ");
        }
    }
}
