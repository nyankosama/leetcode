/*=============================================================================
#
# Author: Nyankosama email:i@nyankosama.com
#
# Last modified: 2014-12-12 18:18
#
# Filename: ReverseWordsinaString.cpp
#
# Description: https://oj.leetcode.com/problems/reverse-words-in-a-string/
#
=============================================================================*/

#include <iostream>
#include <vector>

using namespace std;

class Solution {
public:
    void reverseWords(string &s) {
        int N = s.size();
        string tmp(N, ' ');
        int begin = 0;
        int end = N;
        for (int i = 0; i < N; i++){
            if (s[i] == ' ' || i == N - 1){
                int length = 0;
                if (i == N - 1 && s[i] != ' ')  length = i + 1 - begin;
                else                            length = i - begin;

                for (int j = end - length; j < end; j++){
                    tmp[j] = s[begin + j - (end - length)];
                }
                begin = i + 1;
                end = end - length - 1;
            }
        }
        s = trim(tmp);
    }

private:
    string trim(string& str){
        int N = str.size();
        vector<char> tmp;
        bool start_end = false;
        for (int i = 0; i < N; i++){
            if (str[i] == ' ' && !start_end){
                continue;
            } else{
                start_end = true;
                tmp.push_back(str[i]);
            }
        }
        string tmp_str(tmp.size(), ' ');
        for (vector<char>::size_type i = 0; i < tmp.size(); i++) tmp_str[i] = tmp[i];
        return tmp_str;
    }
};

int main(){
    string str = "1   123";
    Solution s;
    s.reverseWords(str);
    cout << str << endl;
}
