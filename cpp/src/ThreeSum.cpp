/*=============================================================================
#
# Author: Nyankosama email:i@nyankosama.com
#
# Last modified: 2014-11-12 22:56
#
# Filename: ThreeSum.cpp
#
# Description:
#   @Problem: ttps://oj.leetcode.com/problems/3sum/
#   @tag: array two-pointers
#
=============================================================================*/

#include <vector>
#include <algorithm>
#include <iostream>
#include <set>

using namespace std;

class Solution {
public:
    vector<vector<int> > threeSum(int num[], int n) {
        sort(num, num + n);
        set<vector<int> > set;
        for (int i = 0; i < n - 2; ++i) {
            int start = i + 1, end = n - 1;
            while(start < end) {
                int a = num[i], b = num[start], c = num[end];
                int sum = a + b + c;
                if (sum > 0) {
                    end = end - 1;
                } else if(sum < 0) {
                    start = start + 1;
                } else {
                    vector<int> oneRet;
                    oneRet.push_back(a);
                    oneRet.push_back(b);
                    oneRet.push_back(c);
                    set.insert(oneRet);
                    end = end - 1;
                    start = start + 1;
                }
            }
        }
        vector<vector<int> > result;
        for (auto vec: set) {
            vector<int> oneVec;
            for (auto item:vec) {
                oneVec.push_back(item);
            }
            result.push_back(oneVec);
        }
        return result;
    }
};

int main() {
    int array2[] = {-1, 0, 1, 2, -1, -4};
    Solution s;
    auto resultVec = s.threeSum(array2, 6);
    for (auto vec:resultVec) {
        for (auto item:vec) {
            cout << item << " ";
        }
        cout << endl;
    }
}


