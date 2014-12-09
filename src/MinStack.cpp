#include <iostream>
#include <vector>
#include <algorithm>
#include <memory>

using namespace std;


struct StackNode {
    int val;
    int k;
    StackNode* next;
    StackNode(int val, int k):val(val), k(k) {}
};

void swap(shared_ptr<StackNode> a, shared_ptr<StackNode> b){
    int tmpk = b->k;
    b->k = a->k;
    a->k = tmpk;   
    shared_ptr<StackNode> tmp = b;
    b = a;
    a = tmp;
}

void printPQ(const vector<shared_ptr<StackNode>>& pq){
    cout << "printPQ begin:" << endl;
    for (vector<shared_ptr<StackNode>>::size_type i = 1; i < pq.size(); i++){
        cout << pq[i]->k << ":" << pq[i]->val << endl; 
    }
    cout << "printPQ end:" << endl;
}

class MinStack {
public:
    MinStack():head(NULL) {
        pq.push_back(make_shared<StackNode>(0, 0));
    }

    void push(int x) {
        cout << "push:" << x << endl;
        StackNode* node = new StackNode(x, ++N);
        node->next = head;
        head = node;
        pq.push_back(shared_ptr<StackNode>(node));
        swim(N);
        printPQ(pq);
        cout << "head:" << head->val << endl;
    }

    void pop() {
        cout << "pop:" << head->val << endl;
        using std::swap;
        int k = head->k;
        head = head->next;
        swap(pq[k], pq[N]);
        pq.pop_back();
        N--;
        sink(k);
        printPQ(pq);
    }

    int top() {
        return head->val;
    }

    int getMin() {
        return pq[1]->val;
    }

private:
    StackNode* head;
    vector<shared_ptr<StackNode>> pq;
    int N;
    void swim(int k) {
        using std::swap;
        while(k > 1 && greater(k/2, k)) {
            swap(pq[k/2], pq[k]);
            k = k / 2;
        }
    }
    void sink(int k) {
        using std::swap;
        while (2 * k <= N) {
            int j = 2 * k;
            if (j < N && greater(j, j + 1)) j++;
            if (!greater(k, j)) break;
            swap(pq[k], pq[j]);
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
    s.push(2);
    s.push(1);
    for (int i = 0; i < 3; i++){
        s.pop();
    }
    cout << endl;
}
