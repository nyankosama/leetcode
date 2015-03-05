import java.util.HashSet;
import java.util.Set;

/**
 * @created: 2015/3/5
 * @author: nyankosama
 * @description: https://oj.leetcode.com/problems/longest-consecutive-sequence/
 */
public class LongestConsecutiveSequence {

    /**
     * 由于要求O(n)，所以不能排序，只能用空间换时间，使用HashSet
     * @param num
     * @return
     */
    public int longestConsecutive(int[] num) {
        if (num.length == 0) {
            return 0;
        }

        Set<Integer> set = new HashSet<Integer>();
        int max = 1;

        for (int e : num)
            set.add(e);

        for (int e : num) {
            int left = e - 1;
            int right = e + 1;
            int count = 1;

            while (set.contains(left)) {
                count++;
                set.remove(left);
                left--;
            }

            while (set.contains(right)) {
                count++;
                set.remove(right);
                right++;
            }
            max = Math.max(count, max);
        }

        return max;
    }
}
