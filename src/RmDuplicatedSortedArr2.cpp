/*=============================================================================
#
# Author: Nyankosama email:i@nyankosama.com
#
# Last modified: 2014-11-12 22:13
#
# Filename: RmDuplicatedSortedArr1.cpp
#
# Description: 
#   @Problem: https://oj.leetcode.com/problems/remove-duplicates-from-sorted-array-ii/ 
#   @tag: array two-pointers
#
=============================================================================*/
#include <iostream>
#include <algorithm>
using namespace std;


class Solution {
public:
    int removeDuplicates(int A[], int n) {
        if (n <= 2) {
            return 0;
        }
        int index = 2;
        for (int i = 2; i < n; i++) {
            if (A[index - 2] != A[i]) {
                A[index++] = A[i];
            }
        }
        return index;
    }
};

int main(){
    int a[] = {1,2,3,3,3,4,4,5,6,6,7};
    Solution s;
    int size = sizeof(a)/sizeof(int);
    cout << "size = " << size << endl;
    int newSize = s.removeDuplicates(a, size);
    for_each(a, a+newSize, [](int p) {cout << p << " ";});
}
