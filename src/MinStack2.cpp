#include <stack>
#include <iostream>

using namespace std;

class MinStack {
public:

    void push(int x) {
        if (_min_stack.empty() || x <= _min_stack.top())
            _min_stack.push(x);
        _stack.push(x);
    }

    void pop() {
        if (_stack.top() == _min_stack.top())
            _min_stack.pop();
        _stack.pop();
    }

    int top() {
        return _stack.top();
    }

    int getMin() {
        return _min_stack.top();
    }

private:
    stack<int> _min_stack;
    stack<int> _stack;
};

int main(){
    MinStack s;
    s.push(3);
    s.push(2);
    s.push(1);
    for (int i = 0; i < 3; i++){
        cout << "min:" << s.getMin() << endl;
    }
}
