/**
 * @created: 2015/2/13
 * @author: nyankosama
 * @description: https://oj.leetcode.com/problems/trapping-rain-water/
 */
public class TrappingRainWater {

    /**
     * 动态规划
     * 两趟扫描，一趟从左往右一趟从右往左
     * 生成一个数组，第一趟得出每一个bar左边的最大高度
     * 第二趟得出每一个bar两边的最小高度，然后顺便计算出该bar位置的容水量，累加即可
     * @param A
     * @return
     */
    public int trap(int[] A) {
        if (A == null || A.length == 0) return 0;
        int[] container = new int[A.length];
        int max = 0;
        int ret = 0;
        for (int i = 0; i < A.length; i++) {
            container[i] = max;
            max = Math.max(max, A[i]);
        }
        max = 0;
        for (int i = A.length - 1; i >= 0; i--) {
            container[i] = Math.min(container[i], max);
            max = Math.max(max, A[i]);
            ret += container[i] - A[i] > 0 ? container[i] - A[i] : 0;
        }
        return ret;
    }
}
