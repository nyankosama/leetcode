#include <vector>
#include <algorithm>
#include <iostream>

using namespace std;

class ThreeSum{
public:
    vector<vector<int> > threeSum(int num[], int n){
        sort(num, num + n);   
        //unique(num, num + n);
        vector<vector<int> > resultList;
        for (int i = 0; i < n - 2; i++){
            int start = i + 1;
            int end = n - 1;
            int a = num[i], b = num[start], c = num[end];
            while (start < end){
                if (a + b + c == 0){
                    vector<int> oneRet;
                    oneRet.push_back(a);
                    oneRet.push_back(b);
                    oneRet.push_back(c);
                    resultList.push_back(oneRet);
                    end = end - 1;
                    start = start + 1;
                }
                else if(a + b + c < 0){
                    start = start + 1; 
                }
                else{
                    end = end - 1;
                }
            }
        }
        return resultList;
    }
};


int main(){
    int array[] = {-1, 0, 1, 2, -1, -4};
    ThreeSum solution;
    auto ret = solution.threeSum(array, 6);
    for (auto retList : ret){
        for (auto item : retList){
            cout << item << " ";
        } 
        cout << endl;
    }
}
