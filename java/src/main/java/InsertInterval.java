import java.util.ArrayList;
import java.util.List;

/**
 * @created: 2015/2/15
 * @author: nyankosama
 * @description: https://oj.leetcode.com/problems/insert-interval/
 */
public class InsertInterval {

    /**
     * 因为需要最终合成返回的List，所以直接O(N)遍历即可
     * @param intervals
     * @param newInterval
     * @return
     */
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        ArrayList<Interval> result = new ArrayList<Interval>();

        for (Interval interval : intervals) {
            if (interval.end < newInterval.start) {
                result.add(interval);
            } else if (interval.start > newInterval.end) {
                result.add(newInterval);
                newInterval = interval;
            } else if (interval.end >= newInterval.start || interval.start <= newInterval.end) {
                newInterval = new Interval(Math.min(interval.start, newInterval.start),
                        Math.max(newInterval.end, interval.end));
            }
        }

        result.add(newInterval);

        return result;
    }
}
