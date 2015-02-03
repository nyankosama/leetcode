/*=============================================================================
#
# Author: Nyankosama email:i@nyankosama.com
#
# Last modified: 2014-12-09 01:07
#
# Filename: MinStack.cpp
#
# Description: https://oj.leetcode.com/problems/min-stack/
#
=============================================================================*/
#include <iostream>
#include <vector>

using namespace std;

struct StackNode;

typedef StackNode* node_ptr;
typedef vector<node_ptr> node_vec;


struct StackNode {
    int val;
    int k;
    node_ptr next;
    StackNode(int val, int k):val(val), k(k) {}
};

void swap(node_vec& vec, int a, int b){
    int tmpk = vec[a]->k;
    vec[a]->k = vec[b]->k;
    vec[b]->k = tmpk;
    node_ptr tmp = vec[a];
    vec[a] = vec[b];
    vec[b] = tmp;
}

void printPQ(const node_vec& pq){
    cout << "printPQ begin:" << endl;
    for (node_vec::size_type i = 1; i < pq.size(); i++){
        cout << pq[i]->k << ":" << pq[i]->val << endl; 
    }
    cout << "printPQ end:" << endl;
}

class MinStack {
public:
    MinStack():head(NULL), N(0) {
        pq.push_back(new StackNode(0, 0));
    }

    void push(int x) {
        node_ptr node = new StackNode(x, ++N);
        node->next = head;
        head = node;
        pq.push_back(node);
        swim(N);
    }

    void pop() {
        int k = head->k;
        swap(pq, k, N);
        pq.pop_back();
        N--;
        sink(k);
        node_ptr tmp_ptr = head;
        head = head->next;
        delete tmp_ptr;
    }

    int top() {
        return head->val;
    }

    int getMin() {
        return pq[1]->val;
    }

private:
    node_ptr head;
    node_vec pq;
    int N;
    void swim(int k) {
        while(k > 1 && greater(k/2, k)) {
            swap(pq, k/2, k);
            k = k / 2;
        }
    }
    void sink(int k) {
        while (2 * k <= N) {
            int j = 2 * k;
            if (j < N && greater(j, j + 1)) j++;
            if (!greater(k, j)) break;
            swap(pq, k, j);
            k = j;
        }
    }
    bool greater(int a, int b){
        return pq[a]->val > pq[b]->val; 
    }
};

int main(){
    MinStack s;
    s.push(3);
    s.push(1);
    s.push(2);
    for (int i = 0; i < 3; i++){
        cout << "min:" << s.getMin() << endl;
        s.pop();
    }
    cout << endl;
}
