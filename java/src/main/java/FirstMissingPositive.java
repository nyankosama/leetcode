/**
 * @created: 2015/2/13
 * @author: nyankosama
 * @description: https://oj.leetcode.com/problems/first-missing-positive/
 */
public class FirstMissingPositive {

    /**
     * 交换位置，让下标与数字对应即可
     * 注意边界条件
     * @param A
     * @return
     */
    public int firstMissingPositive(int[] A) {
        if (A.length == 0) return 1;
        for (int i = 0; i < A.length; i++) {
            while (A[i] > 0 && A[i] < A.length && A[i] != i + 1 && A[A[i] - 1] != A[i]) {
                swap(A, A[i] - 1, i);
            }
        }
        for (int i = 0; i < A.length; i++) {
            if (A[i] - 1 != i) return i + 1;
        }
        return A.length + 1;
    }

    private void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void main(String args[]) {
        FirstMissingPositive s = new FirstMissingPositive();
        int[] a = new int[]{1, 1};
        System.out.println(s.firstMissingPositive(a));
        a = new int[]{1, 2, 0};
        System.out.println(s.firstMissingPositive(a));
        a = new int[]{3, 4, -1, 1};
        System.out.println(s.firstMissingPositive(a));
    }
}
