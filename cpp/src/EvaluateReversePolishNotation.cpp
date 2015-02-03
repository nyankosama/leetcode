/*=============================================================================
#
# Author: Nyankosama email:i@nyankosama.com
#
# Last modified: 2014-12-12 03:53
#
# Filename: EvaluateReversePolishNotation.cpp
#
# Description: https://oj.leetcode.com/problems/evaluate-reverse-polish-notation/
#
=============================================================================*/
#include <iostream>
#include <vector>
#include <stack>
#include <string>

using namespace std;

class Solution {
public:
    int evalRPN(vector<string> &tokens) {
        //operand stack
        stack<int> operands;
        int N = tokens.size();
        for (int i = 0; i < N; i++) {
            string token = tokens[i];
            if (isOperator(token)) {
                int right = operands.top(); operands.pop();
                int left = operands.top(); operands.pop();
                operands.push(calculate(left, right, token));
            } else {
                operands.push(stoi(token));
            }
        }
        return operands.top();
    }

private:
    bool isOperator(string expr) {
        if (expr == "+" || expr == "-" || expr == "*" || expr == "/")
            return true;
        else
            return false;
    }
    int calculate(int left, int right, string op){
        if (op == "+"){
            return left + right;  
        } else if (op == "-"){
            return left - right; 
        } else if (op == "*"){
            return left * right;
        } else{
            return left / right; 
        }
    }
};

int main(){
    vector<string> test1 ={"2", "1", "+", "3", "*"};
    vector<string> test2 ={"4", "13", "5", "/", "+"};
    Solution s;
    cout << s.evalRPN(test1) << endl;
    cout << s.evalRPN(test2) << endl;
}
