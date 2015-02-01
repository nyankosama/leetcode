/*=============================================================================
#
# Author: Nyankosama email:i@nyankosama.com
#
# Last modified: 2015-02-01 03:17
#
# Filename: WordLadderII.cpp
#
# Description: https://oj.leetcode.com/problems/word-ladder-ii/
#
=============================================================================*/

#include <string>
#include <iostream>
#include <vector>
#include <map>
#include <unordered_set>

using namespace std;

/**
 * 判断一个字符串是否可以转换到另外一个字符串，即是否只差一个字符
 */
bool can_change(string& str, string& target) {
    int count = 0;
    for (string::size_type i = 0; i < str.size(); i++){
        if (str[i] != target[i]){
            count++;
        }
        if (count > 1) return false;
    }
    if (count == 1) return true;
    else return false;
}

//使用邻接表表示一副有向图
//图中的每一个节点表示一个字符串
//每一条边表示可以从source转换到dest
//首选预处理start、end、dict来建立这幅图
//使用bfs从start开始遍历，找到从start到end的最短路径即可

class Solution {
public:
    vector<vector<string>> findLadders(string start, string end, unordered_set<string> &dict) {
        vector<vector<string> > ret;
        vector<string> trans_vec;
        trans_vec.insert(trans_vec.begin(), dict.begin(), dict.end());
        map<string, vector<string> > g;
        //TODO
        //1. 做预处理
        //2. bfs
        return ret;
    }
};

int main(){

}
