package com.nyankosama.leetcode;

/**
 * Problem:     https://oj.leetcode.com/problems/search-in-rotated-sorted-array-ii/
 * tag:         array binary-search
 */
public class SearchRotatedSortedArr2 {

    //binary-search
    public static boolean searchMySolution(int[] A, int target) {
        int L = 0, R = A.length - 1;
        while (L < R) {
            int M = (L + R) / 2;
            if (A[M] > A[R]) {              //index M lays at the left of pivot   eg:4567(M)123
                if (A[L] <= target && target <= A[M]) {
                    R = M;
                    continue;
                } else {
                    L = M + 1;
                }
            } else if (A[M] < A[L]) {       //index M lays at the right of pivot  eg:5671(M)234
                if (A[M] <= target && target <= A[R]) {
                    L = M;
                } else {
                    R = M - 1;
                }
            } else {
                //not be sure the array is already sorted, eg: [1,3,1,1,1] target = 3
                //just shift L to see the next number
                if (A[L] == target) return true; //make sure the edge value
                L = L + 1;
            }
        }
        if (A[L] == target) return true;
        else                return false;
    }
}
