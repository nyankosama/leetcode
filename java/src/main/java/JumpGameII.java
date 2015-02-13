/**
 * @created: 2015/2/13
 * @author: nyankosama
 * @description: https://oj.leetcode.com/problems/jump-game-ii/
 */
public class JumpGameII {

    /**
     * 同JumpGame
     * 当max第一次cover到lastIndex的时候就结束，计算step数
     * @param A
     * @return
     */
    public int jump(int[] A) {
        if (A == null || A.length == 0 || A.length == 1) return 0;
        int start = 0, end = 0, step = 0;
        do {
            int max = end;
            for (int i = start; i <= end && i < A.length; i++) {
                max = Math.max(max, A[i] + i);
            }
            start = end;
            end = max;
            step++;
        }
        while (end < A.length - 1 && start < end);
        if (end < A.length - 1) return -1;
        return step;
    }

    public static void main(String args[]) {
        int[] a = new int[]{2, 3, 1, 1, 4};
        JumpGameII s = new JumpGameII();
        System.out.println(s.jump(a));
    }
}
