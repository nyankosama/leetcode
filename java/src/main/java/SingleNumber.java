/**
 * @created: 2015/3/5
 * @author: nyankosama
 * @description: https://oj.leetcode.com/problems/single-number/
 */
public class SingleNumber {

    public int singleNumber(int[] A) {
        int x = 0;
        for (int i : A) x ^= i;
        return x;
    }
}
