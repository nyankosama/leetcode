package com.nyankosama.leetcode;

/**
 * Problem:     https://oj.leetcode.com/problems/find-minimum-in-rotated-sorted-array/
 * tag:         array binary-search
 */
public class FindMinRotatedSortedArr1 {

    //liner solution
    public static int findMinMySolution(int[] num) {
        //1. firstly, liner scan the array to find the where the pivot is
        //2. obviously, the minimum number is the pivot
        int N = num.length;
        int pivot = 0; // if the array is already sorted, we will still go through
        for (int i = 0; i < N - 1; i++) {
            if (num[i] > num[i + 1]){
                pivot = i + 1;
                break;
            }
        }
        return num[pivot];
    }

    //binary-search logN solution
    public static int findMin(int[] num) {
        int L = 0, R = num.length - 1;
        while (L < R && num[L] >= num[R]) {
            int M = (L + R) / 2;
            if (num[M] > num[R]) {
                L = M + 1;
            } else if (num[M] < num[L]) {
                R = M;
            }
        }
        return num[L];
    }
}
