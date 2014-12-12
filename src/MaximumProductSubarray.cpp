/*=============================================================================
#
# Author: Nyankosama email:i@nyankosama.com
#
# Last modified: 2014-12-12 03:55
#
# Filename: MaximumProductSubarray.cpp
#
# Description: https://oj.leetcode.com/problems/maximum-product-subarray/
#
# Solution: basic dp problem O(n2)
#
=============================================================================*/
#include <iostream>
#include <algorithm>

using namespace std;

class Solution {
public:
    int maxProduct(int A[], int n) {
        if (n == 1) return A[0];
        int* P = new int[n + 1];
        int* start = new int[n + 1];
        P[0] = 0;
        P[1] = A[0];
        start[0] = 0;
        start[1] = 0;
        for (int i = 1; i <= n; i++){
            int new_max = P[i - 1];
            int new_start = 0;
            int tmp_product = product(A, start[i-1], i);
            for (int j = start[i-1]; j < i; j++){
                if (new_max < tmp_product){
                    new_max = tmp_product;
                    new_start = j;
                }
                if (A[j] == 0)
                    tmp_product = product(A, j+1, i);
                else
                    tmp_product /= A[j];

            }
            P[i] = new_max;
            start[i] = new_start;
        }
        int ret = P[n];
        delete P;
        delete start;
        return ret;
    }

private:
    int product(int A[], int lo, int hi){
        int p = 1;
        for (int i = lo; i < hi; i++){
            p *= A[i];
        }
        return p;
    }
};

int main(){
    int A[5] = {1,2,3,-1,100};
    int E[2] = {0, 2};
    Solution s;
    cout << s.maxProduct(A, 5) << endl;
    cout << s.maxProduct(E, 2) << endl;
}
