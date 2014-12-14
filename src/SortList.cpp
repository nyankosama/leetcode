/*=============================================================================
#
# Author: Nyankosama email:i@nyankosama.com
#
# Last modified: 2014-12-14 00:12
#
# Filename: SortList.cpp
#
# Description: https://oj.leetcode.com/problems/sort-list/
#
=============================================================================*/
#include <iostream>
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
    ListNode *sortList(ListNode *head) {
        if (head == NULL) return NULL;
        int len = 0;
        ListNode* iter = head;
        while (iter != NULL){
            ++len;
            iter = iter->next;
        }
        return mergeSort(head, len);
    }

private:
    ListNode* mergeSort(ListNode*& head, int length){
        if (length == 1){
            ListNode* tmp = head;
            head = head->next;
            tmp->next = NULL;
            return tmp;
        } 
        ListNode* leftHead = mergeSort(head, length / 2);
        ListNode* rightHead = mergeSort(head, length - length / 2);
        ListNode* newNode = merge(leftHead, rightHead);
        return newNode;
    }

    ListNode* merge(ListNode* leftHead, ListNode* rightHead){
        ListNode dummy(-1);
        ListNode* head1 = leftHead, *head2 = rightHead, *tail = &dummy;
        while(head1 != NULL && head2 != NULL){
            if (head1->val < head2->val){tail->next = head1; head1 = head1->next;}
            else {tail->next = head2; head2 = head2->next;}
            tail = tail->next;
        }
        if (head1 == NULL) tail->next = head2;
        if (head2 == NULL) tail->next = head1;
        return dummy.next;
    }
};

int main(){
    Solution s;
    ListNode* list1 = makeList({1, 4, 3, 2});
    printList(list1);
    ListNode* newList = s.sortList(list1);
    printList(newList);
}

