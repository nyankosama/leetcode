/**
 * @created:    2015/2/3
 * @author:     i@nyankosama.com
 *
 * @description: https://oj.leetcode.com/problems/string-to-integer-atoi/
 */
public class StringtoInteger {
    public int atoi(String str) {
        if (str == null || str.length() < 1)
            return 0;

        str = str.trim();
        char flag = '+';
        int i = 0;
        if (str.charAt(i) == '-') {
            flag = '-';
            i++;
        } else if (str.charAt(i) == '+') {
            flag = '+';
            i++;
        }

        double result = 0;

        while (str.length() > i && str.charAt(i) >= '0' && str.charAt(i) <= '9') {
            result = result * 10 + (str.charAt(i) - '0');
            i++;
        }

        if (flag == '-') result = -result;

        if (result > Integer.MAX_VALUE) return Integer.MAX_VALUE;
        if (result < Integer.MIN_VALUE) return Integer.MIN_VALUE;

        return (int) result;
    }

    public static void main(String args[]) {
        StringtoInteger s = new StringtoInteger();
        String t1 = "  3214";
        String t2 = "  -3214";
        System.out.println(s.atoi(t1));
        System.out.println(s.atoi(t2));
    }
}
