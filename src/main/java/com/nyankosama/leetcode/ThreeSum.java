package com.nyankosama.leetcode;

import java.util.*;

/**
 * Problem:     https://oj.leetcode.com/problems/3sum/
 * tag:         array two-pointers
 */
public class ThreeSum {

    public static List<List<Integer>> threeSum(int[] num) {
        Arrays.sort(num);
        Set<List<Integer>> resultSet = new HashSet<>();
        int N = num.length;
        for (int i = 0; i < N - 2; i++) {
            int start = i + 1;
            int end = N - 1;
            while (start < end) {
                int a = num[i], b = num[start], c = num[end];
                int sum = a + b + c;
                if (sum > 0) {
                    end = end - 1;
                } else if (sum < 0) {
                    start = start + 1;
                } else {
                    List<Integer> oneRet = new ArrayList<Integer>();
                    oneRet.add(a);
                    oneRet.add(b);
                    oneRet.add(c);
                    resultSet.add(oneRet);
                    end = end - 1;
                    start = start + 1;
                }
            }
        }
        return new ArrayList<>(resultSet);
    }
}
