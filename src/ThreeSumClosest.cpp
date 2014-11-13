/*=============================================================================
#
# Author: Nyankosama email:i@nyankosama.com
#
# Last modified: 2014-11-12 22:56
#
# Filename: ThreeSum.cpp
#
# Description:
#   @Problem: https://oj.leetcode.com/problems/3sum-closest/
#   @tag: array two-pointers
#
=============================================================================*/

#include <algorithm>
#include <iostream>
#include <limits>
#include <cstdlib>

using namespace std;

class Solution {
public:
    int threeSumClosest(int num[], int n, int target) {
        sort(num, num + n);
        const int MAX_VALUE = numeric_limits<int>::max();
        int totalResult = target + MAX_VALUE;
        for (int i = 0; i < n - 2; ++i) {
            int start = i + 1;
            int end = n - 1;
            int result = target + MAX_VALUE;
            while (start < end) {
                int sum = num[i] + num[start] + num[end];
                int diff = sum - target;
                if (diff > 0) {
                    end = end - 1;
                } else if (diff < 0) {
                    start = start + 1;
                } else {
                    return target;
                }
                if (abs(diff) < abs(result - target)) result = sum;
            }
            if (abs(result - target) < abs(totalResult - target)) {
                totalResult = result;
            }
        }
        return totalResult;
    }
};


int main() {
    int array1[] = {-1, 2, 1, -4};
    Solution s;
    bool ret = s.threeSumClosest(array1, 4, 1) == 2;
    cout << ret << endl;
}




