/*=============================================================================
#
# Author: Nyankosama email:i@nyankosama.com
#
# Last modified: 2015-02-02 01:22
#
# Filename: WildcardMatching.cpp
#
# Description: https://oj.leetcode.com/problems/wildcard-matching/
#
=============================================================================*/

/**
 * 参见：http://www.cnblogs.com/flowerkzj/p/3726667.html
 */

#include "common.h"
#include "string.h"

class Solution {
public:
    /**
     * 递归方案， TLE了
     */
    bool isMatchNaive(const char *s, const char *p) {
        if (*p == '\0') return *s == '\0';
        if (*p != '*')
            return ((*p == *s) || (*p == '?' && *s != '\0')) && isMatchNaive(s+1, p+1);
        while (*(p+1) == '*') p+=1;
        while (*s != '\0') {
            if (isMatchNaive(s, p+1)) return true;
            s++;
        }
        return isMatchNaive(s, p+1);
    }

    /**
     * 动态规划方案
     */
    bool isMatch(const char *s, const char *p) {
        int slen = strlen(s);
        int plen = strlen(p);
        vector<vector<bool>> dp(slen + 1, vector<bool>(plen + 1));
        dp[0][0] = true;
        for (int i = 1; i <= plen; i++)
            if (p[i - 1] == '*') dp[0][i] = dp[0][i - 1];

        for (int i = 1; i <= slen; i++){
            for (int j = 1; j <= plen; j++){
                char sctr = s[i - 1];
                char pctr = p[j - 1];
                if (sctr == pctr || pctr == '?'){
                    dp[i][j] = dp[i - 1][j - 1];
                } else if (pctr == '*'){
                    dp[i][j] = dp[i][j - 1] || dp[i - 1][j];
                }
            }
        }

        return dp[slen][plen];
    }
};

int main() {
    Solution s;
    const char* tmp = "aa";
    cout << s.isMatch(tmp, "*") << endl;
}

