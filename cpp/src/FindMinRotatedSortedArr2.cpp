/*=============================================================================
#
# Author: Nyankosama email:i@nyankosama.com
#
# Last modified: 2014-11-12 22:25
#
# Filename: FindMinRotatedSortedArr2.cpp
#
# Description:
#   @Problem: https://oj.leetcode.com/problems/find-minimum-in-rotated-sorted-array-ii/
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
            } else { //A[M] == A[L] == A[R]
                L = L + 1;
            }

        }
        return A[L];
    }
};

int main() {
    int rotatedSortedArrWithDup1[] = {1,1,2,2,3,3,4,5,6,6};
    int rotatedSortedArrWithDup2[] = {3,4,5,6,6,1,1,2,2,3};
    Solution s;
    bool ret1 = s.findMin(rotatedSortedArrWithDup1, 7) == 1;
    bool ret2 = s.findMin(rotatedSortedArrWithDup2, 7) == 1;
    cout << ret1 << endl;
    cout << ret2 << endl;
}



