package com.nyankosama.leetcode;

/**
 * Problem:     https://oj.leetcode.com/problems/remove-duplicates-from-sorted-array-ii/
 * tag:         array two-pointers
 */
public class RmDuplicatedSortedArr2 {

    public int removeDuplicates(int[] A) {
        int N = A.length;
        if (N <= 2) return N;
        int index = 2;
        for (int i = 2; i < N; i++) {
            if (A[index - 2] != A[i]) {
                A[index++] = A[i];
            }
        }
        return index;
    }
}
