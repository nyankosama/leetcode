/*=============================================================================
#
# Author: Nyankosama email:i@nyankosama.com
#
# Last modified: 2015-02-02 01:03
#
# Filename: ValidParentheses.cpp
#
# Description: https://oj.leetcode.com/problems/valid-parentheses/
#
=============================================================================*/

/**
 * 思路:
 * 使用stack进行匹配即可
 */

#include "common.h"

bool match(char l, char r) {
    if ((l == '(' && r == ')')
            || (l == '{' && r == '}')
            || (l == '[' && r == ']'))
        return true;
    else
        return false;
}

class Solution {
public:
    bool isValid(string s) {
        stack<char> ps;
        for (string::iterator iter = s.begin(); iter != s.end(); ++iter) {
            if (*iter == '(' || *iter == '{' || *iter == '[') {
                ps.push(*iter);
            } else if (*iter == ')' || *iter == '}' || *iter == ']') {
                if (ps.empty()) return false;
                char pop = ps.top();
                ps.pop();
                if (!match(pop, *iter)) return false;
            } else
                return false;
        }
        if (ps.empty()) return true;
        else return false;
    }
};

int main() {
    string t1 = "()[]";
    string t2 = "";
    string t3 = "()[";
    Solution s;
    cout << s.isValid(t1) << endl;
    cout << s.isValid(t2) << endl;
    cout << s.isValid(t3) << endl;
}


