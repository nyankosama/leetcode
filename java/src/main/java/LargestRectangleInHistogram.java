import java.util.Arrays;
import java.util.Stack;

/**
 * @created: 2015/2/16
 * @author: nyankosama
 * @description: https://oj.leetcode.com/problems/largest-rectangle-in-histogram/
 */
public class LargestRectangleInHistogram {

    /**
     * 见：http://www.cnblogs.com/lichen782/p/leetcode_Largest_Rectangle_in_Histogram.html
     * @param height
     * @return
     */
    public int largestRectangleArea(int[] height) {
        Stack<Integer> stack = new Stack<Integer>(); //维护一个单调递增的bar stack的索引栈
        int i = 0;
        int maxArea = 0;
        int[] h;
        h = Arrays.copyOf(height, height.length + 1); //最后一个面积为0，方便计算所有bar都用到的矩形面积
        while(i < h.length){
            if(stack.isEmpty() || h[stack.peek()] <= h[i]){
                stack.push(i++);
            }else {
                int t = stack.pop();
                maxArea = Math.max(maxArea, h[t] * (stack.isEmpty() ? i : i - stack.peek() - 1));
            }
        }
        return maxArea;
    }
}
