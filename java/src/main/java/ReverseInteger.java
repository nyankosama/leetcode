import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @created: 2015/2/8
 * @author: nyankosama
 * @description: https://oj.leetcode.com/problems/reverse-integer/
 */
public class ReverseInteger {

    /**
     * 注意整数越界的 conner case
     * @param x
     * @return
     */
    public int reverse(int x) {
        if (x == Integer.MIN_VALUE) return 0;
        int flag = 1;
        if (x < 0) {
            flag = -1;
            x *= flag;
        }

        int digit = 0;
        Queue<Integer> nums = new LinkedList<Integer>();
        while (x != 0) {
            nums.offer(x % 10);
            x /= 10;
            digit++;
        }
        int ret = 0;
        for (int i = digit - 1; i >= 0; i--) {
            ret += nums.poll() * Math.pow(10, i);
        }
        if (ret == Integer.MAX_VALUE) return 0;
        return ret * flag;
    }

    public static void main(String args[]) {
        ReverseInteger s = new ReverseInteger();
        System.out.println(s.reverse(1534236469));
    }
}

