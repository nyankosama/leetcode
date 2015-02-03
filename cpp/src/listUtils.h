/*=============================================================================
#
# Author: Nyankosama email:i@nyankosama.com
#
# Last modified: 2015-02-01 01:13
#
# Filename: listUtils.h
#
# Description: list problems common header file
#
=============================================================================*/

#include <iostream>
#include <vector>

struct ListNode {
    int val;
    ListNode *next;
    ListNode(int x) : val(x), next(NULL) {}
};

ListNode* makeList(const std::vector<int>& nodeVal) {
    if (nodeVal.size() == 0) return NULL;
    ListNode* head = new ListNode(nodeVal[0]);
    ListNode* iter = head;
    for (std::vector<int>::size_type i = 1; i < nodeVal.size(); i++) {
        iter->next = new ListNode(nodeVal[i]);
        iter = iter->next;
    }
    return head;
}

void printList(ListNode* head) {
    if (head == NULL) return;
    for (ListNode* iter = head; iter != NULL; iter = iter->next)
        std::cout << iter->val << "->";
    std::cout << "Nil" << std::endl;
}
