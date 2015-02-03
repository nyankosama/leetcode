/*=============================================================================
#
# Author: Nyankosama email:i@nyankosama.com
#
# Last modified: 2015-01-12 04:46
#
# Filename: FactorialTrailingZeroes.cpp
#
# Description: https://oj.leetcode.com/problems/factorial-trailing-zeroes/
#
# Solution: http://bookshadow.com/weblog/2014/12/30/leetcode-factorial-trailing-zeroes/
#
=============================================================================*/

#include <iostream>

using namespace std;

class Solution {
public:
    int trailingZeroes(int n) {
        long ans = 0;
        long x = 5;
        while(n >= x){
            ans += n / x;
            x *= 5;
        }
        return ans;
    }
};

int factorial(int n){
    int ret = 1;
    for (int i = 1; i <= n; i++){
        ret *= i;
    }
    return ret;
}

int main(){
    Solution s;
    cout << "10! = " << factorial(5) << endl;
    cout << "n = " << s.trailingZeroes(5) << endl;
    cout << "15! = " << factorial(12) << endl;
    cout << "n = " << s.trailingZeroes(12) << endl;
    cout << "n = " << s.trailingZeroes(2147483647) << endl;
}
