/**
 * @created: 2015/2/10
 * @author: nyankosama
 * @description: https://oj.leetcode.com/problems/divide-two-integers/
 */
public class DivideTwoIntegers {

    /**
     * 使用位运算的方式
     * @param dividend
     * @param divisor
     * @return
     */
    public int divide(int dividend, int divisor) {
        if (divisor == 0) return Integer.MAX_VALUE;
        if (dividend == 0) return 0;
        long lDividend = dividend;
        long lDivisor = divisor;
        int flag = 1;
        if ((lDividend < 0 && lDivisor > 0) ||
                (lDividend > 0 && lDivisor < 0)) {
            flag = -1;
        }
        lDividend = Math.abs(lDividend);
        lDivisor = Math.abs(lDivisor);
        long r = lDividend;
        long ret = 0;
        while (r >= lDivisor) {
            long k = 1;
            long shiftNum = lDivisor;
            while ((shiftNum <<= 1) <= r) k <<= 1; //关键在这里
            ret += k;
            r -= (shiftNum >> 1);
        }
        ret = ret * flag;
        if (ret > Integer.MAX_VALUE || ret < Integer.MIN_VALUE)
            return Integer.MAX_VALUE;
        else
            return (int) ret;
    }

    public static void main(String args[]) {
        DivideTwoIntegers s = new DivideTwoIntegers();
        System.out.println(s.divide(-2147483648, -1));
    }
}
