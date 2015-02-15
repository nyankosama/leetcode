/**
 * @created: 2015/2/13
 * @author: nyankosama
 * @description:
 */
public class MaximumSubarray {

    /**
     * http://blog.csdn.net/sgbfblog/article/details/8032464
     * @param A
     * @return
     */
    public int maxSubArray(int[] A) {
        int max = Integer.MIN_VALUE, sum = 0;
        for (int i : A) {
            if (sum <= 0)
                sum = i;
            else
                sum += i;
            max = Math.max(max, sum);
        }
        return max;
    }

    public int maxSubArrayDp(int[] A) {
        int[] s = new int[A.length];
        s[0] = A[0];
        int max = s[0];
        for (int i = 0; i < A.length - 1; i++) {
            s[i + 1] = Math.max(s[i] + A[i + 1], A[i + 1]);
            max = Math.max(max, s[i + 1]);
        }
        return max;
    }

    public static void main(String args[]) {
        int[] a = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        MaximumSubarray s = new MaximumSubarray();
        System.out.println(s.maxSubArrayDp(a));
    }
}
