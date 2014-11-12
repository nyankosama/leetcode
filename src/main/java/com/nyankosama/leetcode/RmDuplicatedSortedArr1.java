package com.nyankosama.leetcode;

/**
 * Problem:     https://oj.leetcode.com/problems/remove-duplicates-from-sorted-array/
 * tag:         array two-pointers
 */
public class RmDuplicatedSortedArr1 {
    public int removeDuplicates(int[] A) {
        int N = A.length;
        if (N == 0) return 0;
        int index = 0;
        for (int i = 0; i < N; i++) {
            if (A[index] != A[i]) {
                A[++index] = A[i];
            }
        }
        return index + 1;
    }
}
