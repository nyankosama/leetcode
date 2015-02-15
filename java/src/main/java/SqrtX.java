/**
 * @created: 2015/2/15
 * @author: nyankosama
 * @description: https://oj.leetcode.com/problems/sqrtx/
 */
public class SqrtX {

    /**
     * 二分法
     * @param x
     * @return
     */
    public int sqrt(int x) {
        int lo = 0, hi = x;
        while (lo <= hi) {
            int mid = (lo + hi) / 2;
            int sq = mid * mid;
            if (sq == x)
                return mid;
            else if (sq < x)
                lo = mid + 1;
            else
                hi = mid - 1;
        }
        return hi;
    }

    public static void main(String args[]) {
        SqrtX s = new SqrtX();
        System.out.println(s.sqrt(1));
        System.out.println(s.sqrt(2));
        System.out.println(s.sqrt(3));
        System.out.println(s.sqrt(4));
        System.out.println(s.sqrt(5));
    }
}
