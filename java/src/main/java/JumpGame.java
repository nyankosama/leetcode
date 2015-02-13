/**
 * @created: 2015/2/13
 * @author: nyankosama
 * @description: https://oj.leetcode.com/problems/jump-game/
 */
public class JumpGame {

    /**
     * 找最大cover范围
     * @param A
     * @return
     */
    public boolean canJump(int[] A) {
        if (A == null || A.length == 0) return false;
        int start = 0, end = 0;
        do {
            int max = end;
            for (int i = start; i <= end && i < A.length; i++) {
                max = Math.max(max, A[i] + i);
            }
            start = end;
            end = max;
        }
        while (start < end);
        return end >= A.length - 1;
    }

    /**
     * Naive动态规划，O(n^2)
     * @param A
     * @return
     */
    public boolean canJumpNaive(int[] A) {
        if (A == null || A.length == 0) return false;
        boolean[] reach = new boolean[A.length];
        reach[0] = true;
        for (int i = 0; i < A.length; i++) {
            if (reach[i]) {
                for (int j = 1; j <= A[i]; j++) {
                    reach[i + j < A.length ? i + j : A.length - 1] = true;
                }
            }
        }
        return reach[A.length - 1];
    }

    public static void main(String args[]) {
        JumpGame s = new JumpGame();
        int[] a = new int[]{3,2,1,0,4};
        System.out.println(s.canJump(a));
    }
}
