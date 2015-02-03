/*=============================================================================
#
# Author: Nyankosama email:i@nyankosama.com
#
# Last modified: 2014-11-12 22:25
#
# Filename: FindMinRotatedSortedArr1.cpp
#
# Description:
#   @Problem: https://oj.leetcode.com/problems/find-minimum-in-rotated-sorted-array/
#   @tag:   rray binary-search
#
=============================================================================*/
#include <iostream>

using namespace std;

class Solution {
public:
    int findMin(int A[], int N) {
        int L = 0, R = N - 1;
        while (L < R && A[L] >= A[R]) {
            int M = (L + R) / 2;
            if (A[M] > A[R]) {
                L = M + 1;
            } else if (A[M] < A[L]) {
                R = M;
            }
        }
        return A[L];
    }
};

int main() {
    int rotatedSortedArr1[] = {0,1,2,3,4,5,6};
    int rotatedSortedArr2[] = {6,0,1,2,3,4,5};
    int rotatedSortedArr3[] = {3,4,5,6,0,1,2};
    Solution s;
    bool ret1 = s.findMin(rotatedSortedArr1, 7) == 0;
    bool ret2 = s.findMin(rotatedSortedArr2, 7) == 0;
    bool ret3 = s.findMin(rotatedSortedArr3, 7) == 0;
    cout << ret1 << endl;
    cout << ret2 << endl;
    cout << ret3 << endl;
}


