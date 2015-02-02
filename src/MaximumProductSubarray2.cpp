/*=============================================================================
#
# Author: Nyankosama email:i@nyankosama.com
#
# Last modified: 2014-12-12 04:38
#
# Filename: MaximumProductSubarray2.cpp
#
# Description: https://oj.leetcode.com/problems/maximum-product-subarray/
#
# Solution: O(n)
#
=============================================================================*/


#include <iostream>
#include <algorithm>

using namespace std;

int max3(int a, int b, int c) {
    if (a >= b && a >= c) return a;
    else return max3(b, c, a);
}

int min3(int a, int b, int c){
    if (a <= b && a <= c) return a;
    else return min3(b, c, a);
}

class Solution {
public:
    int maxProduct(int A[], int n) {
        if (n == 0) return 0;
        int max_tmp = A[0];
        int min_tmp = A[0];
        int max_product = A[0];
        for (int i = 1; i < n; i++) {
            int a = A[i] * max_tmp;
            int b = A[i] * min_tmp;
            max_tmp = max3(a, b, A[i]);
            min_tmp = min3(a, b, A[i]);
            max_product = max(max_product, max_tmp);
        }
        return max_product;
    }
};


int main() {
    int A[5] = {1, 2, 3, -1, 100};
    int B[2] = {-3, -4};
    Solution s;
    cout << s.maxProduct(A, 5) << endl;
    cout << s.maxProduct(B, 2) << endl;
}

