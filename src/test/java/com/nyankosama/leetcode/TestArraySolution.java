package com.nyankosama.leetcode;

import org.junit.Test;

/**
 * Created by i@nyankosama.com on 2014/11/9.
 */
public class TestArraySolution {
    private static final int NUM_SIZE = 10;
    private int[] rotatedSortedArr1 = {0,1,2,3,4,5,6};
    private int[] rotatedSortedArr2 = {6,0,1,2,3,4,5};
    private int[] rotatedSortedArr3 = {3,4,5,6,0,1,2};

    private int[] rotatedSortedArrWithDup1 = {1,1,2,2,3,3,4,5,6,6};
    private int[] rotatedSortedArrWithDup2 = {3,4,5,6,6,1,1,2,2,3};

    @Test
    public void TestFindMinRotatedSortedArr1() {
        assert FindMinRotatedSortedArr1.findMin(rotatedSortedArr1) == 0;
        assert FindMinRotatedSortedArr1.findMin(rotatedSortedArr2) == 0;
        assert FindMinRotatedSortedArr1.findMin(rotatedSortedArr3) == 0;
    }

    @Test
    public void TestFindMinRotatedSortedArr2() {
        assert FindMinRotatedSortedArr2.findMin(rotatedSortedArrWithDup1) == 1;
        assert FindMinRotatedSortedArr2.findMin(rotatedSortedArrWithDup2) == 1;
    }
}
