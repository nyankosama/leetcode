/**
 * @created: 2015/2/8
 * @author: nyankosama
 * @description: https://oj.leetcode.com/problems/container-with-most-water/
 */
public class ContainerWithMostWater {

    /**
     * 思想：
     * 两个pointer不断往中间靠拢，并更新maxArea
     * 移动高度更小的pointer，因为移动高度更高的pointer的话，水槽的高度还是不可能大于高度较小的pointer，所以没有意义
     * @param height
     * @return
     */
    public int maxArea(int[] height) {
        int max = Integer.MIN_VALUE;
        int left = 0, right = height.length - 1;
        while (left <= right) {
            max = Math.max(max, Math.min(height[left], height[right]) * (right - left));
            if (height[left] < height[right])
                left++;
            else
                right--;
        }
        return max;
    }
}
