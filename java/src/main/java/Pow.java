/**
 * @created: 2015/2/13
 * @author: nyankosama
 * @description: https://oj.leetcode.com/problems/powx-n/
 */
public class Pow {

    /**
     * 递归，O(nlogn)
     * @param x
     * @param n
     * @return
     */
    public double pow(double x, int n) {
        if (n == 0) return 1;
        if (n == 1) return x;
        double midVal = pow(x, Math.abs(n / 2));
        if (n > 0) {
            if ((n & 1) == 1) {
                return midVal * midVal * x;
            } else {
                return midVal * midVal;
            }
        } else {
            if ((n & 1) == 1) {
                return 1.0 / (midVal * midVal * x);
            } else {
                return 1.0 / (midVal * midVal);
            }
        }
    }

    public static void main(String args[]) {
        Pow s = new Pow();
        System.out.println(s.pow(0.00001, 2147483647));
//        System.out.println(Math.pow(0.00001, 2147483647));
    }
}
