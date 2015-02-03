/*=============================================================================
#
# Author: Nyankosama email:i@nyankosama.com
#
# Last modified: 2015-02-01 00:48
#
# Filename: addBinary.cpp
#
# Description: https://oj.leetcode.com/problems/add-binary/
#
=============================================================================*/

/**
 * 思路：
 * 1. 通过逐一读取字符串的方式将每一个string转换成十进制，然后在将两个十进制相加得到结果，最后再转换成二进制字符串
 *
*/

#include <iostream>
#include <string>
#include <algorithm>

using namespace std;

class Solution {
public:
    string addBinary(string a, string b) {
        string::size_type max_length = a.size() > b.size() ? a.size() : b.size();
        std::reverse(a.begin(), a.end());
        std::reverse(b.begin(), b.end());
        int carry = 0; //进位
        string result;
        for (string::size_type i = 0; i < max_length; i++){
            int ai = i < a.size() ? a[i] - '0' : 0;
            int bi = i < b.size() ? b[i] - '0' : 0;
            int val = (ai + bi + carry) % 2; //当前位的值
            carry = (ai + bi + carry) / 2; //更新进位
            result.insert(result.begin(), val + '0');
        }

        if (carry == 1){
            result.insert(result.begin(), '1');
        }
        return result;
    }
};

int main(){
    string a = "11";
    string b = "1";
    Solution s;
    string ret = s.addBinary(a, b);
    cout << ret << endl;
}
