/*=============================================================================
#
# Author: Nyankosama email:i@nyankosama.com
#
# Last modified: 2015-02-01 01:36
#
# Filename: Anagrams.cpp
#
# Description: https://oj.leetcode.com/problems/anagrams/
#
=============================================================================*/

/**
 * 思路
 * 要找到anagram，首先对每一个字符串进行字符排序，这样如果是anagram就会完全相同，然后再使用hashmap来存储相同的字符串，最后输出
 */

#include <iostream>
#include <vector>
#include <map>
#include <algorithm>

using namespace std;

class Solution {
public:
    typedef map<string, vector<string> > map_type;

    vector<string> anagrams(vector<string> &strs) {
        vector<string> ret;
        map_type map;
        if (strs.size() == 0) return ret;
        for (vector<string>::iterator iter = strs.begin(); iter != strs.end(); ++iter){
            string::size_type size = iter->size();
            char* tmp = new char[size + 1];
            iter->copy(tmp, size);
            sort(tmp, tmp + size);
            tmp[size] = '\0';
            string tmp_str(tmp);
            if (map.count(tmp_str) == 0){
                vector<string> tmp_vec;
                tmp_vec.push_back(*iter);
                map[tmp_str] = tmp_vec;
            }else{
                vector<string>& tmp_vec = map[tmp_str];
                tmp_vec.push_back(*iter);
            }
        }

        for (map_type::iterator iter = map.begin(); iter != map.end(); ++iter){
            if (iter->second.size() > 1) {
                ret.insert(ret.end(), iter->second.begin(), iter->second.end());
            }
        }
        return ret;
    }
};

int main(){
    vector<string> strs = {"123", "321", "213", "12", "21", "ab", "ba", "abc"};
    Solution s;
    vector<string> ret = s.anagrams(strs);
    for_each(ret.begin(), ret.end(), [](string& str){cout << str << " ";});
}
