/*=============================================================================
#
# Author: Nyankosama email:i@nyankosama.com
#
# Last modified: 2015-02-01 01:01
#
# Filename: addTwoNumbers.cpp
#
# Description: https://oj.leetcode.com/problems/add-two-numbers/
#
=============================================================================*/

/**
 * 思路：
 * 简单地通过逐个位做加法实现
 * 这里难点在于对进位的处理
 */

#include "listUtils.h"

using namespace std;


class Solution {
public:
    ListNode *addTwoNumbers(ListNode *l1, ListNode *l2) {
        if (l1 == NULL || l2 == NULL) return NULL;
        ListNode* head = NULL;
        ListNode* tail = NULL;
        int carry = 0;
        while(l1 != NULL || l2 != NULL) {
            int l1v = l1 != NULL ? l1->val : 0;
            int l2v = l2 != NULL ? l2->val : 0;
            if (tail == NULL) {
                tail = new ListNode((l1v + l2v + carry) % 10);
                head = tail;
            } else {
                tail->next = new ListNode((l1v + l2v + carry) % 10);
                tail = tail->next;
            }
            carry = (l1v + l2v + carry) / 10;
            if (l1 != NULL) l1 = l1->next;
            if (l2 != NULL) l2 = l2->next;
        }
        if (carry != 0) {
            tail->next = new ListNode(carry);
        }
        return head;
    }
};

int main(){
    ListNode* l1 = makeList({5});
    ListNode* l2 = makeList({5});
    Solution s;
    ListNode* ret = s.addTwoNumbers(l1, l2);
    printList(l1);
    printList(l2);
    printList(ret);
}
