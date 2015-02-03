/*=============================================================================
#
# Author: Nyankosama email:i@nyankosama.com
#
# Last modified: 2014-12-09 01:07
#
# Filename: IntersectionOfTwoLinkedList.cpp
#
# Description: https://oj.leetcode.com/problems/intersection-of-two-linked-lists/
#
=============================================================================*/
#include <iostream>
#include <algorithm>
#include <vector>

using namespace std;


struct ListNode {
    int val;
    ListNode *next;
    ListNode(int x) : val(x), next(NULL) {}
};

ListNode* makeList(const vector<int>& nodeVal) {
    if (nodeVal.size() == 0) return NULL;
    ListNode* head = new ListNode(nodeVal[0]);
    ListNode* iter = head;
    for (vector<int>::size_type i = 1; i < nodeVal.size(); i++) {
        iter->next = new ListNode(nodeVal[i]);
        iter = iter->next;
    }
    return head;
}

void printList(ListNode* head) {
    if (head == NULL) return;
    for (ListNode* iter = head; iter != NULL; iter = iter->next)
        cout << iter->val << "->";
    cout << "Nil" << endl;
}


class Solution {
public:
    ListNode *getIntersectionNode(ListNode *headA, ListNode *headB) {
        if (headA == NULL || headB == NULL) return NULL;
        //first find the each list's depth
        int depthA = 0, depthB = 0;
        for (ListNode* iter = headA; iter->next != NULL; iter = iter->next) depthA++;
        for (ListNode* iter = headB; iter->next != NULL; iter = iter->next) depthB++;
        if (depthA < depthB){
            std::swap(headA, headB); //headA is more deep
            std::swap(depthA, depthB);
        }         
        ListNode* iterA = headA;
        ListNode* iterB = headB;
        for (int i = 0; i < depthA - depthB; i++)
            iterA = iterA->next;
        if (iterA == iterB) return iterA;
        while(iterA != NULL) {
            if (iterA == iterB) return iterA;
            iterA = iterA->next;
            iterB = iterB->next;
        }
        return NULL;
    }
};


int main() {
    ListNode* list1 = makeList({11,12,31,32});
    ListNode* list2 = makeList({21, 22, 23});
    ListNode* iter = list2->next->next;
    iter->next = list1->next->next;
    iter->next->next = list1->next->next->next;
    printList(list1);
    printList(list2);
    Solution s;
    cout << s.getIntersectionNode(list1, list2)->val << endl;
}



