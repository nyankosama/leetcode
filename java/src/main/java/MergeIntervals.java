import java.util.*;

/**
 * @created: 2015/2/15
 * @author: nyankosama
 * @description: https://oj.leetcode.com/problems/merge-intervals/
 */
public class MergeIntervals {

    /**
     * 排序即可
     * @param intervals
     * @return
     */
    public List<Interval> merge(List<Interval> intervals) {
        List<Interval> ret = new ArrayList<Interval>();
        if (intervals == null || intervals.size() == 0) return ret;
        Collections.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                return ((Integer) o1.start).compareTo(o2.start);
            }
        });
        int start = intervals.get(0).start;
        int maxEnd = intervals.get(0).end;
        for (Interval interval : intervals) {
            if (maxEnd >= interval.start) {
                maxEnd = Math.max(maxEnd, interval.end);
            } else {
                ret.add(new Interval(start, maxEnd));
                start = interval.start;
                maxEnd = interval.end;
            }
        }
        ret.add(new Interval(start, maxEnd));
        return ret;
    }

    public static void main(String args[]) {
        List<Interval> tmp = new ArrayList<Interval>();
        tmp.addAll(Arrays.asList(new Interval(1, 3), new Interval(2, 6), new Interval(8, 10), new Interval(15, 18)));
        MergeIntervals s = new MergeIntervals();
        for (Interval interval : s.merge(tmp)) {
            System.out.println("[" + interval.start + "," + interval.end + "]");
        }
    }
}
