/*=============================================================================
#
# Author: Nyankosama email:i@nyankosama.com
#
# Last modified: 2015-01-12 05:03
#
# Filename: MaximumGap.cpp
#
# Description: https://oj.leetcode.com/problems/maximum-gap/
#
# Solution: bucket sort http://www.tuicool.com/articles/INNfiaj
#
=============================================================================*/

#include <iostream>
#include <vector>
#include <algorithm>
#include <limits>

using namespace std;

class Solution {
public:
    int maximumGap(vector<int> &num) {
        int size = num.size();
        if (size < 2) return 0;
        //find the min and max number
        int min = numeric_limits<int>::max();
        int max = 0;
        for(vector<int>::iterator iter = num.begin(); iter != num.end(); ++iter) {
            if (min > *iter) min = *iter;
            if (max < *iter) max = *iter;
        }
        int bucket_len = ceil((double)(max - min) / (size - 1));
        int bucket_num = (max - min) / bucket_len + 1;
        int *bucket_max = new int[bucket_num];
        int *bucket_min = new int[bucket_num];
        bool *bucket_not_empty = new bool[bucket_num];
        for (int i = 0; i < bucket_num; i++) bucket_min[i] = numeric_limits<int>::max();
        for(vector<int>::iterator iter = num.begin(); iter != num.end(); ++iter) {
            int loc = (*iter - min) / bucket_len;
            bucket_not_empty[loc] = true;
            if (bucket_max[loc] < *iter) bucket_max[loc] = *iter;
            if (bucket_min[loc] > *iter) bucket_min[loc] = *iter;
        }
        int max_diff = 0;
        int start = 0;
        int end = start + 1;
        while(end < bucket_num) {
            if (!bucket_not_empty[start]) {
                start++;
                end++;
            } else {
                if (bucket_not_empty[end]) {
                    int diff = bucket_min[end] - bucket_max[start];
                    if (max_diff < diff) max_diff = diff;
                    start = end;
                    end = start + 1;
                } else {
                    while(end < bucket_num) {
                        end++;
                        if (bucket_not_empty[end]) break;
                    }
                    if (end >= bucket_num) return 0;
                    int diff = bucket_min[end] - bucket_max[start];
                    if (max_diff < diff) max_diff = diff;
                    start = end;
                    end = start + 1;
                }
            }
        }
        return max_diff;
    }
};

int main() {
    Solution s;
    vector<int> t3 = {100,3,2,1};
    cout << s.maximumGap(t3) << endl;
}
