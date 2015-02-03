/*=============================================================================
#
# Author: Nyankosama email:i@nyankosama.com
#
# Last modified: 2014-12-09 01:07
#
# Filename: FindPeekElement.cpp
#
# Description: https://oj.leetcode.com/problems/find-peak-element/
#
=============================================================================*/
#include <iostream>
#include <vector>

using namespace std;

bool isPeak(const vector<int>& num, int a, int b, int c) {
    int N = num.size();
    if (a < 0) {
        return num[b] > num[c];
    } else if(c >= N) {
        return num[b] > num[a];
    } else {
        return num[a] < num[b] && num[b] > num[c];
    }
}

class Solution {
public:
    int findPeakElement(const vector<int> &num) {
        int N = num.size();
        if (N == 1) return 0;
        for (int i = 0; i < N; i++) {
            if (isPeak(num, i - 1, i, i + 1))
                return i;
        }
        return -1;
    }
};

int main() {
    vector<int> num1 = {1,2,3,4,5};
    vector<int> num2 = {2,1,3,5,4};
    Solution s;
    cout << "vector<int> num1 = {1,2,3,4,5}" << endl;
    cout << s.findPeakElement(num1) << endl;
    cout << "vector<int> num2 = {1,2,3,5,4}" << endl;
    cout << s.findPeakElement(num2) << endl;
}



