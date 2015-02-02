/*=============================================================================
#
# Author: Nyankosama email:i@nyankosama.com
#
# Last modified: 2015-02-02 01:04
#
# Filename: ValidPalindrome.cpp
#
# Description: https://oj.leetcode.com/problems/valid-palindrome/
#
=============================================================================*/

/**
 * 思路：
 * 首先去掉所有标点符号和空格
 * 如果原字符串和reverse过后的字符串相同，则是回文
 */

#include <sstream>
#include "common.h"


class Solution {
public:
    bool isPalindrome(string s) {
        ostringstream os;
        for (string::iterator iter = s.begin(); iter != s.end(); ++iter) {
            if (isalpha(*iter) || isdigit(*iter)) os << static_cast<char>(tolower(*iter));
        }
        string clean_str = os.str();
        string reverse_str = clean_str;
        reverse(reverse_str.begin(), reverse_str.end());
        if (clean_str == reverse_str) return true;
        else return false;
    }
};

int main() {
    Solution s;
    string t1 = "A man, a plan, a canal: Panama";
    string t2 = "121";
    cout << s.isPalindrome(t1) << endl;
    cout << s.isPalindrome(t2) << endl;
}

