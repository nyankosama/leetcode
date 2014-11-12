package com.nyankosama.leetcode;

import java.util.Arrays;

/**
 * Problem:     https://oj.leetcode.com/problems/3sum-closest/
 * tag:         array two-pointers
 */
public class ThreeSumClosest {

    public static int threeSumClosest(int[] num, int target) {
        Arrays.sort(num);
        int N = num.length;
        int totalResult = target + Integer.MAX_VALUE;
        for (int i = 0; i < N - 2; i++) {
            int start = i + 1;
            int end = N - 1;
            int result = target + Integer.MAX_VALUE;
            while (start < end) {
                int sum = num[i] + num[start] + num[end];
                int diff = sum - target;
                if (diff > 0) {
                    end = end - 1;
                }else if (diff < 0) {
                    start = start + 1;
                } else {
                    return target;
                }
                if (Math.abs(diff) < Math.abs(result - target)) result = sum;
            }
            if (Math.abs(result - target) < Math.abs(totalResult - target)) {
                totalResult = result;
            }
        }
        return totalResult;
    }
}
