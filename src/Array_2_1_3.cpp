#include <iostream>
#include <algorithm>
using namespace std;


class Solution {
public:
    int search(int A[], int n, int target) {
        int first = 0; int last = n;
        while (first != last){
            int mid = (first + last) / 2;
            if (A[mid] == target)
                return mid;
            if (A[first] <= A[mid]){
                if (A[first] <= target && target <= A[mid]){
                    last = mid; 
                }
                else{
                    first = mid + 1; 
                }
            }
            else{
                if (A[mid] <= target && target <= A[last-1]){
                    first = mid + 1;
                }
                else{
                    last = mid; 
                }
            }
        }
        return -1;
    }
};

int main(){
    int a[] = {1,2,3,3,3,4,4,5,6,6,7};
    Solution s;
    int size = sizeof(a)/sizeof(int);
    int target = 2;
    int index = s.search(a, size, target);
    cout << "array: ";
    for_each(a, a+size, [](int i){cout << i << " ";});
    cout << endl;
    cout << "target:" << target << endl;
    cout << "result index:" << index << endl;
}
